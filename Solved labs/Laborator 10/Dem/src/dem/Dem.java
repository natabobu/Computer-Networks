
package dem;

public class Dem {

    public static void main(String[] args) {
        MyThread t1,t2;
        t1=new MyThread("Normal",false);
        t2=new MyThread("Demon",true);
        t1.start();
        t2.start();
    }
    
}
