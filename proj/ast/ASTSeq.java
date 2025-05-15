package proj.ast;

import proj.values.*;
import proj.*;

public class ASTSeq implements ASTNode {

    ASTNode first, second;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		first.eval(e);
		return second.eval(e);
    }

    public ASTSeq(ASTNode f, ASTNode s) {
		first = f;
		second = s;
    }

}
