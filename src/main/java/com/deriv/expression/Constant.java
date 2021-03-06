package com.deriv.expression;

import java.util.Optional;

public class Constant implements Expression {
  /**
   * The integer value of a constant.
   */
  private Integer _val;

  /**
   * Instantiates a new Constant. Avoid using as much as possible! Use the
   * easy constructor below instead.
   *
   * Data definition: A constant is a double.
   */
  private Constant(Integer _val) {
    this._val = _val;
  }

  /**
   * Use this to create new constants. This method is for constants
   * that are explicitly numbers.
   */
  public static Expression constant(Integer val) {
    return new Constant(val);
  }

  /**
   * Use this to create new constants. This allows you to create
   * arbitrary constants.
   */
  static Expression constant(String val) {
    // yeah, yeah I know it says variable
    return new Variable(val);
  }

  public Integer getVal() {
    return _val;
  }

  @Override
  public Expression getConstantFactor() {
    return this;
  }

  @Override
  public Expression getSymbolicFactors() {
    return multID();
  }

  @Override
  public Boolean isNegative() {
    return this.getVal() < 0;
  }

  public static Expression multID() {
    return constant(1);
  }

  public static Expression addID() {
    return constant(0);
  }

  public static Expression e() {
    return new Variable("e");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof Constant)) {
      return false;
    }

    Constant con = (Constant) o;
    return con._val.equals(this._val);
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode() + 11;
  }

  @Override
  public String toString() {
    return _val.toString();
  }

  @Override
  public String toLaTex() {
    return _val.toString();
  }

  public Optional<Expression> evaluate(Variable var, Expression input) {
    return Optional.of(this);
  }

  public Optional<Expression> differentiate(Variable var) {
    return Optional.of(addID());
  }
}