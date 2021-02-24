package com.acidevil.springannotations.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acidevil.springannotations.aop.dao.AccountDAO;

public class AOPDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount();
		
		
		context.close();
	}
}
