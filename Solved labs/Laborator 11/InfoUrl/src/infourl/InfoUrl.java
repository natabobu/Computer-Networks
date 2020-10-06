package infourl;

import java.net.*;

public class InfoUrl {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://docs.oracle.com:443/javase/tutorial/");
            System.out.println("URL-ul este " + u);
            System.out.println("Protocolul este " + u.getProtocol());
            String host = u.getHost();
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1) {
                    host = host.substring(atSign + 1);
                }
                System.out.println("Hostname este " + host);
            } else {
                System.out.println("Nu avem hostname");
            }
            System.out.println("Portul este " + u.getPort());
            System.out.println("Calea este " + u.getPath());
            System.out.println("Ancora este " + u.getRef());
            System.out.println("Sirul de interogare este " + u.getQuery());
        }catch(MalformedURLException e){
            System.err.println(e.getMessage());
    }
}

}
