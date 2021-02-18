package com.acidevil.springdemo;

public class BaseballCoach implements Coach{
	
	
	private FortuneService fortuneService;
	
	
	public BaseballCoach(FortuneService fs) {
		this.fortuneService = fs;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
