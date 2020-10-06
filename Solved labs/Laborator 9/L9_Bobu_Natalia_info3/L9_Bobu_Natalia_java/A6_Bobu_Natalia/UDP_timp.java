
package udp_timp;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.LocalTime;
import java.util.Calendar;

public class UDP_timp {

    public static final int PORT = 8200;
    private DatagramSocket socket = null;
    DatagramPacket cerere, raspuns = null;
    public UDP_timp() throws IOException {
        socket = new DatagramSocket(PORT);
        Calendar cal = Calendar.getInstance();
        int hour,minute;
        try {
            while (true) {
                byte[] buf = new byte[256];
                cerere = new DatagramPacket(buf, buf.length);
                socket.receive(cerere);
                System.out.println(new String(cerere.getData()));
                InetAddress adresa = cerere.getAddress();
                int port = cerere.getPort();
                hour=cal.get(Calendar.HOUR_OF_DAY);
                minute=cal.get(Calendar.MINUTE);
                buf = ("Server: Ora curenta este " + hour+":"+minute).getBytes();
                raspuns = new DatagramPacket(buf, buf.length, adresa, port);
                socket.send(raspuns);
            }
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new UDP_timp();
    }

}
