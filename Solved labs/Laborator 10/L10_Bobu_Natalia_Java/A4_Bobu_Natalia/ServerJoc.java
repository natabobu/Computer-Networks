package serverjoc;

import java.io.*;
import java.net.*;
import java.math.*;

public class ServerJoc {

    private ServerSocket serverSocket;
    private int port;
    private int nr = (int) (Math.random() * 500);
    private int cont = 0;

    public ServerJoc(int port) {
        System.out.println(nr);
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
                cont++;
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        ServerJoc server = new ServerJoc(15876);
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
                    if (cont >= 3) {
                        int nr_client = Integer.parseInt(mesaj);
                        if (nr == nr_client) {
                            System.out.println("Mesaj " + contor + "(" + nume + "):" + mesaj);
                            out.println("Corect");
                            socket.close();
                            System.exit(0);
                            return false;
                        } else if (nr < nr_client) {
                            System.out.println("Mesaj " + contor + "(" + nume + "):" + mesaj);
                            out.println("Introduceti un numar mai mic");
                        } else if (nr > nr_client) {
                            System.out.println("Mesaj " + contor + "(" + nume + "):" + mesaj);
                            out.println("Introduceti un numar mai mare");
                        }
                        return true;
                    }else{
                        out.println("Asteptam sa se conecteze cel putin 3 clienti");
                    }
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
