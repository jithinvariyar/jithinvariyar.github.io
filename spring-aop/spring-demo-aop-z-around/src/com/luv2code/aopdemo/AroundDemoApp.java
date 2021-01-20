package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theFortuneService = appContext.getBean("trafficFortuneService",TrafficFortuneService.class);
		String data = theFortuneService.getFortune();
		System.out.println(data);
		appContext.close();
	}

}
