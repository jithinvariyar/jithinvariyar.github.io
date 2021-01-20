package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = appContext.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts = accountDAO.findAccounts();
		System.out.println("From main: " + theAccounts);
		appContext.close();
	}

}
