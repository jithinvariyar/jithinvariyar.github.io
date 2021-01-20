package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = appContext.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts  = null;
		try {
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("Main program caught the exception: " + exc);
		}
		
		System.out.println("From main: " + theAccounts);
		appContext.close();
	}

}
