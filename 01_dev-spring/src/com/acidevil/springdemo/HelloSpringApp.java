package com.acidevil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	
	public static void main(String[] args) {
		
		// load spring file
		ClassPathXmlApplicationContext context =
						new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean
//		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		Coach theCoach = context.getBean("myFootballCoach", Coach.class);
		
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();
	}
}
