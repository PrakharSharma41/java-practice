import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateMap<V> {
    private final Map<Date, V> map = new HashMap<>();
    private final List<Date> sortedDates = new ArrayList<>();    
    public void put(Date date,V value){
        int index=findLowerBound(date);
        if(index==sortedDates.size() || !sortedDates.get(index).equals(value)){
            sortedDates.add(date);
        }
        map.put(date, value);
    }
  
    public V get(Date date) {
        int index = findLowerBound(date);  // Combined logic
        return map.get(sortedDates.get(index));
    }  
    private int findLowerBound(Date date) {
        int low = 0, high = sortedDates.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedDates.get(mid).compareTo(date) <= 0) {
                low = mid + 1;  // We need to search the right half for a possible later date
            } else {
                high = mid;  // Search the left half
            }
        }
        return low==0?low:low - 1;  // Return the last index with a date <= the input date
    } 
}
// public class DateMap<V> {
//     private final TreeMap<Date, V> map = new TreeMap<>();

//     // Put a value associated with a Date
//     public void put(Date date, V value) {
//         map.put(date, value);
//     }

//     // Get the value for exact or closest earlier Date
//     public V get(Date date) {
//         Map.Entry<Date, V> entry = map.floorEntry(date);  // returns the greatest key ≤ date
//         return entry != null ? entry.getValue() : null;
//     }

//     // Optional: Remove a value
//     public V remove(Date date) {
//         return map.remove(date);
//     }

//     // Optional: Expose size or iteration
//     public int size() {
//         return map.size();
//     }

//     public boolean containsDate(Date date) {
//         return map.containsKey(date);
//     }
// }