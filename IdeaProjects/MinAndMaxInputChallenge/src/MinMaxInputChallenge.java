import java.util.Scanner;

public class MinMaxInputChallenge {
    public static void main(String[] args) {
        int largest = 0;
        int smallest = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter number : ");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                int number = scanner.nextInt();
                if(smallest == 0 && number != 0){
                    smallest = number;
                }
                if(number > largest){
                    largest = number;
                }
                if(number < smallest){
                    smallest = number;
                }
            }
            else{
                System.out.println("The maximum number is : " +largest + "\nThe minimum number is : " + smallest);
                break;
            }
        }
        scanner.close();
    }
}
