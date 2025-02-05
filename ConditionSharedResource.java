import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSharedResource {
    public ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    boolean isAvailable=false;
    public void producer(){
        try{
            lock.lock();
            System.out.println("producer lock acquired by thread: "+Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("producer lock waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=true;
            condition.signal();
        }catch(Exception e){
            System.out.println("exception occured");
        }
        finally{
            lock.unlock();
            System.out.println("producer lock released by: "+Thread.currentThread().getName());
        }
    }
    public void consumer(){
        try{
            Thread.sleep(1000);
            lock.lock();
            System.out.println("consumer lock acquired by thread: "+Thread.currentThread().getName());
            if(!isAvailable){
                System.out.println("consumer lock waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            condition.signal();
            isAvailable=false;
        }catch(Exception e){
            System.out.println("exception occured");
        }
        finally{
            lock.unlock();
            System.out.println("consumer lock released by: "+Thread.currentThread().getName());
        }

    }
}
