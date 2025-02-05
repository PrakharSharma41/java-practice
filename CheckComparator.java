import java.util.Comparator;

public class CheckComparator implements Comparator<Check>{

    @Override
    public int compare(Check o1, Check o2) {
        return o2.key-o1.key;
    }
    
}
