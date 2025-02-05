import java.util.ArrayList;
import java.util.List;

public class HeapPollution{
    public void check(List<Integer>... ls){
        Object[] ls1=ls;
        ls1[0]=new ArrayList<String>(3); // this will change ls[0] from List<Integer> to List<String>
        
    }
}