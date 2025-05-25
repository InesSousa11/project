import java.util.ArrayList;
import java.util.List;

public class ASTSeq implements ASTNode {
    List<ASTNode> exps;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        List<IValue> v = new ArrayList<>();

        for (ASTNode n : exps) {
            v.add(n.eval(e));
        }

        return new VSeq(v);
    }

    public ASTSeq(List<ASTNode> exps) {
        this.exps = exps;
    }

}
