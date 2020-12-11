package learnjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your year of birth : ");
        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt) {
            int yearOfBirth = Integer.parseInt(scanner.nextLine());
            int age = 2020 - yearOfBirth;
            System.out.print("Enter your name : ");
            String name = scanner.nextLine();
            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + " And your age is " + age);
            } else {
                System.out.println("\nInvalid year of birth");
            }
        }
        else {
            System.out.println("Year of birth should be an integer");
        }
        scanner.close();
    }
}
