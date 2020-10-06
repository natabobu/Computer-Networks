package lab5_3_5;

import java.io.*;

public class Adrese {

    private String adresaIp;
    private String mascaSubretea;
    private String intAdrIp;
    private String intmascSR;
    private PrintWriter pw;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Adrese(String adresaIp, String mascaSubretea) throws IOException {
        this.adresaIp = adresaIp;
        this.mascaSubretea = mascaSubretea;
        pw = new PrintWriter(new FileWriter("date.txt",false));
    }

    public String getAdresaIp() {
        return adresaIp;
    }

    public String getMascaSubretea() {
        return mascaSubretea;
    }
    
    public int verificaAdrese(){
        System.out.println(ANSI_GREEN+"Verifica adrese"+ANSI_RESET);
        String strIP = adresaIp;
        boolean err = false;
        String output = null;
        String[] sIP = strIP.split("\\.");
        if (sIP.length != 4) {
            err = true;
            output = "Adresa IP incorecta: o adresa IP are 4 campuri numerice!\n";
            return -1;
        }
        int[] intIP = new int[4];
        for (int i = 0; i < 4; i++) {
            intIP[i] = Integer.parseInt(sIP[i]);
            if ((intIP[i] < 0 || intIP[i] > 255)) {
                err = true;
                output = "Adresa IP incorecta:" + "Campurile unei adrese IP pot lua valori numai intre 0 si 255!\n";
                return -1;
            }
        }
        String masca = mascaSubretea;
        String[] m = mascaSubretea.split("\\.");
        if (m.length != 4) {
            err = true;
            output = "Masca de subretea incorecta: o masca SR are 4 campuri numerice!\n";
            return -1;
        }
        int[] intM = new int[4];
        for (int i = 0; i < 4; i++) {
            intM[i] = Integer.parseInt(m[i]);
            if ((intM[i] < 0 || intM[i] > 255)) {
                err = true;
                output = "Masca de subretea incorecta:" + "Campurile unei masti SR pot lua valori numai intre 0 si 255!\n";
                return -1;
            }
        }
        int adresa=0;
        int adresa1=0;
        for (int i = 3; i >= 0; i--) {
            adresa = adresa | (intIP[i] << (8 * (3 - i)));
        }
        for (int i = 3; i >= 0; i--) {
            adresa1 = adresa1 | (intM[i] << (8 * (3 - i)));
        }
        intAdrIp=toBits(adresa);
        System.out.println("Adresa IP in format binar :"+intAdrIp);
        intmascSR=toBits(adresa1);
        System.out.println("Masca SR in format binar :"+intmascSR);
        pw.print("Adresa IP in format binar :"+intAdrIp+"\n");
        pw.print("Masca SR in format binar :"+intmascSR+"\n");
        return 0;
    }
    public void testareAdresa() {
        System.out.println(ANSI_BLUE+"Testare adresa IP"+ANSI_RESET);
        String strIP = adresaIp; 
        String[] sIP=strIP.split("\\.");    
        System.out.println("Adresa IP este de clasa " + getClass(Integer.parseInt(sIP[0])));
        pw.print("Adresa IP este de clasa " + getClass(Integer.parseInt(sIP[0]))+"\n");
    }

    public void netIdHostId() {
        System.out.println(ANSI_CYAN+"Verificare Masca de Subretea"+ANSI_RESET);
        String masca = mascaSubretea;
        String[] m = mascaSubretea.split("\\.");
        String binarMSR=intmascSR;
        int contor=0;
        for(int i=0;i<binarMSR.length();i++){
            if(binarMSR.charAt(i)=='1')
                contor++;
        }
        System.out.println("Nr. biti pentru retea : "+contor);
        System.out.println("Nr. biti pentru host : "+(32-contor));
        System.out.println("Masca de subretea : /"+contor);
        pw.print("Nr. biti pentru retea : "+contor+"\n");
        pw.print("Nr. biti pentru host : "+(32-contor)+"\n");
        pw.print("Masca de subretea : /"+contor+"\n");
    }
    public void adresaSubretea(){
        System.out.println(ANSI_PURPLE+"Verifica Adresa Subretea"+ANSI_RESET);
        String adrIP=intAdrIp;
        String masca=intmascSR;
        String rsp="";
        boolean a,b;
        for(int i=0;i<32;i++){
            if(adrIP.charAt(i)=='1')
                a=true;
            else
                a=false;
            if(masca.charAt(i)=='1')
                b=true;
            else
                b=false;
            if(a&&b)
                rsp+='1';
            else
                rsp+='0';
        }
        System.out.println("Adresa in binar a subretelei din care face parte adresa IP: "+rsp);
        pw.print("Adresa in binar a subretelei din care face parte adresa IP: "+rsp+"\n");
        String[] retea=new String[4];
        int index=0,idx=0;
        while(index<rsp.length()-5){
            retea[idx]=rsp.substring(index,index+8);
            index+=8;
            idx++;
        }
        String reteadec="";
        for(int i=0;i<retea.length;i++){
            if(reteadec.length()>0)
                reteadec+=".";
            reteadec+=Integer.parseInt(retea[i], 2);
        }
        System.out.println("Adresa in format zecimal a subretelei din care face parte adresa IP: "+reteadec);
        pw.print("Adresa in format zecimal a subretelei din care face parte adresa IP: "+reteadec+"\n");
    }
    public void mascaSR(){
        System.out.println(ANSI_GREEN+"Masca de subretea a clasei"+ANSI_RESET);
        String[] adr=adresaIp.split("\\.");
        char clasa=getClass(Integer.parseInt(adr[0]));
        String rsp="";
        switch(clasa){
            case 'A' : rsp="255.0.0.0";break;
            case 'B' : rsp="255.255.0.0" ;break;
            case 'C' : rsp="255.255.255.0";break;
            case 'D' : rsp="Nu este definita";break;
            case 'E' : rsp="Nu este definita";break;
            case 'F' : rsp="Nu este definita";break;
        }
        System.out.println("Masca de subretea pentru clasa de adrese din care face parte adresa IP : "+rsp);
        pw.print("Masca de subretea pentru clasa de adrese din care face parte adresa IP : "+rsp+"\n");
    }
    public void nrSR(){
        System.out.println(ANSI_CYAN+"Numar subretele posibile"+ANSI_RESET);
        String[] adr=adresaIp.split("\\.");
        char clasa=getClass(Integer.parseInt(adr[0]));
        String rsp="";
        switch(clasa){
            case 'A' : rsp="128 (2^7)";break;
            case 'B' : rsp="16384 (2^14)" ;break;
            case 'C' : rsp="2097152 (2^21)";break;
            case 'D' : rsp="Nu este definita";break;
            case 'E' : rsp="Nu este definita";break;
            case 'F' : rsp="Nu este definita";break;
        }
        System.out.println("Numarul de subretele posibile in reteaua specificata : "+rsp);
        pw.print("Numarul de subretele posibile in reteaua specificata : "+rsp+"\n");
    }
    public void nrHosts(){
        System.out.println(ANSI_PURPLE+"Numar gazde subretea"+ANSI_RESET);
        String[] adr=adresaIp.split("\\.");
        char clasa=getClass(Integer.parseInt(adr[0]));
        String rsp="";
        switch(clasa){
            case 'A' : rsp="16,777,216 (2^24)";break;
            case 'B' : rsp="65,536 (2^16)" ;break;
            case 'C' : rsp="256 (2^8)";break;
            case 'D' : rsp="Nu este definit";break;
            case 'E' : rsp="Nu este definit";break;
            case 'F' : rsp="Nu este definit";break;
        }
        System.out.println("Numarul de gazde pentru fiecare subretea in parte : "+rsp);
        pw.print("Numarul de gazde pentru fiecare subretea in parte : "+rsp+"\n");
    }
    public void adresaBroadcast(){
        System.out.println(ANSI_BLUE+"Verifica Adresa Subretea"+ANSI_RESET);
        String adrIP=intAdrIp;
        String masca=intmascSR;
        String rsp="";
        boolean a,b;
        for(int i=0;i<32;i++){
            if(adrIP.charAt(i)=='1')
                a=true;
            else
                a=false;
            if(masca.charAt(i)=='1')
                b=false;
            else
                b=true;
            if(a||b)
                rsp+='1';
            else
                rsp+='0';
        }
        System.out.println("Adresa broadcast in binar a retelei : "+rsp);
        pw.print("Adresa broadcast in binar a retelei : "+rsp+"\n");
        String[] broadcast=new String[4];
        int index=0,idx=0;
        while(index<rsp.length()-5){
            broadcast[idx]=rsp.substring(index,index+8);
            index+=8;
            idx++;
        }
        String broadcastdec="";
        for(int i=0;i<broadcast.length;i++){
            if(broadcastdec.length()>0)
                broadcastdec+=".";
            broadcastdec+=Integer.parseInt(broadcast[i], 2);
        }
        System.out.println("Adresa broadcast in format zecimal : "+broadcastdec);
        pw.print("Adresa broadcast in format zecimal : "+broadcastdec+"\n");
    }

    public char getClass(int firstByte) {
        if ((firstByte & 0x80) == 0) {
            return 'A';
        } else if ((firstByte & 0xC0) == 0x80) {
            return 'B';
        } else if ((firstByte & 0xE0) == 0xC0) {
            return 'C';
        } else if ((firstByte & 0xF0) == 0xE0) {
            return 'D';
        } else if ((firstByte & 0xF8) == 0xF0) {
            return 'E';
        } else {
            return 'F';
        }
    }

    public int getBit(int nr, int b) {
        if (b > 31) {
            return 0;
        }
        int x = 1;
        x = x << b;
        if ((nr & x) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private String toBits(int n) {
        String ret = "";
        for (int i = 31; i >= 0; i--) {
            ret += getBit(n, i);
        }
        return ret;
    }
    public void finish(){
        pw.close();
    }
}
