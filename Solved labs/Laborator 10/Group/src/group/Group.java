package group;

public class Group {

    public static void main(String[] args) {
        MyThread a, b, c;
        ThreadGroup group;
        group = Thread.currentThread().getThreadGroup();
        System.out.println("Nume grup: " + group.getName());
        System.out.println("Nr. fire active: " + group.activeCount());
        a = new MyThread("Fir 1");
        b = new MyThread("Fir 2");
        c = new MyThread("Fir 3");
        a.start();
        b.start();
        c.start();
        System.out.println("Nr. fire active "+group.activeCount());
        a.interrupt();
        b.interrupt();
        c.interrupt();
    }

}
