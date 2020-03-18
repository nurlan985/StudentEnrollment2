package edu.miu.cs.cs544.group1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.repository.EntryRepository;
import edu.miu.cs.cs544.group1.service.EntryService;

@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	EntryRepository entryRepository;
	
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
	public Long deleteEntry(Long id) {
		entryRepository.deleteById(id);
		return id;
	}
}
