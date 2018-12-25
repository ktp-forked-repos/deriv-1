package horeilly1101.Expression;

public class Constant implements Expression {
  private Double val;

  /**
   * Instantiates a new Constant. Avoid using as much as possible! Use the
   * easy constructor below instead.
   *
   * Data definition: A constant is a double.
   */
  private Constant(Double val) {
    this.val = val;
  }

  /**
   * Use this to create new constants. This method is for constants
   * that are explicitly numbers.
   */
  static Constant constant(Double val) {
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

  Double getVal() {
    return val;
  }

  @Override
  public Constant getConstantFactor() {
    return this;
  }

  @Override
  public Constant getSymbolicFactors() {
    return multID();
  }

  @Override
  public Boolean isNegative() {
    return this.getVal() < 0;
  }

  static Constant multID() {
    return constant(1.0);
  }

  static Constant addID() {
    return constant(0.0);
  }

  static Expression e() {
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
    return con.val.equals(this.val);
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode() + 11;
  }

  @Override
  public String toString() {
    return val.toString();
  }

  public Expression evaluate(String var, Double input) {
    return this;
  }

  public Expression differentiate(String var) {
    return constant(0.0);
  }
}