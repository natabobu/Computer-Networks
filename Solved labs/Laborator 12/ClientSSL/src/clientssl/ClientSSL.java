
package clientssl;
import java.io.*;
import javax.net.ssl.*;
import java.security.Security;
import com.sun.net.ssl.internal.ssl.Provider;

public class ClientSSL {

    public static void main(String[] args) {
        int serverPort = 35786;
        String serverName = "localhost";
        Security.addProvider(new Provider());
        System.setProperty("javax.net.ssl.trustStore", "myTrustStore.jts");
        System.setProperty("javax.net.ssl.trustSstorePassword", "123456");
        try {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverName, serverPort);
            DataOutputStream outputStream = new DataOutputStream(sslSocket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(sslSocket.getInputStream());
            System.out.println(inputStream.readUTF());
            BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Write a message: ");
                String messageToSend = cmd.readLine();
                outputStream.writeUTF(messageToSend);
                System.err.println(inputStream.readUTF());
                if (messageToSend.equals("close")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erroe happend: " + e.getMessage());
        }
    }

}

