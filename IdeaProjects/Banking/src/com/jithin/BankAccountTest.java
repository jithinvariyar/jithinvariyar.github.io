package com.jithin;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    @org.junit.Before
    public void setup(){
        account = new BankAccount("Jithin","MV",1000.00,BankAccount.CHECKING);
        System.out.println("Running a test");
    }
    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200,true);
        assertEquals(1200,balance,0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600,false);
    }
    @org.junit.Test
    public void withdraw_branch(){
        double balance = account.withdraw(600.00,true);
        assertEquals(400.00,account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200,true);
        assertEquals(1200,account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200,true);
        assertEquals(800,account.getBalance(),0);
    }

    @org.junit.Test
    public void isChecking_true(){
        assertTrue("The account is NOT a checking account",account.isChecking());
    }

}