
package web1;
import javax.swing.WindowConstants;
public class Test {
    public static void main(String[] args){
        Web1 f=new Web1("Web");
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setSize(512,342);
        f.show();
    }
}
