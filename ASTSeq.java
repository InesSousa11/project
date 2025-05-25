import java.util.List;

public class ASTSeq implements ASTNode {
    List<ASTNode> exps;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = null;

        for (ASTNode n : exps) {
            v = n.eval(e);
        }

        return v;
    }

    public ASTSeq(List<ASTNode> exps) {
        this.exps = exps;
    }

}
