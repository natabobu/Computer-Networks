package contro;

public class MyRunnable implements Runnable {

    public MyRunnable() {
    }

    public void run() {
        while (true) {
            System.out.println("Se ruleaza " + (Thread.currentThread()).getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
        }
    }
}
