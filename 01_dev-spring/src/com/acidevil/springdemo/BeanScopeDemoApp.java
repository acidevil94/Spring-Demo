package com.acidevil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	
	
public static void main(String[] args) {
		
		// load spring file
		ClassPathXmlApplicationContext context =
						new ClassPathXmlApplicationContext("beanScope-appContext.xml");
				
		
		Coach theCoach = context.getBean("myCoachProto", Coach.class);		
		Coach alphaCoach = context.getBean("myCoachProto", Coach.class);
		
		boolean result = theCoach == alphaCoach;
		
		System.out.println("Pointing same object: " + result);	// false
		
		
		theCoach = context.getBean("myCoachSingleton", Coach.class);		
		alphaCoach = context.getBean("myCoachSingleton", Coach.class);
		
		result = theCoach == alphaCoach;
		
		System.out.println("Pointing same object: " + result);	// true
		
		// close context
		context.close();
	}
}
