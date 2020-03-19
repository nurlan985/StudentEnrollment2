package edu.miu.cs.cs544.group1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.service.EntryService;
import edu.miu.cs.cs544.group1.service.StudentService;

@RestController
@RequestMapping("/entries")
public class EntryController {
	@Autowired
	private EntryService entryService;
	@Autowired
	private StudentService studentService;
	
	
	//a method to display all entries.
	@GetMapping("/")
	public List<Entry> getAllEntry() {
		
		return entryService.getAllEntry();
		
	}
	
	//a method to display a specific entry.
	@GetMapping("/{entryId}")
	public Entry getEntry(@PathVariable long entryId) throws NoSuchResouceException{
		
		Optional<Entry> entry = entryService.getEntry(entryId);
        
        if(entry.isPresent()) {
            return entry.get();
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", entryId);
        }
	}
	
	//a method to to insert new entry
	@PostMapping(value="/")
	public Entry addEntry(@RequestBody Entry entry) {
		return entryService.addEntry(entry);
	}
	
	//a method to update existing entry.
	@PutMapping(value="/{entryId}")
	public Entry updateEntry(@PathVariable long entryId, @RequestBody Entry entry) {
		Optional<Entry> e = entryService.getEntry(entryId);
		
		if(e.isPresent()) {
            return entryService.updateEntry(entryId, entry);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", entryId);
        }
	}
	
	//a method to delete a single entry.
	@DeleteMapping(value="/{entryId}")
	public Long deleteEntry(@PathVariable long entryId) {
		
		Optional<Entry> entry = entryService.getEntry(entryId);
		
		if(entry.isPresent()) {
			return entryService.deleteEntry(entryId);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", entryId);
        }
	}
	//a method returning list of students in an entry
	@GetMapping(value="/students/{entryId}")
	public List<Student> getStudent(@PathVariable long entryId) {
		return studentService.getStudentsByEntryId(entryId);
	}	
	
}
