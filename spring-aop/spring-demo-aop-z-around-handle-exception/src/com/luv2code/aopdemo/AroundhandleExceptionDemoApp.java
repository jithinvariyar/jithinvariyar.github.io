package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundhandleExceptionDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theFortuneService = appContext.getBean("trafficFortuneService",TrafficFortuneService.class);
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		System.out.println(data);
		appContext.close();
	}

}
