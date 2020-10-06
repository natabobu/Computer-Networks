package lab5_3_5;

import java.io.IOException;

public class Lab5_3_5 {

    public static void main(String[] args) throws IOException {
        Adrese a = new Adrese("192.168.0.1", "255.255.255.128");
        if (a.verificaAdrese() != -1) {
            a.testareAdresa();
            a.netIdHostId();
            a.adresaSubretea();
            a.mascaSR();
            a.nrSR();
            a.nrHosts();
            a.adresaBroadcast();
            a.finish();
        }
    }

}
