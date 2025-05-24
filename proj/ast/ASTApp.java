package proj.ast;

import proj.values.*;
import proj.*;

public class ASTApp implements ASTNode  {
    ASTNode func, arg;

    public ASTApp(ASTNode f, ASTNode a) {
        func = f;
        arg = a;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue vfunc = func.eval(e);
        if (vfunc instanceof VClos) {
            IValue varg = arg.eval(e);
            Environment<IValue> env = (((VClos) vfunc)).getEnv().beginScope();
            env.assoc(((VClos) vfunc).getId(), varg);
            return ((VClos) vfunc).getBody().eval(env);
        } else {
            throw new InterpreterError("func app: closure expected, found " + vfunc);
        }          
    }
}
