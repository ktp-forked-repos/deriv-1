package com.deriv.parser;

import com.deriv.expression.Expression;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static com.deriv.expression.Add.*;
import static com.deriv.expression.Constant.*;
import static com.deriv.expression.Log.ln;
import static com.deriv.expression.Log.log;
import static com.deriv.expression.Mult.*;
import static com.deriv.expression.Variable.*;
import static com.deriv.expression.Trig.*;
import static com.deriv.expression.Power.*;
import static com.deriv.parser.Parser.parse;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
  /**
   * This method tests (a) that the input can be parsed to an Expression
   * and (b) that the parsed expression is equal to the expected expression.
   */
  private static void testHelper(Expression expected, String input) {
    Optional<Expression> parsed = parse(input);
    assertTrue(parsed.isPresent());
    assertEquals(expected, parsed.get());
  }

  @Test
  void addTest() {
    String str = "sin(x) + 12";
    Expression ex = add(sin(x()), constant(12));
    testHelper(ex, str);

    String str2 = "1 + 12";
    Expression ex2 = constant(13);
    testHelper(ex2, str2);

    String str3 = "1 + 1 + 1 + 1 + 1";
    Expression ex3 = constant(5);
    testHelper(ex3, str3);

    String str4 = "5 + 0";
    Expression ex4 = constant(5);
    testHelper(ex4, str4);
  }

  @Test
  void subtractTest() {
    String str = "sin(x) - 12";
    Expression ex = add(sin(x()), constant(-12));
    testHelper(ex, str);

    String str2 = "1 - 12";
    Expression ex2 = constant(-11);
    testHelper(ex2, str2);

    String str3 = "1 - 1 - 1 - 1 - 1";
    Expression ex3 = constant(-3);
    testHelper(ex3, str3);

    String str4 = "5 - 0";
    Expression ex4 = constant(5);
    testHelper(ex4, str4);

    String str5 = "5 - (ln(x) + sin(x))";
    Expression ex5 = add(constant(5), negate(add(ln(x()), sin(x()))));
    testHelper(ex5, str5);
  }

  @Test
  void minusMinusTest() {
    // minus minus should be equal to a plus
    String str = "sin(x) - -12";
    Expression ex = add(sin(x()), constant(12));
    testHelper(ex, str);

    String str2 = "1 - -12";
    Expression ex2 = constant(13);
    testHelper(ex2, str2);

    String str3 = "1 - -1 - -1 - -1 - -1";
    Expression ex3 = constant(5);
    testHelper(ex3, str3);

    String str4 = "5 - -0";
    Expression ex4 = constant(5);
    testHelper(ex4, str4);
  }

  @Test
  void plusMinusTest() {
    // plus minus should be equal to a minus
    String str = "sin(x) + -12";
    Expression ex = add(sin(x()), constant(-12));
    testHelper(ex, str);

    String str2 = "1 + -12";
    Expression ex2 = constant(-11);
    testHelper(ex2, str2);

    String str3 = "1 + -1 + -1 + -1 + -1";
    Expression ex3 = constant(-3);
    testHelper(ex3, str3);

    String str4 = "5 + -0";
    Expression ex4 = constant(5);
    testHelper(ex4, str4);

    String str5 = "5 + -(ln(x) + sin(x))";
    Expression ex5 = add(constant(5), negate(add(ln(x()), sin(x()))));
    testHelper(ex5, str5);
  }

  @Test
  void multTest() {
    String str = "sin(x) * 12";
    Expression ex = mult(sin(x()), constant(12));
    testHelper(ex, str);

    String str2 = "1 * 12";
    Expression ex2 = constant(12);
    testHelper(ex2, str2);

    String str3 = "2 * 2 * 2 * 2 * 2";
    Expression ex3 = constant(32);
    testHelper(ex3, str3);

    String str4 = "5 * 0";
    Expression ex4 = addID();
    testHelper(ex4, str4);
  }

  @Test
  void implicitMultiplicationTest() {
    String str = "12sin(x)";
    Expression ex = mult(sin(x()), constant(12));
    testHelper(ex, str);

    String str2 = "ln(x)cos(x)tan(x)";
    Expression ex2 = mult(ln(x()), cos(x()), tan(x()));
    testHelper(ex2, str2);

    // BROKEN
//    String str3 = "x ^ 2sin(x)";
//    System.out.println(parse(str3));

    String str4 = "xsin(x) / x";
    Expression ex4 = sin(x());
    testHelper(ex4, str4);
  }

  @Test
  void divTest() {
    String str = "sin(x) / 12";
    Expression ex = div(sin(x()), constant(12));
    testHelper(ex, str);

    String str2 = "12 / 2";
    Expression ex2 = constant(6);
    testHelper(ex2, str2);

    String str3 = "2 / (1 / [1 / (1 / 2)])";
    Expression ex3 = constant(4);
    testHelper(ex3, str3);

    String str4 = "0 / 5";
    Expression ex4 = addID();
    testHelper(ex4, str4);

    String str5 = "5 / 1";
    Expression ex5 = constant(5);
    testHelper(ex5, str5);
  }

  @Test
  void carrotTest() {
    String str = "x ^ 5 + x ^ 2 - x + 9";
    Expression ex = add(poly(x(), 5), poly(x(), 2), negate(x()), constant(9));
    testHelper(ex, str);

    // BROKEN
//    String str2 = "x ^ -1";
//    System.out.println(parse(str2));

    String str3 = "(x + 5) ^ x";
    Expression ex3 = power(add(x(), constant(5)), x());
    testHelper(ex3, str3);

    String str4 = "x ^ (x + 5)";
    Expression ex4 = power(x(), add(x(), constant(5)));
    testHelper(ex4, str4);

    String str5 = "5 ^ x";
    Expression ex5 = exponential(5, x());
    testHelper(ex5, str5);
  }

  @Test
  void sqrtTest() {
    String str = "sqrt(x)";
    Expression ex = poly(x(), -2);
    testHelper(ex, str);

    // BROKEN
//    String str2 = "sqrt(4)";
//    Expression ex2 = constant(2);
//    testHelper(ex2, str2);
  }

  @Test
  void logTest() {
    String str = "xlog(5, x)";
    Expression ex = mult(x(), log(constant(5), x()));
    testHelper(ex, str);

    String str2 = "xlog(e, x)";
    Expression ex2 = mult(x(), ln(x()));
    testHelper(ex2, str2);

    String str3 = "xln(x)";
    testHelper(ex2, str3);

    String str4 = "log(x)";
    Expression ex4 = log(constant(10), x());
    testHelper(ex4, str4);
  }

  @Test
  void trigTest() {

  }

  @Test
  void orderOfOperationsTest() {

  }

  @Test
  void breakTest() {
    String str = "x +";
    assertEquals(Optional.empty(), parse(str));

    String str2 = "x + + 5";
    assertEquals(Optional.empty(), parse(str2));

    String str3 = "8 & 4";
    assertEquals(Optional.empty(), parse(str3));
  }

  @Test
  void thereAndBackAgainTest() {

  }
}