package proj.ast;

import proj.values.*;
import proj.*;

import java.util.List;

public class ASTAssign implements ASTNode {

    ASTNode ref, value;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue vv = value.eval(e);
		IValue vr = ref.eval(e);
		if (vr instanceof VRef) {
			((VRef) vr).setval(vv);
			return vv;
		} else {
			throw new InterpreterError("illegal type for assign: " + vr.toStr());
		}
    }

    public ASTAssign(ASTNode r, ASTNode v) {
		ref = r;
		value = v;
    }

}
