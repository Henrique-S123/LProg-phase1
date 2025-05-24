package proj.ast;

import proj.values.*;
import proj.*;

public class ASTNeg implements ASTNode {

    ASTNode exp;

    public IValue eval(Environment <IValue>e) throws InterpreterError { 
		IValue v0 = exp.eval(e); 
		if (v0 instanceof VInt) { 
			return new VInt(-((VInt)v0).getval()); 
		} else { 
			throw new InterpreterError("- unary operator: integers expected, found " + v0);
		}
    }
        
    public ASTNeg(ASTNode e) {
		exp = e;
    }

}

