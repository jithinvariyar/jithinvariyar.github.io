package com.company;

public class Test {
    private static boolean i = true;
    private static int j = 0;
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i == true){
                    j++;
                }
                System.out.println(j);
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hai");
                i = false;
            }
        });

        threadA.start();
        threadB.start();
    }
}

