package learnjava;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many elements should be there in the array..?");
        int count = scanner.nextInt();
        int[] array = readIntegers(count);
        System.out.println("The minimum element in the given array is = " +findMin(array));
    }

    public static int[] readIntegers(int count){
        int[] array = new int[count];
        int i = 0 ;
        while(count > 0){
            System.out.println("Enter the number : ");
            array[i] = scanner.nextInt();
            count--;
            i++;
        }
        return array;
    }

    public static int findMin(int[] array){
        int min = array[0];
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
