class ASTLteq implements ASTNode {
    ASTNode lhs, rhs;

    ASTLteq(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue l = lhs.eval(env);
        IValue r = rhs.eval(env);

        if (l instanceof VInt && r instanceof VInt) {
            return new VBool(((VInt) l).getval() <= ((VInt) r).getval());
        }
        throw new InterpreterError("Expected integers in <=");
    }
}