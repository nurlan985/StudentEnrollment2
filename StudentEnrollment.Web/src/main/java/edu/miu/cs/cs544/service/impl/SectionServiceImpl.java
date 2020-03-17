package edu.miu.cs.cs544.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.repository.SectionRepository;
import edu.miu.cs.cs544.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	SectionRepository sectionRepository;

	@Override
	public Section createSection(Section section) {
		
		return sectionRepository.save(section);
	}

	@Override
	public List<Section> getSections() {
		
		return sectionRepository.findAll() ;
	}

	@Override
	public Optional<Section> getSection(Long Id) {
		
		return sectionRepository.findById(Id);
	}

	@Override
	public Section updateSection(Long Id, Section section) {
		
		return null;
	}

	@Override
	public Section deleteSection(Section section) {
		sectionRepository.delete(section);
		return section;
	}

}
