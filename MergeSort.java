import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    
    public static void sort(List<Integer>ls,int start,int mid,int end){
        List<Integer>temp=new ArrayList<>();
        int i=start,j=mid;
        while(i<mid&&j<=end){
            if(ls.get(i)<=ls.get(j)){
                temp.add(ls.get(i++));
            }else{
                temp.add(ls.get(j++));
            }
        }
        while(i<mid){
            temp.add(ls.get(i++));
        }
        while(j<=end){
            temp.add(ls.get(j++));
        }
        for(i=start;i<=end;i++){
            ls.set(i, temp.get(i-start));
        }
    }
    public static void merge(List<Integer>ls,int start,int end){
        if(start>=end)return ;
        int mid=(start+end)/2;
        merge(ls,start,mid);
        merge(ls,mid+1,end);
        sort(ls,start,mid+1,end);
    }
}
