package com.acidevil.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach footballCoach = context.getBean("footballCoach", Coach.class);
		Coach tennisCoach = context.getBean("thatSillyCoach", Coach.class);

		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyWorkout());
		
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(tennisCoach.getDailyFortune());

		context.close();

	}

}
