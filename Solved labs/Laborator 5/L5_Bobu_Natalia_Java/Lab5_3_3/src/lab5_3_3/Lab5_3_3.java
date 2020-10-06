/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_3_3;
import java.io.*;
import java.util.zip.CRC32;
public class Lab5_3_3 {

    public static void main(String[] args) throws IOException{
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        CRC32 checksum=new CRC32();
        String s=br.readLine();
        while(!(s.equals("Exit"))){
            bw.write(s);
            bw.newLine();
            checksum.update(s.getBytes());
            s=br.readLine();
        }
        bw.write(Long.toString(checksum.getValue()));
        bw.newLine();
        bw.close();
        br.close();
    }   
}
