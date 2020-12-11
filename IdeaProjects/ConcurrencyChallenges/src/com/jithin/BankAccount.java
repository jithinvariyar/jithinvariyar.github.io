package com.jithin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock lock;
    private String accountNumber;
    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to get the lock");
            }
        } catch (InterruptedException e){

        }
        System.out.println("Transaction status: " + status);
    }

    public void withdraw(double amount){
        boolean status = false;
        try {
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to get the lock");
            }
        } catch (InterruptedException e){

        }
        System.out.println("Transaction status: " + status);
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number: " + accountNumber);
    }
}
