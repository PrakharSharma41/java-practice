import java.util.List;

public class QuickSort {
    public static void swap(List<Integer>ls,int i,int j){
        int temp=ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }
    public static int partition(List<Integer>ls,int start,int end){
        int pivot=ls.get(start),i=start,j=end+1;
        while(i<j){
            if(ls.get(i)>pivot){
                j--;swap(ls,i,j);
            }else{
                i++;
            }
        }
        if(j>=1)
        swap(ls,start,j-1);
        return j-1;

    }
    public static void sort(List<Integer>ls,int start,int end){
        if(start>=end)return ;
        int p=partition(ls, start, end); 
        sort(ls,start,p-1);
        sort(ls,p+1,end);
    }
}
