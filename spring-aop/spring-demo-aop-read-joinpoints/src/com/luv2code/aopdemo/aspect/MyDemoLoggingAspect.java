package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
