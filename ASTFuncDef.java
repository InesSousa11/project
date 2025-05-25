import java.util.List;

public class ASTFuncDef implements ASTNode {
    List<String> v;
    ASTNode body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VFunc(e, v, body);
    }

    public ASTFuncDef(List<String> v, ASTNode body) {
        this.v = v;
        this.body = body;
    }

}
