package com.acidevil.springannotations.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acidevil.springannotations.aop.entity.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@AfterReturning(pointcut = "com.acidevil.springannotations.aop.aspect.AOPExpressions.forFindAccounts()", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("Executing after return");
		for (Account acc : result) {
			System.out.println("Returned acc: " + acc);
		}
	}

	@Before("com.acidevil.springannotations.aop.aspect.AOPExpressions.forAddAccount()")
	public void beforeAddAccountAdvice() {
		System.out.println("Before addAccount");
	}

	@Before("com.acidevil.springannotations.aop.aspect.AOPExpressions.forAddAccount()")
	public void beforeAddAccountAdvice2(JoinPoint joinPoint) {
		System.out.println("Before addAccount 2");

		MethodSignature sig = (MethodSignature) joinPoint.getSignature();

		System.out.println("Signature: " + sig);

		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			System.out.println("Arg: " + arg);
		}
	}

}
