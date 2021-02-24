package com.acidevil.springannotations.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPExpressions {

	/**
	 * reusable point for different aspect
	 */
	@Pointcut("execution(public void addAccount(*))")
	public void forAddAccount() {
	}
	
	
	@Pointcut("execution(public * findAccounts())")
	public void forFindAccounts() {
	}
}
