package proj.ast;

import proj.values.*;
import proj.*;

public class ASTDeref implements ASTNode {

    ASTNode ref;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v0 = ref.eval(e);
		if (v0 instanceof VRef) {
			return ((VRef) v0).getval();
		} else {
			throw new InterpreterError("* unary operator: reference expected, found " + v0);
		}
    }

    public ASTDeref(ASTNode r) {
		ref = r;
    }

}
