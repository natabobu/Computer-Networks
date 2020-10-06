
package testgara;

public class TestGara {

    public static void main(String[] args) {
        int i;
        int nr=4;
        Casa c[]=new Casa[nr];
        for(i=0;i<nr;i++){
            c[i]=new Casa("Casa "+Integer.toString(i));
            c[i].start();
        }
        Producator p=new Producator(nr,c,"Producator",30);
        p.start();
    }
    
}
