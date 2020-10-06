
package simpleweb;

import javax.swing.WindowConstants;

public class Test {
     public static void main(String[] args){
        SimpleWeb f=new SimpleWeb("web");
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setSize(512,342);
        f.show();
    }
}
