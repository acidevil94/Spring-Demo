package com.acidevil.springannotations;

public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "database fortune";
	}

}
