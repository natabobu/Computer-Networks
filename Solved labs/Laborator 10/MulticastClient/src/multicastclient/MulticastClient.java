package multicastclient;

import java.io.*;
import java.net.*;

public class MulticastClient {

    public static void main(String[] args) throws IOException {
        InetAddress group = new InetAddress.getByName("230.0.0.1");
        int port = 4444;
        MulticastSocket socket = null;
        byte buf[];
        try {
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
            buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } finally {
            socket.leaveGroup(group);
            socket.close();
        }

    }

}
