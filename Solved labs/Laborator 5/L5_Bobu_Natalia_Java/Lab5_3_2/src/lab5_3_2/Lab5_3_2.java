/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_3_2;

import java.io.*;
import java.util.zip.CheckedInputStream;
import java.util.zip.CRC32;

public class Lab5_3_2 {

    public static void main(String[] args) {
        try {
            CRC32 crc32 = new CRC32();
            CheckedInputStream cis = new CheckedInputStream(new FileInputStream("test.txt"), crc32);
            byte[] tempBuf = new byte[128];
            while (cis.read(tempBuf) >= 0) {
            }
            long checksum = cis.getChecksum().getValue();
            System.out.println("Valoare CRC32 (long):" + checksum);
            String formatare = Long.toHexString(checksum & 0x0ffffffffL);
            System.out.println("Valoare CRC32 (hex): " + formatare);
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.exit(-1);
        }
    }

}
