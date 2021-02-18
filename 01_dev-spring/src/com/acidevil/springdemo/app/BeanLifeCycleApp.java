package com.acidevil.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {

	public static void main(String[] args) {

		// load spring file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-appContext.xml");

		// close context
		context.close();
	}

}
