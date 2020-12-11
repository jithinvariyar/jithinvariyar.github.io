package ngram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echoString;
            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();
                byte[] buffer = echoString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,5000);
                datagramSocket.send(packet);

                byte[] buffer1 = new byte[1024];
                DatagramPacket packet1 = new DatagramPacket(buffer1,buffer1.length);
                datagramSocket.receive(packet1);
                System.out.println(new String(buffer1));
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
