package multithreadingPractice;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Solution {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        Thread reader1 = new Thread(() -> {
            lock.readLock().lock();
            System.out.println("Reader 1 acquired read lock");
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            lock.readLock().unlock();
            System.out.println("Reader 1 released read lock");
        });
        
        Thread writer = new Thread(() -> {
            try { Thread.sleep(100); } catch (InterruptedException e) {} // let reader go first
            System.out.println("Writer trying to acquire write lock");
            lock.writeLock().lock();
            System.out.println("Writer acquired write lock");
            lock.writeLock().unlock();
            System.out.println("Writer released write lock");
        });
        reader1.start();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            
        }
        writer.start();

    }
}
