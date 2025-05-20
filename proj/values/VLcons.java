package proj.values;

import proj.ast.*;
import proj.*;

public class VLcons implements IValue {
    ASTNode f;
    ASTNode s;
    Environment<IValue> e;
    IValue vf;
    IValue vs;

    public VLcons(ASTNode f0, ASTNode s0, Environment<IValue> e0, IValue vf0, IValue vs0) {
        f = f0;
        s = s0;
        e = e0;
        vf = vf0;
        vs = vs0;
    }

    public ASTNode getFirst() { return f; }

    public ASTNode getSecond() { return s; }

    public Environment<IValue> getEnv() { return e; }

    public void setFirst(IValue vf0) { vf = vf0; }

    public void setSecond(IValue vs0) { vs = vs0; }

    public String toStr() {
        if (vf != null && vs != null) {
            return vf.toStr() + ":?" + vs.toStr();
        } else {
            return f + ":?" + s;
        }
    }
}