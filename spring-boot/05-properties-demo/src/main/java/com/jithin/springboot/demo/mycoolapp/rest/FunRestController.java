package com.jithin.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject properties from application.properties
	@Value("${coach.name}")
	private String coachName;
	@Value("${coach.team}")
	private String teamName;

	@GetMapping("/")
	public String sayHello() {
		return "Hellow World! The time on the server is " + LocalDateTime.now();
	}

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return coachName + " : " + teamName;
	}
}
