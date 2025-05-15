package proj.ast;

import proj.values.*;
import proj.*;

public interface ASTNode {

    public IValue eval(Environment<IValue> e) throws InterpreterError;
	
}

