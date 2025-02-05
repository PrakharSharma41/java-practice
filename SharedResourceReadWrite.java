import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceReadWrite {
    public void producer(ReadWriteLock lock){
        try {
            Thread.sleep(1000);
            lock.readLock().lock();
            System.out.println("producer lock acquired by "+Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            System.out.println("producer lock released by "+Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }
    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("consumer lock acquired by "+Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            System.out.println("consumer lock released by "+Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
    
}
