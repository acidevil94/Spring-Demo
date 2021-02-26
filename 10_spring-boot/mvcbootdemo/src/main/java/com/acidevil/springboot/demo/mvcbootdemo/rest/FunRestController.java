package com.acidevil.springboot.demo.mvcbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@GetMapping("/")
	public String sayHello () {
		return "Hello World";
	}
	
	@GetMapping("/foo")
	public String sayHelloFoo () {
		return "Hello Foo World";
	}
}
