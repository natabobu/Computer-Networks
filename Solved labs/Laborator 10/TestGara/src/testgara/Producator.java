
package testgara;
import java.util.*;
public class Producator extends Thread{
    private Casa casa[];
    private int nr_case;
    static long ID=0;
    private int nr_clienti;
    
    public Producator(int nr_case, Casa casa[], String name, int nr_clienti){
        setName(name);
        this.nr_case=nr_case;
        this.casa=new Casa[nr_case];
        this.nr_clienti=nr_clienti;
        for(int i=0;i<nr_case;i++){
            this.casa[i]=casa[i];
        }
    }
    private int min_index(){
        int index=0;
        try{
            long min=casa[0].lungime_coada();
            for(int i=1;i<nr_case;i++){
                long lung=casa[i].lungime_coada();
                if(lung<min){
                    min=lung;
                    index=i;
                }
            }
        }catch(InterruptedException ie){
            System.out.println(ie.toString());
        }
        return index;
    }
    public void run(){
        try{
            int i=0;
            while(i<nr_clienti){
                i++;
                Calator c=new Calator(++ID,new Date(),new Date());
                int m=min_index();
                System.out.println("Calator :"+Long.toString(ID)+" adaugat la Casa "+Integer.toString(m));
                casa[m].adauga_calator(c);
                sleep((int)(Math.random()*1000));
            }
        }catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }
}
