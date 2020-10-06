package sslclient;

import java.io.*;
import java.security.KeyStore;
import java.util.logging.*;
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.*;

public class SSLClient {

    public static void main(String[] args) {
        conectare("127.0.0.1", 4000);
    }
    private static SSLSocket socket;

    public static void conectare(String host, int port) {
        try{
        SSLSocketFactory factory = (SSLSocketFactory) SSLClient.getSocketFactory();
        socket = (SSLSocket) factory.createSocket(host, port);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] enable = {"TLS_DH_anon_WITH_AES_128_CBC_SHA"};
        socket.setEnabledCipherSuites(enable);
        String[] cipherSuites = socket.getEnabledCipherSuites();
        System.out.println("CipherSuites: ");
        for (int i = 0; i < cipherSuites.length; i++) {
            System.out.println(cipherSuites[i]);
        }
        socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
            public void handshakeCompleted(HandshakeCompletedEvent event) {
                System.out.println("Handshake reusit");
            }
        });
        socket.startHandshake();
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        System.out.println("Dati mesajul catre server...");
        String string=br.readLine();
        out.println("Mesajul catre server..."+string);
        out.println();
        out.flush();
    }catch(IOException e){
        e.printStackTrace();
    }finally{
            try{
                socket.close();
            }catch(IOException e){
                Logger.getLogger(SSLClient.class.getName()).log(Level.SEVERE, null,e);
            }
        }
    }
    public static SocketFactory getSocketFactory(){
        SSLSocketFactory ssf= null;
        try{
            SSLContext ctx;
            KeyManagerFactory kmf;
            KeyStore ks;
            char[] passphrase="123456".toCharArray();
            ctx=SSLContext.getInstance("TLS");
            kmf= KeyManagerFactory.getInstance("SunX509");
            ks=KeyStore.getInstance("JKS");
            ks.load(new FileInputStream("mySrvKeystore"),passphrase);
            kmf.init(ks,passphrase);
            ctx.init(kmf.getKeyManagers(),null,null);
            ssf=ctx.getSocketFactory();
            return ssf;
        }catch(Exception e){
            e.printStackTrace();
        }return null;
    }
}
