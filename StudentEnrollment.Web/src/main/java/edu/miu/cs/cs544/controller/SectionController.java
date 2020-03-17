package edu.miu.cs.cs544.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.service.SectionService;


@RestController
public class SectionController {
	SectionService sectionservice;
	
	@GetMapping("/sections")
	public List<Section> getSections(){
		
		
		return sectionservice.getSections();
	}
	
	@PostMapping("/addSection")
	public Section saveSection(Section section) {
		
		return sectionservice.createSection(section);
	}
	
	@GetMapping("section/{Id}")
	public Optional<Section> getSection(Long Id) {
		
		
		return sectionservice.getSection(Id);
	}
	
	@PatchMapping("/updateSection")
	public Section updateSevtion(Section section) {
		Long id= section.getSectionId();
		
		return sectionservice.updateSection(id, section);
	}
	
	
	@DeleteMapping("/deleteSection")
	public Section deleteSection(Section section) {
		
		return sectionservice.deleteSection(section);
	}
	
	
}
