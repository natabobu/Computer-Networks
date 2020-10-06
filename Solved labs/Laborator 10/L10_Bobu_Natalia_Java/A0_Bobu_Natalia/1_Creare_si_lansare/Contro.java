
package contro;

public class Contro {

    public MyThread threads[];
    public MyRunnable objects[];
    public Contro(){
        objects=new MyRunnable[2];
        objects[0]=new MyRunnable();
        objects[1]=new MyRunnable();
        threads=new MyThread[2];
        threads[0]=new MyThread("Fir 1");
        threads[1]=new MyThread("Fir 2");
        threads[0].start();
        threads[1].start();
    }
    public static void main(String[] args) {
       Contro c=new Contro();
    }
    
}
