
package control;

public class MyThread2 extends Thread{
    public MyThread1 waitedThread;
    public MyThread2(String name, MyThread1 waitedThread){
        super(name);
        this.waitedThread=waitedThread;
    }
    public void run(){
        System.out.println(getName()+" waits for Thread "+waitedThread.getName());
        try{
            waitedThread.join();
        }catch(InterruptedException e){}
        System.out.println(waitedThread.getName()+" has been finished");
        System.out.println(getName()+" has been finished");
    }
}
