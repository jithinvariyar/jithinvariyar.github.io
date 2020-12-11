package learnjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int i = 1;
	    int flag = 0;
	    int sum = 0;
        Scanner scanner = new Scanner(System.in);
	    while(i <= 10){
            System.out.print("Enter number #" + i + " : ");
            boolean hasNextInt = scanner.hasNextInt();
            if(!hasNextInt){
                System.out.println("The " + i + "th entered value is not an integer");
                i--;
                flag = 1;
                break;
            }
            int number = scanner.nextInt();
            sum = sum + number;
            i++;
        }
	    if(flag == 0) {
            System.out.println("The sum of given Ten numbers is = " + sum);
        }
	    scanner.close();
    }
}
