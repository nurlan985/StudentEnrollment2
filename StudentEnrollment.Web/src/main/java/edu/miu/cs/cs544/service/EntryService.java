package edu.miu.cs.cs544.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.domain.Entry;

public interface EntryService {
	public List<Entry> getAllEntry();
	public Optional<Entry> getEntry(Long id);
	public Entry addEntry(Entry entry);
	public Entry updateEntry(Long id, Entry entry) ;
	public Long deletEntry(Long id);
}
