package learnjava;

public class Main {

    public static void main(String[] args) {
	    Account myAccount = new Account("Jithin");
	    myAccount.deposit(1000);
	    myAccount.deposit(2000);
	    myAccount.withdraw(1000);
	    myAccount.checkBalance();
//	    myAccount.balance = 100000;
		System.out.println(myAccount.getBalance());
    }
}
