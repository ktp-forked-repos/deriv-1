package com.deriv.expression;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.deriv.expression.Log.*;
import static com.deriv.expression.Mult.*;
import static com.deriv.expression.Add.*;
import static com.deriv.expression.Constant.*;
import static com.deriv.expression.Variable.*;
import static com.deriv.expression.Power.*;
import static org.junit.jupiter.api.Assertions.*;


class PowerTest {
  @Test
  void powerTest() {
    // make sure everything runs properly
    power(x(), x());
  }

  @Test
  void simplifyTest() {
    // 2.0 ^ 3.0
    Expression ex = power(constant(2), constant(3));
    assertEquals(constant(8), ex);

    // 3.0 ^ 1.0
    Expression ex2 = power(constant(3), multID());
    assertEquals(constant(3), ex2);

    // ln(x) ^ 0.0
    Expression ex3 = poly(ln(x()), 0);
    assertEquals(multID(), ex3);

    // ln(x) ^ 1.0
    Expression ex4 = poly(ln(x()), 1);
    assertEquals(ln(x()), ex4);

    // 2 ^ -2
    Expression ex5 = poly(constant(2), -2);
    assertEquals(poly(constant(4), -1), ex5);

    // 1 ^ x
    Expression ex6 = power(multID(), x());
    assertEquals(multID(), ex6);

    // (xln(x)) ^ 2
    Expression ex7 = poly(mult(x(), ln(x())), 2);
    assertEquals(mult(poly(x(), 2), poly(ln(x()), 2)), ex7);

    Expression ex8 = poly(poly(x(), 2), 3);
    System.out.println(ex8);
    assertEquals(poly(x(), 6), ex8);
    assertTrue(ex8.asPower().isSimplified());
  }

  @Test
  void evaluateTest() {
    // 5 ^ x
    Expression ex = exponential(5, x());
    Optional<Expression> eval = ex.evaluate(x().asVariable(), constant(3));
    assertTrue(eval.isPresent());
    assertEquals(constant(125), eval.get());

    // x ^ 4
    Expression ex2 = poly(x(), 4);
    Optional<Expression> eval2 = ex2.evaluate(x().asVariable(), constant(2));
    assertTrue(eval2.isPresent());
    assertEquals(constant(16), eval2.get());

    // x ^ x
    Expression ex3 = power(x(), x());
    Optional<Expression> eval3 = ex3.evaluate(x().asVariable(), constant(3));
    assertTrue(eval3.isPresent());
    assertEquals(constant(27), eval3.get());

    // 1 / 0
    Expression ex4 = poly(x(), -1);
    assertEquals(Optional.empty(), ex4.evaluate(x().asVariable(), addID()));
  }

  @Test
  void differentiateTest() {
    // 5 ^ x
    Expression ex = exponential(3, x());
    assertEquals(mult(power(constant(3), x()), ln(constant(3))), ex.differentiate(x().asVariable()).get());

    // x ^ 4
    Expression ex2 = poly(x(), 4);
    assertEquals(mult(constant(4), poly(x(), 3)), ex2.differentiate(x().asVariable()).get());

    // x ^ x
    Expression ex3 = power(x(), x());
    assertEquals(mult(add(multID(), ln(x())), power(x(), x())), ex3.differentiate(x().asVariable()).get());
  }
}
