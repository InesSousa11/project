public class ASTBox implements ASTNode	{

    ASTNode v;

    public ASTBox(ASTNode v)	{
        this.v = v;
    }

    public IValue eval(Environment<IValue> env)	throws
            InterpreterError {
        while (v instanceof ASTSeq) {
            if (((ASTSeq) v).exps.size() != 1) {
                throw new InterpreterError("Can't have 0 or multiple instructions inside a box.");
            }
            v = ((ASTSeq) v).exps.get(0);
        }
        return new VBox(v.eval(env));
    }
}
