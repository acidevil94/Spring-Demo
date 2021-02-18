package com.acidevil.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " + this.fortuneService.getFortune();
	}

	
	
	public void doMyStartupStuff() {
		System.out.println("Starting up...");
	}
	
	public void doMyDestroySuff() {
		System.out.println("Cleaning up...");
	}
}
