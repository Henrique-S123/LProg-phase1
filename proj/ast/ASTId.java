package proj.ast;

import proj.values.*;
import proj.*;

public class ASTId implements ASTNode	{	

    String id;	
    
    public ASTId(String id)	{
        this.id = id;
    }

    public IValue eval(Environment<IValue> env)	throws InterpreterError {
        return env.find(id);	
    }

}	
