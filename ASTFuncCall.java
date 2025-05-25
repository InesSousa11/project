import java.util.List;

public class ASTFuncCall implements ASTNode {
    List<ASTNode> inputs;
    String f;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = e.find(f);

        if (v instanceof VFunc) {
            VFunc vf = (VFunc) v;
            if (inputs.size() != vf.params.size()) {
                throw new InterpreterError("Number of parameters of function '" + f + "' needs to be " + vf.params.size() + " but " + inputs.size() + " were provided.");
            }
            Environment<IValue> fe = vf.e.beginScope();
            for (int i = 0; i < vf.params.size(); i++) {
                fe.assoc(vf.params.get(i), inputs.get(i).eval(e));
            }
            return vf.body.eval(fe);
        }
        throw new InterpreterError("'" + f + "' is not a function.");
    }

    public ASTFuncCall(List<ASTNode> inputs, String f) {
        this.inputs = inputs;
        this.f = f;
    }

}
