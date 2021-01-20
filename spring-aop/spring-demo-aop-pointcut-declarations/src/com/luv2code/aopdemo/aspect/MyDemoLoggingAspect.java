package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAspect() {
		System.out.println("\nEXECUTING @Before advice On addAccount()");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\nEXECUTING performAnalytics()");

	}
}
