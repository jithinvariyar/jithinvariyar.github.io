package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SeekableChannel {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("binFile1.dat","rwd");
             FileChannel channel = file.getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(250);
            long int1Pos = 0L;
            buffer.putInt(5);
            byte[] inputString = "Hello world".getBytes();
            buffer.put(inputString);
            long int2Pos = Integer.BYTES + inputString.length;
            buffer.putInt(-98765);
            byte[] inputString1 = "Nice to meet you".getBytes();
            buffer.put(inputString1);
            long int3Pos = int2Pos + Integer.BYTES + inputString1.length;
            buffer.putInt(32);
            buffer.flip();
            channel.write(buffer);
            RandomAccessFile copyFile = new RandomAccessFile("binFile1Copy.dat","rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.transferTo(0,channel.size(),copyChannel);
            copyChannel.close();

            buffer.flip();
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            channel.position(int2Pos);
            intBuffer.flip();
            channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            channel.position(int1Pos);
            intBuffer.flip();
            channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));


        } catch (IOException e){
            e.getMessage();
        }
    }
}
