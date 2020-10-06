package serverapp;

import java.io.*;
import java.net.*;

public class ServerApp {

    private ServerSocket serverSocket;
    private int port;

    public ServerApp(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        ServerApp server = new ServerApp(15876);
    }

    class ServerThread extends Thread {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String nume;

        public ServerThread(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }

        public void run() {
            int contor = 0;
            try {
                nume = in.readLine();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            while (ecouMesaj(contor)) {
                contor++;
            }
        }

        private boolean ecouMesaj(int contor) {
            try {
                String mesaj = in.readLine();
                if (!mesaj.equals("EXIT")) {
                    System.out.println("Mesaj " + contor + "(" + nume + "):" + mesaj);
                    out.println("Mesaj " + contor + ": " + mesaj);
                    return true;
                } else {
                    System.out.println("Inchidere conexiune");
                    socket.close();
                    return false;
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                System.exit(0);
                return false;
            }
        }
    }
}
