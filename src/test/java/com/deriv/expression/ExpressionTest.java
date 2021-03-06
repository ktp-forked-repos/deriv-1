package com.deriv.expression;

import org.junit.jupiter.api.Test;

import static com.deriv.expression.Log.*;
import static com.deriv.expression.Mult.*;
import static com.deriv.expression.Add.*;
import static com.deriv.expression.Constant.*;
import static com.deriv.expression.Trig.*;
import static com.deriv.expression.Variable.*;
import static com.deriv.expression.Power.*;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

  @Test
  void typeCheckTest() {
    Expression mult = mult(x(), e());
    assertTrue(mult.isMult());

    Expression ad = add(x(), multID());
    assertTrue(ad.isAdd());

    Expression lo = log(e(), x());
    assertTrue(lo.isLog());

    Expression pow = poly(x(), 2);
    assertTrue(pow.isPower());

    Expression trig = sin(x());
    assertTrue(trig.isTrig());

    Expression con = constant(17);
    assertTrue(con.isConstant());

    Expression va = var("y");
    assertTrue(va.isVariable());
  }

  @Test
  void typeCastTest() {
    Expression mult = mult(x(), e());
    assertTrue(mult.asMult().isMult());

    Expression ad = add(x(), multID());
    assertTrue(ad.asAdd().isAdd());

    Expression lo = log(e(), x());
    assertTrue(lo.asLog().isLog());

    Expression pow = poly(x(), 2);
    assertTrue(pow.asPower().isPower());

    Expression trig = sin(x());
    assertTrue(trig.asTrig().isTrig());

    Expression con = constant(17);
    assertTrue(con.asConstant().isConstant());

    Expression va = var("y");
    assertTrue(va.asVariable().isVariable());
  }

  @Test
  void getterTest() {
    // e * x
    Expression mult = mult(x(), e());

    assertEquals(multID(), mult.getConstantFactor());
    assertEquals(mult, mult.getSymbolicFactors());

    // x + 1
    Expression ad = add(x(), multID());

    assertEquals(multID(), ad.getExponent());
    assertEquals(ad, ad.getNumerator());
    assertEquals(multID(), ad.getDenominator());

    // x ^ 2
    Expression pow = poly(x(), 2);

    assertEquals(constant(2), pow.getExponent());
    assertEquals(x(), pow.getBase());
    assertEquals(multID(), pow.getConstantFactor());
    assertFalse(pow.isNegative());

    // one more test to really beat up the Mult getters
    Expression mult2 = mult(constant(2), poly(constant(3), -1));
    assertEquals(multID(), mult2.getSymbolicFactors());
    assertEquals(mult2, mult2.getConstantFactor());
  }

  @Test
  void equalityTest() {
    // to increase code coverage, we need to test the same thing for each
    // implementation of Expression
    int num = 5;

    // x + 1
    Expression ex = add(multID(), x());
    assertNotEquals(ex, 5);
    assertEquals(ex, ex);

    // 1
    Expression ex2 = multID();
    assertNotEquals(ex2, num);
    assertEquals(ex2, ex2);

    // ln(x)
    Expression ex3 = ln(x());
    assertNotEquals(ex3, num);
    assertNotEquals(ex3, log(constant(10), x()));
    assertEquals(ex3, ex3);

    // 2x
    Expression ex4 = mult(constant(2), x());
    assertNotEquals(ex4, num);
    assertEquals(ex4, ex4);

    // x ^ 2
    Expression ex5 = poly(x(), 2);
    assertNotEquals(ex5, num);
    assertNotEquals(ex5, poly(x(), 3));
    assertEquals(ex5, ex5);

    // sin(x)
    Expression ex6 = sin(x());
    assertNotEquals(ex6, num);
    assertEquals(ex6, ex6);

    // y
    Expression ex7 = var("y");
    assertNotEquals(ex7, num);
    assertEquals(ex7, ex7);
  }

  @Test
  void newOne() {
    Expression expr = add(x(), poly(x(), 2));
    System.out.println(expr.differentiate(x().asVariable()));
  }
}