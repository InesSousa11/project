import java.util.List;

class VSeq implements IValue {
    List<IValue> values;

    VSeq(List<IValue> values) {
        this.values = values;
    }

    List<IValue> getval() {
        return this.values;
    }

    public String toStr() {
        StringBuilder s = new StringBuilder();
        for (IValue v: values) {
            s.append(v.toStr()).append("\n");
        }
        return s.toString();
    }
}