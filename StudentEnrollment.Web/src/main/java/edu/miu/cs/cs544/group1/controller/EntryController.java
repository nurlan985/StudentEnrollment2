package edu.miu.cs.cs544.group1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.service.EntryService;


@RestController
public class EntryController {
	@Autowired
	private EntryService entryService;
	
	
	//a method to display all entries.
	@RequestMapping("/getallentry")
	public List<Entry> getAllEntry() {
		
		return entryService.getAllEntry();
		
	}
	
	//a method to display a specific entry.
	@RequestMapping("/getentry/{id}")
	public Entry getEntry(@PathVariable Long id) throws NoSuchResouceException{
		
		Optional<Entry> entry = entryService.getEntry(id);
        
        if(entry.isPresent()) {
            return entry.get();
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
	}
	
	//a method to to insert new entry
	@RequestMapping(method = RequestMethod.POST, value="/addentry")
	public Entry addEntry(@RequestBody Entry entry) {
		return entryService.addEntry(entry);
	}
	
	//a method to update existing entry.
	@RequestMapping(method = RequestMethod.PUT, value="/updatentry/{id}")
	public Entry updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
		Optional<Entry> e = entryService.getEntry(id);
		
		if(e.isPresent()) {
            return entryService.updateEntry(id, entry);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
		
	}
	
	//a method to delete a single entry.
	@RequestMapping(method = RequestMethod.DELETE, value="/deletentry/{id}")
	public Long deleteEntry(@PathVariable Long id) {
		
		Optional<Entry> entry = entryService.getEntry(id);
		
		if(entry.isPresent()) {
			return entryService.deleteEntry(id);
        } else {
            throw new NoSuchResouceException("No Entry exists for given id: ", id);
        }
		
		
	}
}
