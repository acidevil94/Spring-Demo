package com.acidevil.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach footballCoach1 = context.getBean("footballCoach", Coach.class);
		Coach footballCoach2 = context.getBean("footballCoach", Coach.class);
		Coach tennisCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach tennisCoach2 = context.getBean("thatSillyCoach", Coach.class);

		System.out.println(footballCoach1.getDailyWorkout());
		System.out.println(tennisCoach.getDailyWorkout());
		
		System.out.println(footballCoach1.getDailyFortune());
		System.out.println(tennisCoach.getDailyFortune());
		
		
		System.out.println(footballCoach1 == footballCoach2);		// false
		System.out.println(tennisCoach == tennisCoach2);		// true

		context.close();

	}

}
