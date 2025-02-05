import java.util.List;

final public class Immutable {
    private List<Integer>ls;

    public Immutable(List<Integer> ls) {
        this.ls = ls;
    }

    public List<Integer> getLs() {
        return ls;
    }
}
