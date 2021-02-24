package com.acidevil.springannotations.aop;

import org.springframework.stereotype.Component;

@Component
public class ThrowComponent {
	
	
	public void throwMethod() {
		throw new IllegalArgumentException("new Ecxception");
	}

}
