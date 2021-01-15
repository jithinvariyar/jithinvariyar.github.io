package tcs.preparation;

public class Main {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Main.Thread1 thread1 = new Main.Thread1();
        Main.Thread2 thread2 = new Main.Thread2();
        new Thread(thread1).start();
        new Thread(thread2).start();
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread1 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){

                }
                System.out.println("Thread1 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread1 has lock1 and lock 2");
                }
                System.out.println("Thread1 released lock2");
            }
            System.out.println("Thread1 released lock1");
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("Thread2 has lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){

                }
                System.out.println("Thread2 waiting for lock1");
                synchronized (lock1){
                    System.out.println("Thread2 has lock1 and lock2");
                }
                System.out.println("Thread2 released lock1");
            }
            System.out.println("Thread2 released lock2");
        }
    }
}
