package client;
import java.io.*;
import java.net.*;
public class Client {
    private InetAddress host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader input;
    private String message;
    private String raspuns;
    private String nume;
    
    public Client(int port, String nume){
        this.port=port;
        this.nume=nume;
        try{
            host=InetAddress.getLocalHost();
            socket=new Socket(host,port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            input=new BufferedReader(new InputStreamReader(System.in));
        }catch(UnknownHostException uhe){
            System.out.println(uhe.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        out.print(nume+"\n");
        while(true){
            solicitaServer();
        }
    }
    private void solicitaServer(){
        try{
            System.out.print("Introduceti mesajul:");
            message=input.readLine();
            out.println(message);
            if(message.equals("EXIT")){
                System.out.println("Inchidere conexiune");
                socket.close();
                System.exit(1);
            }
            raspuns=in.readLine();
            System.out.println("\n SERVER> "+raspuns);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    public static void main(String[] args){
        new Client(15876,"Athlon");
    }
    
}