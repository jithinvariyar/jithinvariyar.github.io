package learnjava;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] intArray = getIntegers(5);
        for (int i=0 ; i < intArray.length ; i++){
            System.out.println(intArray[i]);
        }
        System.out.println("The average of entered value is = " +getAverage(intArray));
    }
    public static int[] getIntegers(int number){
        int[] values = new int[number];
        System.out.println("Enter " +number + " Numbers :");
        for (int i = 0 ; i < values.length ; i++){
            values[i] = Integer.parseInt(scanner.nextLine());
        }
        return values;
    }

    public static double getAverage(int[] array){
        double avg = 0.0;
        for (int i = 0 ; i < array.length ; i++){
            avg = avg + array[i];
        }
        return (avg / array.length);
    }
}
