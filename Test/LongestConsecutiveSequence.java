import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums){
        int maxLength=1;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], 1);
        }
        for(Integer key:hm.keySet()){
            int count=1,val=key;val++;
            while(hm.containsKey(val)){
                if(hm.get(val)==Integer.MIN_VALUE)break;
                if(hm.get(val)>1){
                    count+=hm.get(val);
                    break;
                }
                count++;val++;
                hm.put(val, Integer.MIN_VALUE);
            }
            if(hm.get(key)!=Integer.MIN_VALUE)
            hm.put(key,count);
            maxLength=Math.max(maxLength,count);
        }
        return maxLength;        
    }
}
// 100 200 4 3 2 1