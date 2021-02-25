package com.acidevil.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.acidevil.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.acidevil.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.acidevil.springdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();

		this.myLogger.info("Before calling " + method);

		Object[] args = joinPoint.getArgs();

		for (Object temp : args) {
			this.myLogger.info("===>> argument: " + temp);
		}

	}
	
	
	
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();

		this.myLogger.info("After returning " + method);
		
		
		this.myLogger.info("====> result: " + result);
	}
}
