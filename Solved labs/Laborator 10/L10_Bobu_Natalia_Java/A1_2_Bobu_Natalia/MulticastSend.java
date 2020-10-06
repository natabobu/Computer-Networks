package multicastsend;

import java.net.*;
import java.io.*;

public class MulticastSend {

    public static void main(String[] args)throws Exception {
        InetAddress group = new InetAddress.getByName("230.0.0.1");
        int port = 4444;
        byte[] buf;
        DatagramPacket packet = null;
        MulticastSocket socket = new MulticastSocket(0);
        try {
            buf = (new String("Salut")).getBytes();
            packet = new DatagramPacket(buf, buf.length, group, port);
            socket.send(packet);
        } finally {
            socket.close();
        }
    }

}
