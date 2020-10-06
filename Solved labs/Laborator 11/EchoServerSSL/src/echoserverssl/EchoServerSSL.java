package echoserverssl;
import javax.net.ssl.*;
import java.io.*;
public class EchoServerSSL {

    public static void main(String[] args) {
        try{
            SSLServerSocketFactory sslserverfactory=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket=(SSLServerSocket) sslserverfactory.createServerSocket(9999);
            SSLSocket sslsocket=(SSLSocket) sslserversocket.accept();
            InputStream input=sslsocket.getInputStream();
            InputStreamReader inputreader=new InputStreamReader(input);
            BufferedReader br=new BufferedReader(inputreader);
            String string=null;
            while((string=br.readLine())!=null){
                System.out.println(string);
                System.out.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
