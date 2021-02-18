package com.acidevil.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	
	@Value("${foo.email}")
	private String email;
	
	// no need setter methods
	@Autowired
	@Qualifier("RESTFortuneService")	// specify which bean to pick
	private  FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("constructor called");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}

	// called automatically (alternative to constructor injection)
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	// called automatically
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Any method autowired will be called");
//		this.fortuneService = fortuneService;
//	}

	// FIXME: never do this
//	@Autowired
//	public void doSomeCrazyStuff2() {
//		System.out.println("Any method autowired will be called, 2");
//	}

	@Override
	public String getDailyWorkout() {
		return "practice your back hand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune() + " " + this.email;
	}

}
