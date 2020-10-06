
package producator_consumator;

public class Producator_consumator {
    private Producer theProducer[];
    private Consumer theConsumer[];
    private Buffer theBuffer[];
    public Producator_consumator(){}
    public Producator_consumator(int np,int nc){
        int i;
        theProducer=new Producer[np];
        theBuffer=new Buffer[nc];
        theConsumer=new Consumer[nc];
        for(i=0;i<nc;i++){
            theBuffer[i]=new Buffer(3);
        }
        for(i=0;i<np;i++){
            theProducer[i]=new Producer(theBuffer,"Producer. "+Integer.toString(i+1));
            theProducer[i].start();
        }
        for(i=0;i<nc;i++){
            theConsumer[i]=new Consumer(theBuffer[i],"Consumer. "+Integer.toString(i+1));
            theConsumer[i].start();
        }
    }
    public static void main(String[] args) {
        Producator_consumator c= new Producator_consumator(4,3);
    }
    
}
