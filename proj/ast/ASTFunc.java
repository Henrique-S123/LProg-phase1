package proj.ast;

import proj.values.*;
import proj.*;

public class ASTFunc implements ASTNode  {
    String id;
    ASTNode body;

    public ASTFunc(String i, ASTNode b) {
        id = i;
        body = b;
    }

    public void setBody(ASTNode b) {
        body = b;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VClos(e, id, body);               
    }
}
