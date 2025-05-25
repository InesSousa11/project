public	class ASTDeref implements ASTNode	{

    ASTNode v;

    public ASTDeref(ASTNode v)	{
        this.v = v;
    }

    public IValue eval(Environment<IValue> env)	throws
            InterpreterError {
        if (v instanceof ASTId) {
            String s = ((ASTId) v).id;
            IValue v1 = env.find(s);
            if (v1 instanceof VBox) {
                return ((VBox) v1).getval();
            }
            throw new InterpreterError("illegal type to ! operator. \"" + s + "\" must be a 'box'.");
        }
        else if (v instanceof ASTDeref) {
            IValue v1 = v.eval(env);
            while (v1 instanceof VSeq) {
                if (((VSeq) v1).getval().size() != 1) {
                    throw new InterpreterError("Can't have 0 or multiple instructions inside a box.");
                }
                v1 = ((VSeq) v1).getval().get(0);
            }
            if (v1 instanceof VBox) {
                return ((VBox) v1).getval();
            }
            throw new InterpreterError("illegal type to ! operator. Must be a box.");
        }
        throw new InterpreterError("illegal type to ! operator. Must be a variable or a chain of dereferencing.");
    }

}
