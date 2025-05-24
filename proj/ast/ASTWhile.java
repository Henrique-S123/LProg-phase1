package proj.ast;

import proj.values.*;
import proj.*;

public class ASTWhile implements ASTNode {

    ASTNode test, body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue vt = test.eval(e);
		if (!(vt instanceof VBool)) {
			throw new InterpreterError("while: bool condition expected, found " + vt);
		} else {
			while (((VBool) vt).getval()) {
				body.eval(e);
				vt = test.eval(e);
			}
			return new VBool(false);
		}
    }

    public ASTWhile(ASTNode t, ASTNode b) {
		test = t;
		body = b;
    }

}
