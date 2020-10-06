package testgara;

import java.util.*;

public class Casa extends Thread{

    private Vector calatori = new Vector();

    public Casa(String name) {
        setName(name);
    }

    public void run() {
        try {
            while (true) {
                sterge_calator();
                sleep((int) (Math.random() * 4000));
            }
        } catch (InterruptedException ie) {
            System.out.println("Intrerupere");
            System.out.println(ie.toString());
        }
    }
    public synchronized void adauga_calator(Calator c) throws InterruptedException{
        calatori.addElement(c);
        notifyAll();
    }
    public synchronized void sterge_calator() throws InterruptedException{
        while(calatori.size()==0)
            wait();
        Calator c=(Calator)(calatori.elementAt(0));
        calatori.removeElementAt(0);
        System.out.println(Long.toString(c.getCID())+" a fost deservit de casa "+getName());
        notifyAll();      
    }
    public synchronized long lungime_coada() throws InterruptedException{
        notifyAll();
        long size=calatori.size();
        return size;
    }
    
}
