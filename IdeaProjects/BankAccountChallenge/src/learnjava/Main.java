package learnjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	      BankAccount myAccount = new BankAccount(67894567 , 10000 , "Jithin M V" , "jithinvariyarmv@gmail.com" , 956257162);
//        BankAccount myAccount = new BankAccount();
//	      myAccount.setBalance(10000);
//        myAccount.setAccNo(67894567);
//        myAccount.setName("Jithin M V");
//        myAccount.setEmail("jithinvariyarmv@gmail.com");
//        myAccount.setPhNo(956257162);
        System.out.println("\nACCOUNT DETAILS:");
        System.out.println(myAccount.getName() + "\n" + myAccount.getAccNo() + "\n" + myAccount.getPhNo() + "\n" + myAccount.getEmail() + "\n" + myAccount.getBalance() + "\n");
        Scanner scanner = new Scanner(System.in);
        boolean closeTransaction;
        do {
            System.out.print("How much money to deposit? : ");
            double moneyIn = scanner.nextDouble();
            myAccount.deposit(moneyIn);
            System.out.println("Balance amount is : " + myAccount.getBalance());
            System.out.print("Enter the required money : ");
            double moneyOut = scanner.nextDouble();
            myAccount.withdraw(moneyOut);
            System.out.println("Balance amount is : " + myAccount.getBalance());
            System.out.println("Do you want to continue..? (yes/no)");
            scanner.nextLine();
            String further = scanner.nextLine();
            if(further.equals("yes")){
                closeTransaction = true;
            }
            else {
                closeTransaction = false;
            }
        }while(closeTransaction);
        VipCustomer vipPerson = new VipCustomer("Jithin" , 2000000);
        System.out.println(vipPerson.getCreditLimit() + "\n" + vipPerson.getName() + "\n");
    }
}
