
package control;

public class Control {

    public Control(){
    }
    public static void main(String[] args) {
       MyThread1 thread1=new MyThread1("First Thread");
       MyThread2 thread2=new MyThread2("Second Thread ",thread1);
       thread1.start();
       thread2.start();
    }
    
}
