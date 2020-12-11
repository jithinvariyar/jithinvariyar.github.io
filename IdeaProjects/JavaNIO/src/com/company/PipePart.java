package com.company;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipePart {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            Runnable writeThread = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for(int i = 0; i < 10; i++){
                            String currentTime = "The current time is " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }

                }
            };

            Runnable readThread = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i < 10; i++){
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }


                }
            };

            new Thread(writeThread).start();
            new Thread(readThread).start();
        } catch (IOException e){
            e.getMessage();
        }

    }
}
