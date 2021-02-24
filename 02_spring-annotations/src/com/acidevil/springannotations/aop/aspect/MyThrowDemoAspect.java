package com.acidevil.springannotations.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyThrowDemoAspect {

	@AfterThrowing(pointcut = "com.acidevil.springannotations.aop.aspect.AOPExpressions.forThrowMethod()", throwing = "exception")
	public void afterThrows(JoinPoint joinPoint, Throwable exception) {
		System.out.println("Aspect: The exception: " + exception);
	}

	@Before("com.acidevil.springannotations.aop.aspect.AOPExpressions.forThrowMethod()")
	public void beforeThrows() {
		System.out.println("Aspect: Calling throw mwethod...");
	}
}
