package edu.miu.cs.cs544.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.service.EntryService;

@RestController
public class EntryController {
	@Autowired
	private EntryService entryService;
	
	//a method to display all entries.
	@RequestMapping("/entries")
	public List<Entry> getAllEntry(){
		return entryService.getAllEntry();
	}
	
	//a method to display a specific entry.
	@RequestMapping("/entries/{id}")
	public Optional<Entry> getEntry(@PathVariable Long id) {
		return entryService.getEntry(id);
	}
	
	//a method to to insert new entry
	@RequestMapping(method = RequestMethod.POST, value="/entries")
	public Entry addEntry(@RequestBody Entry entry) {
		return entryService.addEntry(entry);
	}
	
	//a method to update existing entry.
	@RequestMapping(method = RequestMethod.PUT, value="/entries/{id}")
	public Entry updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
		return entryService.updateEntry(id, entry);
	}
	
	//a method to delete a single entry.
	@RequestMapping(method = RequestMethod.DELETE, value="/entries/{id}")
	public Long deleteEntry(@PathVariable Long id) {
		return entryService.deleteEntry(id);
	}
}
