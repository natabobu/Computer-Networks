package producator_consumator;

import java.util.Vector;

public class Buffer {

    private int maxBuffer;
    private Vector buffer = new Vector();

    public Buffer() {
    }

    public synchronized void put(Product p) throws InterruptedException {
        while (buffer.size() == maxBuffer) {
            wait();
        }
        buffer.addElement(p);
        notify();
    }

    public synchronized Product get() throws InterruptedException {
        while (buffer.size() == 0) {
            wait();
        }
        Product p = (Product) buffer.firstElement();
        buffer.removeElement(p);

        notify();
        return p;
    }

    public Buffer(int maxBuffer) {
        this.maxBuffer = maxBuffer;
    }
}
