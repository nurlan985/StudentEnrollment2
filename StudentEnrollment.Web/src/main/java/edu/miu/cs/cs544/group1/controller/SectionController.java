package edu.miu.cs.cs544.group1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> new version
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.service.SectionService;


@RestController
<<<<<<< HEAD
@EnableAutoConfiguration
@SessionAttributes({"currentUser"})
<<<<<<< HEAD
@RequestMapping("/sections")
=======
=======

>>>>>>> new version
>>>>>>> new version
public class SectionController {
	@Autowired
	SectionService sectionservice;
	
	@GetMapping("/")
	public List<Section> getSections(){
		
		return sectionservice.getSections();
	}
	
<<<<<<< HEAD
	@PostMapping("/add")
	public Section saveSection(Section section) {
		
		return sectionservice.createSection(section);
	}
	
	@GetMapping("/{Id}")
	public Optional<Section> getSection(@PathVariable Long Id) {
=======
	@PostMapping("/addSection")
	public Section saveSection(@RequestBody Section section) {
		//section.setName(section.getName());
		System.out.println(section.getName());
		return sectionservice.createSection(section);
	}
	
	@GetMapping("section/{Id}")
	public Section getSection(@PathVariable Long Id) {
>>>>>>> new version
		
		return sectionservice.getSection(Id);
	}
	
<<<<<<< HEAD
	@PatchMapping("/update")
	public Section updateSevtion(Section section) {
		Long id= section.getSectionId();
=======
	@PutMapping("/updateSection/{id}")
	public Section updateSevtion(@PathVariable Long id, @RequestBody Section section){
		Section updatedSection=null;
		try {
			updatedSection= sectionservice.updateSection(id, section);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedSection;
>>>>>>> new version
		
	}
	
	
<<<<<<< HEAD
	@DeleteMapping("/delete")
	public Section deleteSection(Section section) {
=======
	@DeleteMapping("/deleteSection/{id}")
	public Section deleteSection(@PathVariable Long id) {
>>>>>>> new version
		
		return sectionservice.deleteSection(id);
	}
	
	
}
