package edu.miu.cs.cs544.group1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.service.SectionService;
import edu.miu.cs.cs544.group1.service.StudentService;


@RestController
@RequestMapping("/sections")
public class SectionController {
	@Autowired
	SectionService sectionservice;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public List<Section> getSections(){
		return sectionservice.getSections();
	}
	
	@PostMapping("/")
	public Section addSection(@RequestBody Section section) {
		//section.setName(section.getName());
		System.out.println(section.getName());
		return sectionservice.createSection(section);
	}
	
	@GetMapping("/{id}")
	public Section getSection(@PathVariable Long id) {
		
		return sectionservice.getSection(id);
	}
	

	@PutMapping("/{id}")
	public Section updateSection(@PathVariable Long id, @RequestBody Section section){
		Section updatedSection=null;
		try {
			updatedSection= sectionservice.updateSection(id, section);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedSection;		
	}
		

	@DeleteMapping("/{id}")
	public Section deleteSection(@PathVariable Long id) {
		return sectionservice.deleteSection(id);
	}
	

	@GetMapping(value = "/students/{sectionId}")
	public List<Student> getStudents(@PathVariable long sectionId) {
		return studentService.getStudentsBySectionId(sectionId);
	}
	
}
