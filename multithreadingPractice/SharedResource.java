import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a=10;
    StampedLock stl=new StampedLock();
    public void producer(){
        long stamp=stl.tryOptimisticRead();
        try{
            
        }catch(Exception e){

        }
    }
}
