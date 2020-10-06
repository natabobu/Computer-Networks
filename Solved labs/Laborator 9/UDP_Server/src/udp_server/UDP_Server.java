/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server;

import java.io.*;
import java.net.*;

public class UDP_Server {

    public static final int PORT = 8200;
    private DatagramSocket socket = null;
    DatagramPacket cerere, raspuns = null;

    public UDP_Server() throws IOException {
        socket = new DatagramSocket(PORT);
        try {
            while (true) {
                byte[] buf = new byte[256];
                cerere = new DatagramPacket(buf, buf.length);
                socket.receive(cerere);
                InetAddress adresa = cerere.getAddress();
                int port = cerere.getPort();
                buf = ("Server: " + new String(cerere.getData())).getBytes();
                raspuns = new DatagramPacket(buf, buf.length, adresa, port);
                socket.send(raspuns);
            }
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new UDP_Server();
    }

}
