package learnjava;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many Elements you want in array..?");
        int count = scanner.nextInt();
        int[] array = new int[count];
        for(int i = 0 ; i < count ; i++){
            System.out.println("Enter the element : ");
            array[i] = scanner.nextInt();
        }
        int[] beforeArray = Arrays.copyOf(array , array.length);
        System.out.println("The original array is : " + Arrays.toString(beforeArray));
        reverse(array);
    }

    public static void reverse(int[] array){
        int length = array.length - 1;
        int temp;
        for(int i = 0 ; i < ((array.length) / 2 ) ; i++){
            temp = array[i];
            array[i] = array[length];
            array[length] = temp;
            length--;
        }
        System.out.println("The reversed array is : " + Arrays.toString(array));
    }
}
