package com.acidevil.springannotations;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {
	
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("FootballCoach after costruct");
	}
	
	@Autowired
	@Qualifier("databaseFortuneService")	// specify which bean to pick
	private  FortuneService fortuneService;
	
	
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
		return this.fortuneService.getFortune();
	}

}
