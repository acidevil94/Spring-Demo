package com.acidevil.springannotations.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(String account) {
		System.out.println(this.getClass() + ": DOING MY DB WORK ADDACCOUNT");
	}
}
