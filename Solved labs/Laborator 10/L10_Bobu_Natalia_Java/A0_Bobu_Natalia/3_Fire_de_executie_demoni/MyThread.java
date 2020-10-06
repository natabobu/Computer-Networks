
package dem;

public class MyThread extends Thread{
    
    public MyThread(String name,boolean is_Daemon){
        super(name);
        setDaemon(is_Daemon);
    }
    public void run(){
        for(int i=0;i<5;i++){
            try{
                sleep(500);
            }catch(InterruptedException ie){
                
            }
            System.out.println(getName()+" se ruleaza");
        }
    }
}