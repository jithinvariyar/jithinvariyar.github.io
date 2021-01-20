package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = appContext.getBean("accountDAO", AccountDAO.class);
		Account account = new Account();
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		MembershipDAO membership = appContext.getBean("membershipDAO",MembershipDAO.class);
		membership.addSillyMember();
		membership.goToSleep();
		appContext.close();
	}

}
