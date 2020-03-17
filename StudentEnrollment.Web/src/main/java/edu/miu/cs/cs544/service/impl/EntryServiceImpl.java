package edu.miu.cs.cs544.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.repository.EntryRepository;
import edu.miu.cs.cs544.service.EntryService;

public class EntryServiceImpl implements EntryService{
	
	@Autowired
	EntryRepository entryRepository;
	
	private List<Entry> entries;
	
	@Override
	public List<Entry> getAllEntry(){
		List<Entry> entry = new ArrayList<>();
		entryRepository.findAll()
		.forEach(entry::add);
		return entry;
	}
	@Override
	public Optional<Entry> getEntry(Long id) {
		return entryRepository.findById(id);
	}
	@Override
	public Entry addEntry(Entry entry) {
		return entryRepository.save(entry);
	}
	@Override
	public Entry updateEntry(Long id, Entry entry) {
		entryRepository.save(entry);
		return entry;
	}
	@Override
	public Long deletEntry(Long id) {
		entryRepository.deleteById(id);
		return id;
	}
}
