package sslserver;

import java.io.*;
import java.security.KeyStore;
import java.util.*;
import javax.net.ServerSocketFactory;
import javax.net.ssl.*;

public class SSLServer {

    private static int port = 4000;
    private static SSLServerSocketFactory sf;
    private static SSLServerSocket ss;

    public static void StabilireConexiune(int nrPort) {
        try {
            sf = (SSLServerSocketFactory) SSLServer.getServerSocketFactory();
            ss = (SSLServerSocket) sf.createServerSocket(nrPort);
            System.out.println("Server conectat si gata de a accepta noi conexiuni la adresa " + ss.getLocalPort());
            String[] enable = {"TLS_DH_anon_WITH_AES_128_CBC_SHA"};
            ss.setEnabledCipherSuites(enable);
            String[] cipherSuites = ss.getEnabledCipherSuites();
            System.out.println("CipherSuites: ");
            for (int i = 0; i < cipherSuites.length; i++) {
                System.out.println(cipherSuites[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static SSLSocket clientSocket;

    public static void ConectareClient() {
        try {
            clientSocket = (SSLSocket) ss.accept();
            System.out.println("Client conectat cu succes");
            InputStream input = clientSocket.getInputStream();
            InputStreamReader inputreader = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(inputreader);
            String string = null;

            while ((string = br.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static ServerSocketFactory getServerSocketFactory() {
        SSLServerSocketFactory ssf = null;
        try {
            SSLContext ctx;
            KeyManagerFactory kmf;
            KeyStore ks;
            char[] passphrase = "123456".toCharArray();
            ctx = SSLContext.getInstance("TLS");
            kmf = KeyManagerFactory.getInstance("SunX509");
            ks = KeyStore.getInstance("JKS");

            ks.load(new FileInputStream("mySrvKeystore"), passphrase);
            kmf.init(ks, passphrase);
            ctx.init(kmf.getKeyManagers(), null, null);
            ssf = ctx.getServerSocketFactory();
            return ssf;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        StabilireConexiune(port);
        while (true) {
            ConectareClient();
        }
    }

}
