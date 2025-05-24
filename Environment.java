import java.util.*;

public class Environment <E>{
    Environment<E> anc;
    Map<String, E> bindings;

    Environment(){
        anc = null;
        bindings = new HashMap<>();
    }
    
    Environment(Environment<E> ancestor){
        // code missing
        this.anc = ancestor;
        this.bindings = new HashMap<>();
        // complete!
    }

    Environment<E> beginScope(){
        return new Environment<>(this);
    }
    
    Environment<E> endScope(){
        return anc;
    }

    void assoc(String id, E bind) throws InterpreterError {
        // code missing
        if (bindings.containsKey(id)) {
            throw new InterpreterError("Variable already defined in this scope: " + id);
        }
        bindings.put(id, bind);
        // complete!
    }


    E find(String id) throws InterpreterError {
        // code missing
        if (bindings.containsKey(id)) {
            return bindings.get(id);
        } else if (anc != null) {
            return anc.find(id);
        } else {
            throw new InterpreterError("Undefined variable: " + id);
        }
        // complete!
    }

}
