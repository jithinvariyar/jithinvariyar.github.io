package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addSillyMember() {
		System.out.println("\n" + getClass() + ": DOING STUFF");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("\n" + getClass() + ": IT IS SLEEP TIME");
	}
}
