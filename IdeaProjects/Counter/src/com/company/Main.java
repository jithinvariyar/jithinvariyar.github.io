package com.company;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Thread thread1 = new CountdownThread(countdown);
        Thread thread2 = new CountdownThread(countdown);
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }
}

class Countdown{
    private int i;
    public void doCountdown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this){
            for(i= 10 ; i>=0 ; i--){
                System.out.println(color +Thread.currentThread().getName() + ": i= " +i);
            }
        }

    }
}

class CountdownThread extends Thread{
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}
