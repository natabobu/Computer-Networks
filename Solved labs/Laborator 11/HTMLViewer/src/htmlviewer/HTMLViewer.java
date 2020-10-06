
package htmlviewer;
import java.io.*;
import java.net.*;
public class HTMLViewer {

    public static void main(String[] args) {
        try{
            URL u=new URL("https://docs.oracle.com/javase/turorial/");
            InputStream in=u.openStream();
            in=new BufferedInputStream(in);
            Reader r=new InputStreamReader(in);
            int c;
            while((c=r.read())!=-1){
                System.out.print((char)c);
            }
        }catch(MalformedURLException e){
            System.out.println("Nu este o adresa URL valida");
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
