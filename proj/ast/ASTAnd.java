package proj.ast;

import proj.values.*;
import proj.*;

public class ASTAnd implements ASTNode {

    ASTNode lhs, rhs;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);
		if (v1 instanceof VBool && v2 instanceof VBool) {
			return new VBool(((VBool) v1).getval() && ((VBool) v2).getval());
		} else {
			throw new InterpreterError("illegal types to && operator");
		}
    }

    public ASTAnd(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
    }

}
