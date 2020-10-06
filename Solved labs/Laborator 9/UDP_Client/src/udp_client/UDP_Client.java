
package udp_client;
import java.io.*;
import java.net.*;
public class UDP_Client {

    public static void main(String[] args) throws IOException {
        InetAddress address=InetAddress.getByName("127.0.0.1");
        int port=8200;
        DatagramSocket socket=null;
        DatagramPacket packet=null;
        byte buf[];
        try{
            socket=new DatagramSocket();
            buf="Un mesaj".getBytes();
            packet=new DatagramPacket(buf,buf.length,address,port);
            socket.send(packet);
            buf=new byte[256];
            packet=new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        }
        finally{
            socket.close();
        }
    }
    
}
