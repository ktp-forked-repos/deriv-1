package com.deriv.server;

import com.deriv.expression.Expression;
import org.json.JSONObject;
import java.util.Optional;

import static com.deriv.parser.Parser.parse;
import static spark.Spark.*;

public class Server {
  /**
   * An easy constructor for an empty JSON Object. Helps clean up
   * the code a little bit.
   */
  private static JSONObject jobject() {
    return new JSONObject();
  }

  /**
   * Attempts to parse a string to an optional (Expression) variable.
   */
  private static Optional<String> parseVar(String var) {
    return var.length() == 1
               ? parse(var).map(Expression::toString)
               : Optional.empty();
  }

  /**
   * Attempts to parse a String to an optional Double.
   */
  private static Optional<Double> parseDouble(String val) {
    Optional<Double> oVal;
    try {
      oVal = Optional.of(new Double(val));
    } catch (NumberFormatException e) {
      oVal = Optional.empty();
    }
    return oVal;
  }

  /**
   * Attempts to differentiate an expression using monadic error handling.
   */
  private static Optional<Expression> oDifferentiate(String expr, String var) {
    // attempt to parse var
    Optional<String> oVar = parseVar(var);

    // attempt to parse expr
    Optional<Expression> oExpr = parse(expr);

    // attempt to differentiate function
    return oVar.flatMap(vr ->
                            oExpr.map(ex -> ex.differentiate(vr)));
  }

  /**
   * Attempts to evaluate an expression using monadic error handling.
   */
  private static Optional<Expression> oEvaluate(String expr,
                                                String var,
                                                String val) {
    // attempt to parse val
    Optional<Double> oVal = parseDouble(val);

    // attempt to parse var
    Optional<String> oVar = parseVar(var);

    // attempt to parse expr
    Optional<Expression> oExpr = parse(expr);

    return oVal.flatMap(vl ->
                            oVar.flatMap(vr ->
                                             oExpr.flatMap(ex -> ex.evaluate(vr, vl))));
  }

  /**
   * Returns a JSON object error message.
   */
  private static JSONObject error() {
    return jobject()
              .put("error",
                  jobject()
                      .put("code", 400)
                      .put("problem", "input(s) not valid"));
  }

  /**
   * Returns a JSON object corresponding to the differentiate route.
   */
  private static JSONObject diffObject(Expression result, String expr, String var) {
    return jobject()
              .put("data",
                  jobject()
                      // the gets are checked, because oDeriv is checked
                      .put("expression", expr)
                      .put("result", result.toString())
                      .put("var", var)
              );
  }

  /**
   * Returns a JSON object corresponding to the evaluate route.
   */
  private static JSONObject evalObject(Expression result, String expr, String var, String val) {
    return jobject()
               .put("data",
                   jobject()
                       // the gets are checked, because oEval is checked
                       .put("expression", expr)
                       .put("result", result.toString())
                       .put("var", var)
                       .put("val", val)
               );
  }

  // runs the server on localhost:4567
  public static void main(String[] args) {

    // the GET call that differentiates an expression
    get("/differentiate/:expr/:var", (req, res) -> {
      // url variables
      String expr = req.params(":expr");
      String var = req.params(":var");

      // attempt to differentiate expression
      Optional<Expression> oDeriv = oDifferentiate(expr, var);

      // return the derivative if possible, otherwise an error
      return oDeriv.isPresent()
                 ? diffObject(oDeriv.get(), expr, var)
                 : error();
    });

    // the GET call that evaluates an expression
    get("/evaluate/:expr/:var/:val", (req, res) -> {
      // url variables
      String expr = req.params(":expr");
      String var = req.params(":var");
      String val = req.params(":val");

      // attempt to evaluate expression
      Optional<Expression> oEval = oEvaluate(expr, var, val);

      // return the evaluation if possible, otherwise an error
      return oEval.isPresent()
                 ? evalObject(oEval.get(), expr, var, val)
                 : error();
    });
  }
}