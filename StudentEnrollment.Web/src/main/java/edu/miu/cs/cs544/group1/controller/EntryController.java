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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.service.EntryService;


@RestController
@RequestMapping("/entries")
public class EntryController {
	@Autowired
	private EntryService entryService;
	
	
	//a method to display all entries.
	@GetMapping("/")
	public List<Entry> getAllEntry() {
		
		return entryService.getAllEntry();
		
	}
	
	//a method to display a specific entry.
	@GetMapping("/{id}")
	public Entry getEntry(@PathVariable Long id) throws NoSuchResouceException{
		
		Optional<Entry> entry = entryService.getEntry(id);
        
        if(entry.isPresent()) {
            return entry.get();
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
	}
	
	//a method to to insert new entry
	@PostMapping(value="/add")
	public Entry addEntry(@RequestBody Entry entry) {
		return entryService.addEntry(entry);
	}
	
	//a method to update existing entry.
	@PutMapping(value="/update/{id}")
	public Entry updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
		Optional<Entry> e = entryService.getEntry(id);
		
		if(e.isPresent()) {
            return entryService.updateEntry(id, entry);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
		
	}
	
	//a method to delete a single entry.
	@DeleteMapping(value="/delete/{id}")
	public Long deleteEntry(@PathVariable Long id) {
		
		Optional<Entry> entry = entryService.getEntry(id);
		
		if(entry.isPresent()) {
			return entryService.deleteEntry(id);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
		
		
	}
}
