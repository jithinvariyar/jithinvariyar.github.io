package learnjava;

import java.util.ArrayList;

public class Account {
    private String name;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String name){
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount > 0){
            transactions.add(amount);
            System.out.println("TRANSACTION SUCCESSFUL. Deposited amount = " + amount);
            this.balance += amount;
        }
        else{
            System.out.println("TRANSACTION FAILED. Can not deposit negative amount");
        }
    }

    public void withdraw(int amount){
        int withdrawAmount = -amount;
        if(withdrawAmount < 0){
            transactions.add(withdrawAmount);
            System.out.println("TRANSACTION SUCCESSFUL. Withdraw amount = " + amount);
            this.balance -= amount;
        }
        else{
            System.out.println("TRANSACTION FAILED. Can not withdraw negative amount");
        }
    }

    public void checkBalance(){
        this.balance = 0;
        for(int i : this.transactions){
            balance += i;
        }
        System.out.print("Total balance in the account is = ");
    }












}
