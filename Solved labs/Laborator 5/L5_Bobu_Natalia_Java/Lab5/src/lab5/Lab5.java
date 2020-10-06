/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
 import java.io.*;
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CRC32 crc=new CRC32();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduceti textul: ");
            String s=br.readLine();
            byte[] sir=s.getBytes();
            String formatare=Long.toHexString(((long)crc.crc32(sir))&0x0ffffffffL);
            System.out.println("CRC32: "+formatare);  
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage()); 
        }
    }
    
}
