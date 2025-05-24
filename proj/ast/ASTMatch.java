package proj.ast;

import proj.values.*;
import proj.*;

public class ASTMatch implements ASTNode {

    ASTNode test, nilcase, conscase;
	String id1, id2;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue vt = test.eval(e);
		if (vt instanceof VNil) { return nilcase.eval(e);
		} else if (vt instanceof VCons || (vt instanceof VLcons &&
				((VLcons) vt).getFirstValue() != null &&
				((VLcons) vt).getSecondValue() != null)) {
			IValue v1, v2;
			if (vt instanceof VCons) {
				v1 = ((VCons) vt).getFirst();
				v2 = ((VCons) vt).getSecond();
			} else {
				v1 = ((VLcons) vt).getFirstValue();
				v2 = ((VLcons) vt).getSecondValue();
			}
			Environment<IValue> env = e.beginScope();
			env.assoc(id1, v1);
			env.assoc(id2, v2);
			return conscase.eval(env);
		} else if (vt instanceof VLcons) {
			IValue vfirst = ((VLcons) vt).getFirst().eval(((VLcons) vt).getEnv());
			IValue vsecond = ((VLcons) vt).getSecond().eval(((VLcons) vt).getEnv());
			((VLcons) vt).setFirst(vfirst);
			((VLcons) vt).setSecond(vsecond);
			Environment<IValue> env = e.beginScope();
			env.assoc(id1, vfirst);
			env.assoc(id2, vsecond);
			return conscase.eval(env);
		} else
			throw new InterpreterError("illegal type to match: " + vt.toStr());
    }

    public ASTMatch(ASTNode t, ASTNode nc, String i1, String i2, ASTNode cc) {
		test = t;
		nilcase = nc;
		id1 = i1;
		id2 = i2;
		conscase = cc;
    }
}
