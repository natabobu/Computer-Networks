
package httpclient;
import java.io.*;
import java.net.*;
public class HTTPClient {
        String gazda;
        String fisier;
        int port;
        Socket socket=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        
    public HTTPClient(String adresaURL)throws MalformedURLException{
        URL url=new URL(adresaURL);
        gazda=url.getHost();
        System.out.println(gazda); 
        port=url.getPort();
        System.out.println(port);
        if(port==-1){
            port=80;
        }
        fisier=url.getFile();
    }
    public void conectare()throws IOException{
        socket=new Socket(gazda,port);
        dis=new DataInputStream(socket.getInputStream());
        dos=new DataOutputStream(socket.getOutputStream()); 
    }
    public void descarca() throws IOException{
        String mesaj="GET "+fisier+"HTTP/1.0\r\n\n";
        dos.writeBytes(mesaj);
        DataOutputStream fis=new DataOutputStream(new FileOutputStream(fisier));
        int c;
        while((c=dis.read())!=-1){
            System.out.print(""+(char)c);
            fis.write(c);
        }
    }
    public void deconectare() throws IOException{
        dis.close();
        dos.close();
        socket.close();
    }
    public static void main(String[] args)throws IOException {
        String adresa="http://localhost/index.html";
        HTTPClient pag=new HTTPClient(adresa);
        pag.conectare();
        pag.descarca();
        pag.deconectare();
        System.out.println("Gata!");
    }
    
}
