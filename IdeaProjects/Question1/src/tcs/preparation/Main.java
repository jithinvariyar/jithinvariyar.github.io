package tcs.preparation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] labels;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCoins;
        int temp = 0;
        System.out.println("Enter total number of coins");
        totalCoins = scanner.nextInt();
        labels = new int[totalCoins];
        scanner.nextLine();
        scanner.useDelimiter(" ");
        System.out.println("Enter the number on each coin with a space");
        String[] input = scanner.nextLine().split(" ");
        for(String item : input){
            labels[temp] = Integer.parseInt(item);
            temp++;
        }
        for (int i = 0 ; i < labels.length ; i++){
            int exist = contains(labels[i],i);
            if (exist % 2 != 0){
                System.out.println(labels[i]);
                break;
            }
        }
    }

    public static int contains(int item,int pos){
        int count = 1;
        for (int i=0; i<labels.length;i++){
            if(i==pos){
                continue;
            }
            if (labels[i] == item){
                count++;
            }
        }
        return count;
    }
}
