import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    boolean isItemPresent=false;
    List<Integer>buffer=new ArrayList<>(5);
    public synchronized void addItem(int item){
        System.out.println("in producer thread");
        
        if(buffer.size()==5){
            try {
                System.out.println("producer is waiting since buffer is full");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        buffer.add(item);
        notify();
    }
    public synchronized void consumeItem(){
        System.out.println("in consumer thread");
        if(buffer.size()==0){
            try {
                System.out.println("consumer is waiting for data in buffer");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        notify();
        System.out.println("consumer removed data"+buffer.removeLast());
    }
    // public synchronized void addItem(){
    //     System.out.println("producer thread");
    //     isItemPresent=true;
    //     notifyAll();
    // }
    // public synchronized void consumeItem(){
    //     System.out.println("consumer thread");
    //     if(!isItemPresent){
    //         try {
    //             System.out.println("consumer thread waiting");
    //             wait();
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //     }
    //     isItemPresent=false;
    // }
}
