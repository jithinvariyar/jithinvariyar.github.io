package learnjava;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("SBI");
    public static void main(String[] args) {
        boolean quit = false;
        showOperationList();
        while(!quit){
            System.out.println("Select the desired operation : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1 :
                    addNewBranch();
                    break;
                case 2 :
                    addNewCustomer();
                    break;
                case 3 :
                    addTransaction();
                    break;
                case 4 :
                    showList();
                    break;
                case 5 :
                    showOperationList();
                    break;
                case 6 :
                    quit = true;
                    break;
            }
        }
    }

    private static void addTransaction(){
        System.out.println("Enter the name of customer : ");
        String custName = scanner.nextLine();
        System.out.println("Enter the branch name : ");
        String braName = scanner.nextLine();
        System.out.println("Enter the transaction amount");
        double transaction = scanner.nextDouble();
        scanner.nextLine();
        bank.addTransaction(custName,braName,transaction);
    }

    private static void showList(){
        System.out.println("Enter the name of the branch");
        String braName = scanner.nextLine();
        bank.customerList(braName);
    }

    private static void addNewBranch(){
        System.out.println("Enter the name of the branch");
        String newBank = scanner.nextLine();
        boolean status = bank.addNewBranch(newBank);
        if(status == true){
            System.out.println("The branch " +newBank + " Successfully added");
        }
        else{
            System.out.println("The branch " + newBank + " Already added");
        }
    }

    private static void addNewCustomer(){
        System.out.println("Enter the name of customer : ");
        String custName = scanner.nextLine();
        System.out.println("Enter the branch name : ");
        String braName = scanner.nextLine();
        System.out.println("Enter the initial amount");
        double initial = scanner.nextDouble();
        scanner.nextLine();
        boolean status = bank.addCustomer(custName,braName,initial);
        if(status == true){
            System.out.println("The customer " +custName + " Successfully added in to the branch " +braName + " With an initial transaction of " +initial);
        }
        else{
            System.out.println("The customer " + custName + " Unable to add");
        }
    }
    private static void showOperationList(){
        System.out.println("1. Add a new branch\n2. Add anew customer to an existing branch\n3. Add transactions for an existing customer in a particular branch\n4. Show list of customers with their transactions in a particular branch\n5. Show operations\n6.Quit");
    }
}
