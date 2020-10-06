package tcp_server;

import java.io.*;
import java.net.*;

public class TCP_Server {

    public static void main(String[] args) {
        int port;
        ServerSocket serverSocket;
        BufferedReader input;
        try{
            port=Integer.parseInt(args[0]);
        }
        catch(Exception e){
            System.out.println("port=15876 (default)");
            port=15876;
        }
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("Serverul este activ la portul"+ serverSocket.getLocalPort());
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("Conexiune acceptata "+socket.getInetAddress()+":"+socket.getPort());
                input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                try{
                    while(true){
                        String message=input.readLine();
                        if(message==null) break;
                        System.out.println(message);
                    }
                }
                catch(IOException e){
                    System.out.println(e);
                }
                try{
                    socket.close();
                    System.out.println("Conexiune inchisa de client");
                    
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
