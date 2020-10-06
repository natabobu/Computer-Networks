
package contro;
  
public class MyThread extends Thread{

    public MyThread(){
    }
    public void run(){
        while(true){
            try{
                System.out.println("Se ruleaza "+getName());
                sleep(1000);
            }catch(InterruptedException ie){              
            }
        }
    }
    public MyThread(String name){
        super(name);
    }
    
}

