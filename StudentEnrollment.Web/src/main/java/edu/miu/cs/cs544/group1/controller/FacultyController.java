package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.service.FacultyService;
import edu.miu.cs.cs544.group1.service.SectionService;
import edu.miu.cs.cs544.group1.service.StudentService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	@Autowired
	SectionService sectionService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public List<Faculty> getFaculties(){
		
		return facultyService.getFaculties();
	}
	
	@PostMapping("/")
	public Faculty save(Faculty faculty) {
		
		return facultyService.createFaculty(faculty);
	}
	
	
	
	@GetMapping("/{Id}")
	public Faculty getFaculty(@PathVariable Long Id) {

		
		return facultyService.getFaculty(Id);
	}
	

	@PutMapping("/{id}")
	public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty){
		Faculty updatedFaculty=null;
		try {
			updatedFaculty= facultyService.updateFaculty(id, faculty);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedFaculty;

		
	}

	@DeleteMapping("/{id}")
	public Faculty deleteFaculty(@PathVariable Long id) throws Exception {
		return facultyService.deleteFaculty(id);
	}

	@GetMapping(value = "/sections/{blockId}")
	public List<Section> getSections(long facultyId) {
		return sectionService.getSectionsByFacultyId(facultyId);
	}
	
	@GetMapping(value = "/students/{facultyId}/{sectionId}")
	public List<Student> getStudents(@PathVariable long facultyId, @PathVariable long sectionId) {
		return studentService.getStudentsByFacultyIdAndSectionId(facultyId, sectionId);
	}

}
