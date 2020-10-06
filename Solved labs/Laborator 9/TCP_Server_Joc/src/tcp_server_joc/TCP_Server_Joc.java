package tcp_server_joc;

import java.io.*;
import java.net.*;
import java.math.*;
public class TCP_Server_Joc {

    public static void main(String[] args) {
        int nr=(int)(Math.random()*500);
        System.out.println(nr);
        int nr_client;
        int port;
        ServerSocket serverSocket;
        BufferedReader input;
        PrintWriter output;
        try{
            port=Integer.parseInt(args[0]);
        }
        catch(Exception e){
            System.out.println("port=15876 (default)");
            port=15876;
        }
        try{
            serverSocket=new ServerSocket(port);
            //System.out.println("Serverul este activ la portul"+ serverSocket.getLocalPort());
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("Conexiune acceptata "+socket.getInetAddress()+":"+socket.getPort());
                input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                try{
                    while(true){
                        String message=input.readLine();
                        if(message==null) break;
                        nr_client=Integer.parseInt(message);
                        if(nr==nr_client){
                            output.println("Corect");
                            break;
                        }
                        else if(nr<nr_client){
                            output.println("Inroduceti un numar mai mic");
                        }
                        else if(nr>nr_client){
                            output.println("Introduceti un numar mai mare");
                        }
                        //System.out.println(message);
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
