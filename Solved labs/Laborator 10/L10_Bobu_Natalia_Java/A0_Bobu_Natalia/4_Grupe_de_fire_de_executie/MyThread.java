
package group;

public class MyThread extends Thread {
    public MyThread(String name){
        super(name);
    }
    public void run(){
        while(true){
            if(isInterrupted()){
                break;
            }
            yield();
        }
    }
}
