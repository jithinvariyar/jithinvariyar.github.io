package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling the method " + methodName);
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args) {
			myLogger.info("====> The Arguments are: " + arg);
		}
	}
	
	
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @AfterReturning: from method " + methodName);
		myLogger.info("====> the result returned from the method is: " + theResult);
	}
}
