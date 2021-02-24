package com.acidevil.springannotations.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class FortuneAspect {

	@Around("com.acidevil.springannotations.aop.aspect.AOPExpressions.forGetFortune()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedJoinPoint) throws Throwable {

		String method = proceedJoinPoint.getSignature().toShortString();
		System.out.println("Aspect: Intercept call " + method);

		long begin = System.currentTimeMillis();

		Object result = proceedJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;

		System.out.println("Aspect: Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

}
