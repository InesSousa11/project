class ASTEq implements ASTNode {
    ASTNode lhs, rhs;

    ASTEq(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs; this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return new VBool(lhs.eval(env).equals(rhs.eval(env)));
    }
}