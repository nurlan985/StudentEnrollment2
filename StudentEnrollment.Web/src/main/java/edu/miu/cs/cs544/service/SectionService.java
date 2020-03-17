package edu.miu.cs.cs544.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.domain.Section;

public interface SectionService {
	public Section createSection(Section section);
	public List<Section> getSections();
	public Optional<Section>  getSection(Long Id);
	public Section updateSection(Long Id, Section section);
	public Section deleteSection(Section section);
		
			
	

}
