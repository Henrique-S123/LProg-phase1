package proj.ast;

import proj.values.*;
import proj.*;

public class ASTPrint implements ASTNode {
    ASTNode exp;
	boolean newline;

    public IValue eval(Environment <IValue>e) throws InterpreterError {
		IValue v0 = exp.eval(e);
		System.out.print(v0.toStr() + (newline ? "\n" : ""));
		return new VBool(true);
    }
        
    public ASTPrint(ASTNode e, boolean nl) {
		exp = e;
		newline = nl;
    }
	
}

