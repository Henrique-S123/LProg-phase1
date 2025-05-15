package proj.ast;

import proj.values.*;
import proj.*;

public class ASTIf implements ASTNode {

    ASTNode test, conseq, alt;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue vt = test.eval(e);
		if (!(vt instanceof VBool)) {
			throw new InterpreterError("illegal type to if condition");
		} else {
			if (((VBool) vt).getval()) {
				return conseq.eval(e);
			} else {
				return alt.eval(e);
			}
		}
    }

    public ASTIf(ASTNode t, ASTNode c, ASTNode a) {
		test = t;
		conseq = c;
		alt = a;
    }

}
