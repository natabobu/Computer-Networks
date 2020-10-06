
package serverssl;
import javax.net.ssl.*;
import java.security.Security;
import java.io.*;
import com.sun.net.ssl.internal.ssl.Provider;

public class ServerSSL {

    public static void main(String[] args) {
        int port = 35786;

        Security.addProvider(new Provider());
        System.setProperty("javax.net.ssl.keyStore", "myKeyStore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            System.out.println("Echo server started and ready to accept client connection");
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            DataInputStream inputStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(sslSocket.getOutputStream());
            outputStream.writeUTF("Hello Client, say something");
            while (true) {
                String receivedMessage = inputStream.readUTF();
                System.out.println("Client said: " + receivedMessage);
                if (receivedMessage.equals("close")) {
                    outputStream.writeUTF("Bye");
                    outputStream.close();
                    inputStream.close();
                    sslSocket.close();
                    sslServerSocket.close();
                    break;
                } else {
                    outputStream.writeUTF("You said: " + receivedMessage);
                }
            }
        } catch (Exception e) {
            System.err.println("Error happend " + e.getMessage());
        }
    }
}
