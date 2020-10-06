
package echoclientssl;
import javax.net.ssl.*;
import java.io.*;
public class EchoClientSSL {

    public static void main(String[] args) {
         try{
            SSLSocketFactory sslsocketfactory=(SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket=(SSLSocket) sslsocketfactory.createSocket("localhost",9999);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            OutputStream output=sslsocket.getOutputStream();
            OutputStreamWriter outputwriter=new OutputStreamWriter(output);
            BufferedWriter bw=new BufferedWriter(outputwriter);
            String string=null;
            while((string=br.readLine())!=null){
                bw.write(string+"\n");
                bw.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
