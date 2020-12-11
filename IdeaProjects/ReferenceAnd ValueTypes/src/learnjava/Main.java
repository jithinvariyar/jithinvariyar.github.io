package learnjava;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int myInt = 10;
	    int newInt = myInt;
        System.out.println("myInt = " + myInt);
        System.out.println("newInt = " + newInt);
        myInt++;
        System.out.println("new myInt = " + myInt);
        System.out.println("new newInt = " + newInt);

        int[] myIntArray = new int[5];
        int myNewIntArray[] = myIntArray;
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("myNewIntArray = " + Arrays.toString(myNewIntArray));
        myIntArray[0] = 1;
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("myNewIntArray = " + Arrays.toString(myNewIntArray));
        myNewIntArray = new int[]{4,5,6,7,8};
        modifyArray(myIntArray);
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("myNewIntArray = " + Arrays.toString(myNewIntArray));

    }

    private static void modifyArray(int[] array){
        array[0] = 2;
        array = new int[] {1,2,3,4,5};
    }
}
