package com.acidevil.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acidevil.springdemo.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		this.students = new ArrayList<>();
		this.students.add(new Student("Andrea", "Coluzzi"));
		this.students.add(new Student("Mario", "Rossi"));
	}

	@GetMapping("/list")
	public List<Student> getStudents() {
		return this.students;
	}

	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId < 0 || studentId >= this.students.size()) {
			throw new StudentNotFoundException("Student not found with id: " + studentId);
		}

		return this.students.get(studentId);
	}

}
