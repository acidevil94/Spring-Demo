package com.acidevil.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		//read req par from form
		String thename = request.getParameter("studentName");
		
		// convert to all upper case
		thename = thename.toUpperCase();
		// create a message
		String result = "Yo!" + thename;
		// add messagge to  the model
		model.addAttribute("message", result);
		return "helloworld";
	}
}
