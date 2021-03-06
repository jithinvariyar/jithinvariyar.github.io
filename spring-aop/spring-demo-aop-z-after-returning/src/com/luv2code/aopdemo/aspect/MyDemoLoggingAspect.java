package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
