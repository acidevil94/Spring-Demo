package com.acidevil.springannotations;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "practice your back hand volley";
	}

}
