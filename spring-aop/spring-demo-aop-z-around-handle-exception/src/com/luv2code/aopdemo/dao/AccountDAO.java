package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println("\n" + getClass() + ": DOING MY DB WORK");
	}
	
	public List<Account> findAccounts(boolean tripWire){
		if(tripWire == true) {
			throw new RuntimeException("No soup for you!!!");
		}
		List<Account> myAccounts = new ArrayList<>();
		Account account1 = new Account("Jithin","Platinum");
		Account account2 = new Account("Jishnu","Silver");
		Account account3 = new Account("Prasad","Gold");
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		return myAccounts;
	}

	public boolean doWork() {
		System.out.println("\n" + getClass() + ": DOING SOME WORKS");
		return true;
	}

	public String getName() {
		System.out.println("\n" + getClass() + ": INSIDE getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("\n" + getClass() + ": INSIDE setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("\n" + getClass() + ": INSIDE getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("\n" + getClass() + ": INSIDE setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
