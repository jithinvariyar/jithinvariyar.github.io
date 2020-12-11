package tcs.preparation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] factors = new int[100];
        System.out.println("How many numbers you want to check?");
        int n = scanner.nextInt();
        int[] numArray = new int[n];
        scanner.nextLine();
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter" + " number" + (i+1));
            numArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int first = gcd(numArray[0],numArray[1]);
        for(int i = 2 ; i < numArray.length ; i++){
            first = gcd(first,numArray[i]);
            if(first == 1){
                break;
            }
        }
        System.out.println(first);
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else {
            return gcd(b,a % b);
        }
    }
}
