import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {
    public String[] reorder(String[] logs){
        List<String>letters=new ArrayList<>();
        ArrayList<String>digits=new ArrayList<>();
        for(String log:logs){
            int index=log.indexOf(' ');
            char nextChar=log.charAt(index+1);
            if(Character.isDigit(nextChar))letters.add(log);
            else digits.add(log);
        }
        List<String>ans=new ArrayList<>();
        Collections.sort(letters,(String a,String b)->{
            String idA = a.substring(0, a.indexOf(" "));
            String logA = a.substring(a.indexOf(" ") + 1);
            String idB = b.substring(0, b.indexOf(" "));
            String logB = b.substring(b.indexOf(" ") + 1);
            if (logA.equals(logB)) {
                return idA.compareTo(idB);
            } else {
                return logA.compareTo(logB);
            }            
        });
        ans.addAll(letters);
        ans.addAll(digits);
        return ans.toArray(new String[0]);
    }
}
