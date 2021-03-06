package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(9);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic";
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major Accident!!");
		}
		return getFortune();
	}
}
