package proj.ast;

import proj.values.*;
import proj.*;

public class ASTIf implements ASTNode {

    ASTNode test, conseq, alt;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue vt = test.eval(e);
		if (!(vt instanceof VBool)) {
			throw new InterpreterError("if: bool condition expected, found " + vt);
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
