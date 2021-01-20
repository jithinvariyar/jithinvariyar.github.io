package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": DOING SOME WORKS");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": INSIDE getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": INSIDE setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": INSIDE getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": INSIDE setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
