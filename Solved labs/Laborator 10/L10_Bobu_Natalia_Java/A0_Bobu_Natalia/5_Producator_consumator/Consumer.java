
package producator_consumator;

public class Consumer extends Thread{
    private Buffer theBuffer;
    public Consumer(){}
    public void run(){
        try{
            while(true){
                Product p=theBuffer.get();
                System.out.println(getName()+" "+p.getName());
                sleep(2000);
            }
        }catch(InterruptedException e){}
    }
    public Consumer(Buffer buffer,String name){
        super(name);
        theBuffer=buffer;
    }
}
