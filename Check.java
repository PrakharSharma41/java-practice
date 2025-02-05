import java.io.Serializable;

public class Check implements Comparable<Check>,Serializable{
    int key;
    String value;
    public Check(int key, String value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public int compareTo(Check o) {
        return this.key-o.key;
    }
    
}
