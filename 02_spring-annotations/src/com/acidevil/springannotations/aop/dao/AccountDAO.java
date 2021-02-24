package com.acidevil.springannotations.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.acidevil.springannotations.aop.entity.Account;

@Component
public class AccountDAO {

	public void addAccount(String account) {
		System.out.println(this.getClass() + ": DOING MY DB WORK ADDACCOUNT");
	}

	public List<Account> findAccounts() {
		List<Account> myAcc = new ArrayList<>();

		Account acc1 = new Account("John", "Silver");
		Account acc2 = new Account("Andrea", "Coluzzi");

		myAcc.add(acc1);
		myAcc.add(acc2);
		
		System.out.println("Returning accounts");
		return myAcc;
	}
}
