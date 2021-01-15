package com.jithin.learjava;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("myFile.txt","rwd")) {
            file.write(65);
            file.writeInt(4);
            file.seek(0);
            int aByte = file.read();
            System.out.println(aByte);
            if(aByte == 'A'){
                System.out.println("Ascii detected");
            }
            file.seek(0);
            byte[] dest = new byte[5];
            int offset = 0;
            int length = 5;
            int bytesRead = file.read(dest,offset,length);
            System.out.println(bytesRead);
            System.out.println(dest[0]);
            System.out.println(dest.length);
            file.seek(0);
            file.readByte();
            int i = file.readInt();
            System.out.println(i);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
