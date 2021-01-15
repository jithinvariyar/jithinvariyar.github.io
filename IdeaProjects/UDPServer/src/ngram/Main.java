package ngram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Main {

    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(5000);
            while (true){
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);
                System.out.println("Text received is: " + new String(buffer));

                String returnString = "Echo from server: " + new String(buffer);
                byte[] buffer1 = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                DatagramPacket packet1 = new DatagramPacket(buffer1,buffer1.length,address,port);
                socket.send(packet1);
            }
        } catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
