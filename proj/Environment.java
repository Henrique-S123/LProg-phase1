package proj;

import java.util.*;

public class Environment <E>{
    Environment<E> anc;
    Map<String, E> bindings;

    public Environment(){
        anc = null;
        bindings = new HashMap<String,E>();
    }
    
    public Environment(Environment<E> ancestor){
        anc = ancestor;
        bindings = new HashMap<String,E>();
    }

    public Environment<E> beginScope(){
        return new Environment<E>(this);
    }
    
    public Environment<E> endScope(){
        return anc;
    }

    public void assoc(String id, E bind) throws InterpreterError {
        if (bindings.containsKey(id)) throw new InterpreterError("Identifier " + id + "already declared!");
        bindings.put(id, bind);
    }

    public void update(String id, E bind)  {
        bindings.remove(id);
        bindings.put(id, bind);
    }


    public E find(String id) throws InterpreterError {
        Environment<E> curr = this;
        while (curr != null) {
            E val = curr.bindings.get(id);
            if (val != null) return val;
            curr = curr.anc;
        }
        throw new InterpreterError("Undeclared identifier " + id + ".");
    }
}
