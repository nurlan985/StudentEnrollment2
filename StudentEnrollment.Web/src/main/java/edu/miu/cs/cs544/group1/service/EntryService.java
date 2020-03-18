package edu.miu.cs.cs544.group1.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.group1.domain.Entry;


public interface EntryService {
	public List<Entry> getAllEntry();
	public Optional<Entry> getEntry(Long id);
	public Entry addEntry(Entry entry);
	public Entry updateEntry(Long id, Entry entry) ;
	public Long deleteEntry(Long id);
}
