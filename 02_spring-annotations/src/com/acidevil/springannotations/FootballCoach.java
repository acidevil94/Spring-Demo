package com.acidevil.springannotations;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {
	
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("FootballCoach after costruct");
	}
	
	
	// FIXME NEVER CALLED!!! -> because of type 'prototype'
//	@PreDestroy
//	public void doMyCleanupStuff() {
//		System.out.println("FootballCoach before destroy");
//	}

	@Override
	public String getDailyWorkout() {
		return "football coach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
