
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.deriv.parser;

import com.deriv.expression.Expression;
import static com.deriv.expression.Log.*;
import static com.deriv.expression.Mult.*;
import static com.deriv.expression.Add.*;
import static com.deriv.expression.Constant.*;
import static com.deriv.expression.Trig.*;
import static com.deriv.expression.Variable.*;
import static com.deriv.expression.Power.*;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class CupParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public CupParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public CupParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public CupParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\005\000\002\002\004\000\002\002" +
    "\005\000\002\002\003\000\002\003\005\000\002\003\004" +
    "\000\002\003\005\000\002\003\004\000\002\003\003\000" +
    "\002\004\005\000\002\004\006\000\002\004\003\000\002" +
    "\005\003\000\002\005\003\000\002\005\003\000\002\005" +
    "\005\000\002\005\005\000\002\005\006\000\002\005\006" +
    "\000\002\005\006\000\002\005\006\000\002\005\010" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\026\005\004\007\020\011\016\015\006\016" +
    "\021\017\015\021\014\022\012\023\011\024\007\001\002" +
    "\000\024\007\020\011\016\015\006\016\021\017\015\021" +
    "\014\022\012\023\011\024\007\001\002\000\046\002\ufff6" +
    "\004\ufff6\005\ufff6\006\ufff6\007\ufff6\010\ufff6\011\ufff6\012" +
    "\ufff6\013\ufff6\014\057\015\ufff6\016\ufff6\017\ufff6\020\ufff6" +
    "\021\ufff6\022\ufff6\023\ufff6\024\ufff6\001\002\000\004\007" +
    "\054\001\002\000\046\002\ufff5\004\ufff5\005\ufff5\006\ufff5" +
    "\007\ufff5\010\ufff5\011\ufff5\012\ufff5\013\ufff5\014\ufff5\015" +
    "\ufff5\016\ufff5\017\ufff5\020\ufff5\021\ufff5\022\ufff5\023\ufff5" +
    "\024\ufff5\001\002\000\044\002\ufffe\004\ufffe\005\ufffe\006" +
    "\033\007\020\010\ufffe\011\016\012\ufffe\013\031\015\006" +
    "\016\021\017\015\020\ufffe\021\014\022\012\023\011\024" +
    "\007\001\002\000\004\007\051\001\002\000\046\002\ufff3" +
    "\004\ufff3\005\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3\012" +
    "\ufff3\013\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3" +
    "\021\ufff3\022\ufff3\023\ufff3\024\ufff3\001\002\000\044\002" +
    "\ufff9\004\ufff9\005\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9" +
    "\012\ufff9\013\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\021" +
    "\ufff9\022\ufff9\023\ufff9\024\ufff9\001\002\000\046\002\ufff4" +
    "\004\ufff4\005\ufff4\006\ufff4\007\ufff4\010\ufff4\011\ufff4\012" +
    "\ufff4\013\ufff4\014\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4" +
    "\021\ufff4\022\ufff4\023\ufff4\024\ufff4\001\002\000\004\007" +
    "\046\001\002\000\026\005\004\007\020\011\016\015\006" +
    "\016\021\017\015\021\014\022\012\023\011\024\007\001" +
    "\002\000\010\002\043\004\026\005\027\001\002\000\026" +
    "\005\004\007\020\011\016\015\006\016\021\017\015\021" +
    "\014\022\012\023\011\024\007\001\002\000\004\007\022" +
    "\001\002\000\026\005\004\007\020\011\016\015\006\016" +
    "\021\017\015\021\014\022\012\023\011\024\007\001\002" +
    "\000\012\004\026\005\027\010\025\020\024\001\002\000" +
    "\026\005\004\007\020\011\016\015\006\016\021\017\015" +
    "\021\014\022\012\023\011\024\007\001\002\000\046\002" +
    "\uffee\004\uffee\005\uffee\006\uffee\007\uffee\010\uffee\011\uffee" +
    "\012\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee\020" +
    "\uffee\021\uffee\022\uffee\023\uffee\024\uffee\001\002\000\026" +
    "\005\004\007\020\011\016\015\006\016\021\017\015\021" +
    "\014\022\012\023\011\024\007\001\002\000\026\005\004" +
    "\007\020\011\016\015\006\016\021\017\015\021\014\022" +
    "\012\023\011\024\007\001\002\000\044\002\uffff\004\uffff" +
    "\005\uffff\006\033\007\020\010\uffff\011\016\012\uffff\013" +
    "\031\015\006\016\021\017\015\020\uffff\021\014\022\012" +
    "\023\011\024\007\001\002\000\024\007\020\011\016\015" +
    "\006\016\021\017\015\021\014\022\012\023\011\024\007" +
    "\001\002\000\044\002\ufffc\004\ufffc\005\ufffc\006\ufffc\007" +
    "\ufffc\010\ufffc\011\ufffc\012\ufffc\013\ufffc\015\ufffc\016\ufffc" +
    "\017\ufffc\020\ufffc\021\ufffc\022\ufffc\023\ufffc\024\ufffc\001" +
    "\002\000\024\007\020\011\016\015\006\016\021\017\015" +
    "\021\014\022\012\023\011\024\007\001\002\000\044\002" +
    "\ufffd\004\ufffd\005\ufffd\006\ufffd\007\ufffd\010\ufffd\011\ufffd" +
    "\012\ufffd\013\ufffd\015\ufffd\016\ufffd\017\ufffd\020\ufffd\021" +
    "\ufffd\022\ufffd\023\ufffd\024\ufffd\001\002\000\044\002\ufffb" +
    "\004\ufffb\005\ufffb\006\ufffb\007\ufffb\010\ufffb\011\ufffb\012" +
    "\ufffb\013\ufffb\015\ufffb\016\ufffb\017\ufffb\020\ufffb\021\ufffb" +
    "\022\ufffb\023\ufffb\024\ufffb\001\002\000\044\002\001\004" +
    "\001\005\001\006\033\007\020\010\001\011\016\012\001" +
    "\013\031\015\006\016\021\017\015\020\001\021\014\022" +
    "\012\023\011\024\007\001\002\000\010\004\026\005\027" +
    "\010\040\001\002\000\046\002\uffec\004\uffec\005\uffec\006" +
    "\uffec\007\uffec\010\uffec\011\uffec\012\uffec\013\uffec\014\uffec" +
    "\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022\uffec\023" +
    "\uffec\024\uffec\001\002\000\010\004\026\005\027\010\042" +
    "\001\002\000\046\002\ufff2\004\ufff2\005\ufff2\006\ufff2\007" +
    "\ufff2\010\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2\015\ufff2" +
    "\016\ufff2\017\ufff2\020\ufff2\021\ufff2\022\ufff2\023\ufff2\024" +
    "\ufff2\001\002\000\004\002\000\001\002\000\010\004\026" +
    "\005\027\012\045\001\002\000\046\002\ufff1\004\ufff1\005" +
    "\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\012\ufff1\013\ufff1" +
    "\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020\ufff1\021\ufff1\022" +
    "\ufff1\023\ufff1\024\ufff1\001\002\000\026\005\004\007\020" +
    "\011\016\015\006\016\021\017\015\021\014\022\012\023" +
    "\011\024\007\001\002\000\010\004\026\005\027\010\050" +
    "\001\002\000\046\002\uffed\004\uffed\005\uffed\006\uffed\007" +
    "\uffed\010\uffed\011\uffed\012\uffed\013\uffed\014\uffed\015\uffed" +
    "\016\uffed\017\uffed\020\uffed\021\uffed\022\uffed\023\uffed\024" +
    "\uffed\001\002\000\026\005\004\007\020\011\016\015\006" +
    "\016\021\017\015\021\014\022\012\023\011\024\007\001" +
    "\002\000\010\004\026\005\027\010\053\001\002\000\046" +
    "\002\ufff0\004\ufff0\005\ufff0\006\ufff0\007\ufff0\010\ufff0\011" +
    "\ufff0\012\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0" +
    "\020\ufff0\021\ufff0\022\ufff0\023\ufff0\024\ufff0\001\002\000" +
    "\026\005\004\007\020\011\016\015\006\016\021\017\015" +
    "\021\014\022\012\023\011\024\007\001\002\000\010\004" +
    "\026\005\027\010\056\001\002\000\046\002\uffef\004\uffef" +
    "\005\uffef\006\uffef\007\uffef\010\uffef\011\uffef\012\uffef\013" +
    "\uffef\014\uffef\015\uffef\016\uffef\017\uffef\020\uffef\021\uffef" +
    "\022\uffef\023\uffef\024\uffef\001\002\000\026\005\060\007" +
    "\020\011\016\015\006\016\021\017\015\021\014\022\012" +
    "\023\011\024\007\001\002\000\024\007\020\011\016\015" +
    "\006\016\021\017\015\021\014\022\012\023\011\024\007" +
    "\001\002\000\044\002\ufff8\004\ufff8\005\ufff8\006\ufff8\007" +
    "\ufff8\010\ufff8\011\ufff8\012\ufff8\013\ufff8\015\ufff8\016\ufff8" +
    "\017\ufff8\020\ufff8\021\ufff8\022\ufff8\023\ufff8\024\ufff8\001" +
    "\002\000\044\002\ufff7\004\ufff7\005\ufff7\006\ufff7\007\ufff7" +
    "\010\ufff7\011\ufff7\012\ufff7\013\ufff7\015\ufff7\016\ufff7\017" +
    "\ufff7\020\ufff7\021\ufff7\022\ufff7\023\ufff7\024\ufff7\001\002" +
    "\000\044\002\ufffa\004\ufffa\005\ufffa\006\ufffa\007\ufffa\010" +
    "\ufffa\011\ufffa\012\ufffa\013\ufffa\015\ufffa\016\ufffa\017\ufffa" +
    "\020\ufffa\021\ufffa\022\ufffa\023\ufffa\024\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\012\002\016\003\007\004\012\005\004\001" +
    "\001\000\006\004\062\005\004\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\004\031\005" +
    "\004\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\002" +
    "\043\003\007\004\012\005\004\001\001\000\002\001\001" +
    "\000\012\002\040\003\007\004\012\005\004\001\001\000" +
    "\002\001\001\000\012\002\022\003\007\004\012\005\004" +
    "\001\001\000\002\001\001\000\012\002\036\003\007\004" +
    "\012\005\004\001\001\000\002\001\001\000\010\003\035" +
    "\004\012\005\004\001\001\000\010\003\027\004\012\005" +
    "\004\001\001\000\006\004\031\005\004\001\001\000\006" +
    "\004\034\005\004\001\001\000\002\001\001\000\006\004" +
    "\033\005\004\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\031\005\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\002" +
    "\046\003\007\004\012\005\004\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\002\051\003\007\004\012\005" +
    "\004\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\002\054\003\007\004\012\005\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\004\060\005\004\001\001" +
    "\000\006\004\061\005\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$CupParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$CupParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$CupParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$CupParser$actions {
  private final CupParser parser;

  /** Constructor */
  CUP$CupParser$actions(CupParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$CupParser$do_action_part00000000(
    int                        CUP$CupParser$act_num,
    java_cup.runtime.lr_parser CUP$CupParser$parser,
    java.util.Stack            CUP$CupParser$stack,
    int                        CUP$CupParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$CupParser$result;

      /* select the action based on the action number */
      switch (CUP$CupParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // expr ::= expr PLUS term 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = add(e, t); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("expr",0, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= expr EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression start_val = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		RESULT = start_val;
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$CupParser$parser.done_parsing();
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr ::= expr MINUS term 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = add(e, negate(t)); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("expr",0, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr ::= term 
            {
              Expression RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = t; 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("expr",0, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // term ::= term TIMES factor 
            {
              Expression RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = mult(t, f); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // term ::= term factor 
            {
              Expression RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = mult(t, f); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // term ::= term DIVIDE factor 
            {
              Expression RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = div(t, f); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // term ::= MINUS factor 
            {
              Expression RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = negate(f); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // term ::= factor 
            {
              Expression RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = f; 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // factor ::= base CARROT factor 
            {
              Expression RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).right;
		Expression b = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = power(b, f); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("factor",2, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // factor ::= base CARROT MINUS factor 
            {
              Expression RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).right;
		Expression b = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression f = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = power(b, negate(f)); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("factor",2, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // factor ::= base 
            {
              Expression RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Expression b = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = b; 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("factor",2, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // base ::= NUMBER 
            {
              Expression RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = constant(n); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // base ::= ECON 
            {
              Expression RESULT =null;
		 RESULT = e(); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // base ::= VARIABLE 
            {
              Expression RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$CupParser$stack.peek()).value;
		 RESULT = var(x); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // base ::= LPAREN expr RPAREN 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = e; 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // base ::= LBRACK expr RBRACK 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = e; 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-2)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // base ::= TRIG LPAREN expr RPAREN 
            {
              Expression RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = trig(t, e); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // base ::= LN LPAREN expr RPAREN 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = ln(e); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // base ::= LOG LPAREN expr RPAREN 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = log(constant(10), e); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // base ::= SQRT LPAREN expr RPAREN 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = power(e, div(multID(), constant(2))); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // base ::= LOG LPAREN expr COMMA expr RPAREN 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$CupParser$stack.elementAt(CUP$CupParser$top-1)).value;
		 RESULT = log(e1, e2); 
              CUP$CupParser$result = parser.getSymbolFactory().newSymbol("base",3, ((java_cup.runtime.Symbol)CUP$CupParser$stack.elementAt(CUP$CupParser$top-5)), ((java_cup.runtime.Symbol)CUP$CupParser$stack.peek()), RESULT);
            }
          return CUP$CupParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$CupParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$CupParser$do_action(
    int                        CUP$CupParser$act_num,
    java_cup.runtime.lr_parser CUP$CupParser$parser,
    java.util.Stack            CUP$CupParser$stack,
    int                        CUP$CupParser$top)
    throws java.lang.Exception
    {
              return CUP$CupParser$do_action_part00000000(
                               CUP$CupParser$act_num,
                               CUP$CupParser$parser,
                               CUP$CupParser$stack,
                               CUP$CupParser$top);
    }
}

}
