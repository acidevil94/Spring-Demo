package com.acidevil.springannotations.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acidevil.springannotations.aop.dao.AccountDAO;
import com.acidevil.springannotations.aop.entity.Account;
import com.acidevil.springannotations.aop.service.FortuneService;

public class AOPDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		ThrowComponent throwComp = context.getBean("throwComponent", ThrowComponent.class);
		FortuneService fortuneService = context.getBean("fortuneService", FortuneService.class);

		accountDAO.addAccount("testAccount");

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("Finished search, size:" + accounts.size());

		try {
			throwComp.throwMethod();
		} catch (Exception exc) {
			System.out.println("Main program: exception");
		}

		String fortune = fortuneService.getFortune();

		System.out.println("Main App: fortune : " + fortune);

		context.close();
	}
}
