public class ASTBox implements ASTNode	{

    ASTNode v;

    public ASTBox(ASTNode v)	{
        this.v = v;
    }

    public IValue eval(Environment<IValue> env)	throws
            InterpreterError {
        return new VBox(v.eval(env));
    }

}	
