package proj.ast;

import proj.values.*;
import proj.*;

import java.util.List;

public class ASTDeref implements ASTNode {

    ASTNode ref;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v0 = ref.eval(e);
		if (v0 instanceof VRef) {
			return ((VRef) v0).getval();
		} else {
			throw new InterpreterError("illegal type for deref: " + v0.toStr());
		}
    }

    public ASTDeref(ASTNode r) {
		ref = r;
    }

}
