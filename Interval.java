public class Interval implements Comparable<Interval>{
    int start,end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }    
    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.end,other.end);
    }    
}
