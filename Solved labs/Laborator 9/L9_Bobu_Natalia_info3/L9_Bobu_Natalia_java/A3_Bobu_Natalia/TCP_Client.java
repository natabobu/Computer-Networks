package tcp_client;

import java.io.*;
import java.net.*;

public class TCP_Client {

    public static void main(String[] args) {
        int port = 15876;
        String server = "localhost";
        Socket socket = null;
        String lineToBeSent;
        BufferedReader input;
        PrintWriter output;
        int ERROR = 1;

        if (args.length == 2) {
            server = args[0];
            try {
                port = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Server port=15876 (default)");
                port = 15876;
            }
        }
        try {
            socket = new Socket(server, port);
            System.out.println("Conectat la serverul " + socket.getInetAddress() + ":" + socket.getPort());
        } catch (UnknownHostException e) {
            System.out.println(e);
            System.exit(ERROR);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(ERROR);
        }
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                lineToBeSent = input.readLine();
                if (lineToBeSent.equals(".")) {
                    break;
                }
                output.println(lineToBeSent);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
