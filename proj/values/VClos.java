package proj.values;

import proj.ast.*;
import proj.*;

public class VClos implements IValue {
    Environment<IValue> env;
    String id;
    ASTNode body;

    public VClos(Environment<IValue> e, String i, ASTNode b) {
        env = e;
        id = i;
        body = b;
    }

    public Environment<IValue> getEnv() {
        return env;
    }

    public String getId() {
        return id;
    }

    public ASTNode getBody() {
        return body;
    }

    public void setBody(ASTNode b) {
        body = b;
    }

    public String toStr() {
        return (id != null) ? "Closure with arg " + id : "Closure with no arg";
    }
}