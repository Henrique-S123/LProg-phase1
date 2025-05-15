package proj.ast;

import proj.values.*;
import proj.*;

public class ASTLcons implements ASTNode {

    ASTNode first, rest;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		return new VCons(new VClos(e, null, first), new VClos(e, null, rest));
    }

    public ASTLcons(ASTNode f, ASTNode r) {
		first = f;
		rest = r;
    }

}
