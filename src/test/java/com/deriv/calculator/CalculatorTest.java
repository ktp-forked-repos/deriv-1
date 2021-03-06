package com.deriv.calculator;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
//  @Test
//  void differentiateTest() {
//    Calculator calc = new Calculator();
//    System.out.println(calc.differentiate("x", "x").get());
//    System.out.println(calc.differentiate("x", "x").get());
//  }

  @Test
  void evaluateTest() {
    Calculator calc = new Calculator();
    System.out.println(calc.evaluate("x + 2x - 5x", "x", "1").get());
  }

//  @Test
//  void derivativeStepsTest() {
//    Calculator calc = new Calculator();
//    System.out.println(calc.differentiateWithSteps("x", "x").get());
//
//    System.out.println(calc.toOExpression("sin(x)"));
//    System.out.println(calc.differentiateWithSteps("sin(x)", "x").get());
//  }
}
