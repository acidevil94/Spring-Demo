package com.acidevil.springdemo;

public class FootballCoach implements Coach {

	

	private FortuneService fortuneService;
	private String email;
	
	public FootballCoach() {
		System.out.println("FootballCoach: inside no args costructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Go and run for 50 minutes";
	}
	
	
	
	public void setEmail(String email) {
		System.out.println("FootballCoach: inside setEmail");
		this.email = email;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("FootballCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune() + " " + this.email;
	}

}
