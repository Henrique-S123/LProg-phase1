package proj.ast;

import proj.values.*;
import proj.*;

public class ASTNot implements ASTNode {

    ASTNode exp;

    public IValue eval(Environment <IValue>e) throws InterpreterError { 
		IValue v0 = exp.eval(e); 
		if (v0 instanceof VBool) { 
			return new VBool(!((VBool) v0).getval()); 
		} else { 
			throw new InterpreterError("~ operator: boolean expected, found " + v0);
		}
    }
        
    public ASTNot(ASTNode e) {
		exp = e;
    }

}

