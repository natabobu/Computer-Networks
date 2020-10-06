package producator_consumator;

public class Producer extends Thread {

    private Buffer theBuffer[];

    public void run() {
        try {
            while (true) {
                Product p = new Product(Long.toString(Counter.next()));
                int nr = (int) (Math.round(Math.random() * theBuffer.length));
                if (nr >= theBuffer.length) {
                    nr=theBuffer.length-nr;
                }
                System.out.println(getName()+": "+p.getName()+"...."+Integer.toString(nr));
                theBuffer[nr].put(p);
                sleep(Math.round(Math.random()*1000));
            }
        }catch(InterruptedException e){}
    }
    public Producer(Buffer[] buffer,String name){
        super(name);
        theBuffer=buffer;
    }
}
