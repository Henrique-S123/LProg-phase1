package proj.ast;

import proj.values.*;
import proj.*;

import java.util.List;

public class ASTLet implements ASTNode {
    List<Bind> decls;
    ASTNode body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        Environment<IValue> en = e.beginScope();
        for (Bind b : decls) {
            en.assoc(b.getId(), b.getExp().eval(en));
        }
        return body.eval(en);
    }

    public ASTLet(List<Bind> d, ASTNode b) {
        decls = d;
        body = b;
    }

}
