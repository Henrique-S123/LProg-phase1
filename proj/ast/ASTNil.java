package proj.ast;

import proj.values.*;
import proj.*;

public class ASTNil implements ASTNode  {

    public ASTNil() {}

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VNil();                
    }

}
