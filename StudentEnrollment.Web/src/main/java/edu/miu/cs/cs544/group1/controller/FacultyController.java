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
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;
import edu.miu.cs.cs544.group1.service.FacultyService;

@RestController
@RequestMapping("/faculty")
@SessionAttributes({"currentUser"})
public class FacultyController {
	@Autowired
	FacultyService FacultyService;
	@GetMapping("/")
	public List<Faculty> getFaculties(){
		
		return FacultyService.getFaculties();
	}
	
	@PostMapping("/add")
	public Faculty save(Faculty faculty) {
		
		return FacultyService.createFaculty(faculty);
	}
	
	
	
	@GetMapping("/{Id}")
	public Faculty getSection(@PathVariable Long Id) {

		
		return FacultyService.getFaculty(Id);
	}
	

	@PutMapping("/update/{id}")
	public Faculty updateSevtion(@PathVariable Long id, @RequestBody Faculty faculty){
		Faculty updatedFaculty=null;
		try {
			updatedFaculty= FacultyService.updateFaculty(id, faculty);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedFaculty;

		
	}
		

	@DeleteMapping("/delete/{id}")
	public Faculty deleteSection(@PathVariable Long id) throws Exception {

		
		return FacultyService.deleteFaculty(id);
	}
	

}
