package proj.ast;

import proj.values.*;
import proj.*;

public class ASTString implements ASTNode  {
    String s;

    public ASTString(String s0) {
        s = s0;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VString(s);                
    }

}
