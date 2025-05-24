package proj.ast;

import proj.values.*;
import proj.*;

public class ASTBox implements ASTNode {

    ASTNode value;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v0 = value.eval(e);
		return new VRef(v0);
    }

    public ASTBox(ASTNode v) {
		value = v;
    }

}
