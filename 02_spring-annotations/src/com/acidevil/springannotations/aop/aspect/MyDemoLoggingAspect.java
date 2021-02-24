package com.acidevil.springannotations.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/**
	 * reusable point for different aspect
	 */
	@Pointcut("execution(public void addAccount(*))")
	private void forAddAccount() {
	}

	@Before("forAddAccount()")
	public void beforeAddAccountAdvice() {
		System.out.println("Before addAccount");
	}
	
	@Before("forAddAccount()")
	public void beforeAddAccountAdvice2(JoinPoint joinPoint) {
		System.out.println("Before addAccount 2");
		
		MethodSignature sig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Signature: " + sig);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object arg : args) {
			System.out.println("Arg: " + arg);
		}
	}

}
