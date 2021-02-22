package com.acidevil.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a new student
		Student theStudent = new Student();

		// add student to model
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("the student: " + student);
		return "student-confirmation";
	}
}
