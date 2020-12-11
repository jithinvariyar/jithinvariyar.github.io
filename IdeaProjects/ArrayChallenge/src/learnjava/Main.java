package learnjava;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    int limit;
        System.out.println("How many numbers you want to enter..?");
        limit = scanner.nextInt();
        int[] array = getIntegers(limit);
        printArray(array);
        sortIntegers(array);
        printArray(array);
        //int[] sortedArray = Arrays.copyOf(array,3);
        //System.out.println(sortedArray.length);
        //System.out.println(sortedArray[2]);
    }

    public static int[] getIntegers(int limit){
        int[] buildArray = new int[limit];
        for (int i = 0 ; i < buildArray.length ; i++){
            System.out.println("Enter the number : ");
            buildArray[i] = scanner.nextInt();
        }
        return buildArray;
    }
    public static void printArray(int[] array){
        System.out.println("Array is...");
        for (int i = 0 ; i < array.length ; i++){
            System.out.println("The " + i + "th element is : " + array[i]);
        }
    }
    public static int[] sortIntegers(int[] array){
        int temp;
        int flag =0;
        for(int i = 0 ; i < array.length ; i++){
            for (int j = i+1 ; j< array.length ; j++){
                if(array[j] > array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    flag =1;
                }
            }
            if(flag == 0){
                break;
            }
        }
        System.out.println("After sorting ,");
        return array;
    }
}
