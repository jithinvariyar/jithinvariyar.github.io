package com.company;

import static com.company.ThreadColor.ANSI_GREEN;
import static com.company.ThreadColor.ANSI_PURPLE;
import static com.company.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join(3000);
                    System.out.println(ANSI_RED + "anotherThread terminated. or timed out. So iam running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I could not wait after all. I was interrupted");
                }
            }
        });


        myRunnableThread.start();

        System.out.println(ANSI_PURPLE+"Hello again from the main thread.");


    }
}
