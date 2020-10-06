
package testgara;
import java.util.*;

public class Calator {
    private long cID;
    private Date tSosire;
    private Date tPlecare;
    
    public Calator(long cID, Date tSosire, Date tPlecare){
        this.cID=cID;
        this.tSosire=tSosire;
        this.tPlecare=tPlecare;
    }
    public long getCID(){
        return cID;
    }
    public Date getTsosire(){
        return tSosire;
    }
    public Date getTplecare(){
        return tPlecare;
    }
    public String toString(){
        return (Long.toString(cID)+" "+tSosire.toString()+" "+tPlecare.toString());
    }
}
