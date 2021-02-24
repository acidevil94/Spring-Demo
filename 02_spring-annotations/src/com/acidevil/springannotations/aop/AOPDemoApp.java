package com.acidevil.springannotations.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acidevil.springannotations.aop.dao.AccountDAO;
import com.acidevil.springannotations.aop.entity.Account;

public class AOPDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount("testAccount");
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("Finished search, size:" + accounts.size());
		
		context.close();
	}
}
