package proj.ast;

import proj.values.*;
import proj.*;

public class ASTCons implements ASTNode {

    ASTNode first, rest;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = first.eval(e);
		IValue v2 = rest.eval(e);
		return new VCons(v1, v2);
    }

    public ASTCons(ASTNode f, ASTNode r) {
		first = f;
		rest = r;
    }

}
