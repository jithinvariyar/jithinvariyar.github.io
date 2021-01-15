package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    Socket socket;
    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection made with client");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            while (true){

                String echoString = input.readLine();
                if(echoString.equals("exit")){
                    break;
                }
                try {
                    Thread.sleep(15000);
                }catch (InterruptedException e){
                    e.getStackTrace();
                }
                output.println("Echo from server " + echoString);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
