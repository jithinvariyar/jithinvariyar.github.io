package tcs.preparation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker(ThreadColor.ANSI_BLUE),"Priority10");
        Thread thread2 = new Thread(new Worker(ThreadColor.ANSI_CYAN),"Priority8");
        Thread thread3 = new Thread(new Worker(ThreadColor.ANSI_GREEN),"Priority6");
        Thread thread4 = new Thread(new Worker(ThreadColor.ANSI_PURPLE),"Priority4");
        Thread thread5 = new Thread(new Worker(ThreadColor.ANSI_RED),"Priority2");

//        thread5.setPriority(10);
//        thread2.setPriority(8);
//        thread3.setPriority(6);
//        thread4.setPriority(4);
//        thread1.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private static class Worker implements Runnable{
        int counter = 1;
        String color;

        public Worker(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            for(int i = 0 ; i < 100 ; i++){
                lock.lock();
                try {
                    System.out.println(color + Thread.currentThread().getName() + ": counter= " + counter++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
