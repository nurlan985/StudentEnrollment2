package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.service.SectionService;
import edu.miu.cs.cs544.group1.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired

	private SectionService sectionService;
//	
//	@PostMapping("/addStudent")
//	public Student addStudent(Student student) {
//		return studentService.addStudent(student);
//	}
//	
//	@GetMapping("/getStudent/{Id}")
//	public Optional<Student> getStudent(@PathVariable Long Id){
//		return studentService.getStudent(Id);
//	}
//	public void addSection(long sectionId) {
//		
//	}

	@GetMapping(value = "/sections/{studentId}")
	public List<Section> getSections(@PathVariable long studentId) {
		return sectionService.getSectionsByStudentId(studentId);
	}
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getStudent/{Id}")
	public Student getStudent(@PathVariable Long Id){
		return studentService.getStudent(Id);
	}
}
