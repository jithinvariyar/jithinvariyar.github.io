package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	@After("execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		System.out.println("\nEXECUTING afterFinallyFindAccountsAdvice(..)");
	}
	
	@AfterThrowing(
				pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(
				JoinPoint theJoinPoint, Throwable theExc
			) {
		System.out.println("\nEXECUTING afterThrowingFindAccountAdvice()");
		System.out.println("The exception is " + theExc);
	}
	
	@AfterReturning(pointcut="execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,List<Account> result) {
		System.out.println(result);
	}
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAspect(JoinPoint theJoinPoint) {
		MethodSignature signature = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("METHOD: " + signature);
		
		Object[] arr = theJoinPoint.getArgs();
		for(Object ob : arr) {
			System.out.print(ob);
			System.out.println();
		}
		System.out.println("\nEXECUTING beforeAddAccountAspect()");
	}

}
