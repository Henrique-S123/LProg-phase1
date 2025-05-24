package proj.ast;

import proj.values.*;
import proj.*;

public class ASTLcons implements ASTNode {

    ASTNode first, rest;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		return new VLcons(first, rest, e);
    }

    public ASTLcons(ASTNode f, ASTNode r) {
		first = f;
		rest = r;
    }

}
