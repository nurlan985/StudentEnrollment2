package edu.miu.cs.cs544.group1.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.group1.domain.Section;

public interface SectionService {
	public Section createSection(Section section);
	public List<Section> getSections();
	public Section  getSection(Long Id);
	public Section updateSection(Long Id, Section section) throws Exception;
	public Section deleteSection(Long id);
		
			
	

}
