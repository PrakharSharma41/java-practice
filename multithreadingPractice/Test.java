package multithreadingPractice;

public class Test implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            
        }
        System.out.println("name is "+Thread.currentThread().getName());
    }
}
