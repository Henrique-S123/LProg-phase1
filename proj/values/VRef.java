package proj.values;

public class VRef implements IValue {
    IValue v;

    public VRef(IValue v0) {
        v = v0;
    }

    public IValue getval() {
        return v;
    }

    public void setval(IValue v0) {
        v = v0; 
    }

    public String toStr() {
        return "ref(" + v.toStr() + ")";
    }
}