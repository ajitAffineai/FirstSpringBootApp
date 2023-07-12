package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
	
	
	@GetMapping("/")
	public String wellcome() {
		return "wellcome !" ;
	}
	
	@GetMapping("/Hello-World")
	public String helloWorld() {
		return "Hello World !" ;
	}
	@GetMapping("/student-info")
	public StudentsInfo getStudentInfo() {
		return new StudentsInfo("ajit","dash",20) ;
	}
	@GetMapping("/students-info")
	public List<StudentsInfo> getStudentsInfo(){
		List<StudentsInfo> Students = new ArrayList<>();
		Students.add(new StudentsInfo("Ramesh","c",21));
		Students.add(new StudentsInfo("Ram","chalec",19));
		Students.add(new StudentsInfo("Jhon","kach",19));
		Students.add(new StudentsInfo("Rk","jain",19));
		Students.add(new StudentsInfo("Ram","chalec",19));
		return Students;
	}
	
}

