package edu.miu.cs.cs544.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.service.SectionService;
import edu.miu.cs.cs544.service.impl.SectionServiceImpl;


@RestController
@EnableAutoConfiguration
public class SectionController {
	@Autowired
	SectionServiceImpl sectionservice;
	
	@GetMapping("/sections")
	public List<Section> getSections(){
		
		return sectionservice.getSections();
	}
	
	@PostMapping("/addSection")
	public Section saveSection(Section section) {
		
		return sectionservice.createSection(section);
	}
	
	@GetMapping("section/{Id}")
	public Optional<Section> getSection(@PathVariable Long Id) {
		
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
