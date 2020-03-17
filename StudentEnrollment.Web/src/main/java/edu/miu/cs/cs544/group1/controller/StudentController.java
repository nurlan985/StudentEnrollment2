package edu.miu.cs.cs544.group1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.service.StudentService;

@RestController
@EnableAutoConfiguration
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getStudent/{Id}")
	public Optional<Student> getStudent(@PathVariable Long Id){
		return studentService.getStudent(Id);
	}

}
