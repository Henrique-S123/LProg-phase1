package proj.ast;

import proj.values.*;
import proj.*;

public class ASTBool implements ASTNode  {
    boolean b;

    public ASTBool(boolean b0) {
        b = b0;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VBool(b);                
    }

}
