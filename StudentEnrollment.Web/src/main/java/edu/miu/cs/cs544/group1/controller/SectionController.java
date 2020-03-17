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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.service.SectionService;


@RestController

public class SectionController {
	@Autowired
	SectionService sectionservice;
	
	@GetMapping("/sections")
	public List<Section> getSections(){
		
		return sectionservice.getSections();
	}
	
	@PostMapping("/addSection")
	public Section saveSection(@RequestBody Section section) {
		//section.setName(section.getName());
		System.out.println(section.getName());
		return sectionservice.createSection(section);
	}
	
	@GetMapping("section/{Id}")
	public Section getSection(@PathVariable Long Id) {
		
		return sectionservice.getSection(Id);
	}
	
	@PutMapping("/updateSection/{id}")
	public Section updateSevtion(@PathVariable Long id, @RequestBody Section section){
		Section updatedSection=null;
		try {
			updatedSection= sectionservice.updateSection(id, section);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedSection;
		
	}
	
	
	@DeleteMapping("/deleteSection/{id}")
	public Section deleteSection(@PathVariable Long id) {
		
		return sectionservice.deleteSection(id);
	}
	
	
}
