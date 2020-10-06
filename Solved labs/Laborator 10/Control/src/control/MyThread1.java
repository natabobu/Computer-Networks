
package control;

public class MyThread1 extends Thread{
    
    public MyThread1(String name){
        super(name);
    }
    public void run(){
        System.out.println(getName()+" is running");
        for(int i=0;i<5;i++){
            try{
                sleep(500);
            }catch(InterruptedException ie){
                
            }
            System.out.println(getName()+" writes "+Integer.toString(i));
        }
    }
}
