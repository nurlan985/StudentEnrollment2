package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.repository.SectionRepository;
import edu.miu.cs.cs544.group1.service.SectionService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
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
	public Section getSection(Long Id) {
		
		
		return sectionRepository.findById(Id).get();
	}

	@Override
	public Section updateSection(Long Id, Section section) throws Exception {
		try {
			Section updatableSection= getSection(Id);
			if(updatableSection !=null) {
			section.setId(Id);
			sectionRepository.save(section);
			}
	}catch (Exception ex) {
		throw  new Exception(ex.getMessage());
	}
		return getSection(Id);
	}

	@Override
	public Section deleteSection(Long id) {
		Section SectionToDelete=sectionRepository.getOne(id);
		sectionRepository.deleteById(id);
		return SectionToDelete;
	}

	@Override
	public List<Section> getSectionsByCourseId(long courseId) {
		return sectionRepository.findAllSectionsByCourseId(courseId);
	}

	@Override
	public List<Section> getSectionsByBlockId(long blockId) {
		return sectionRepository.findAllSectionsByBlockId(blockId);
	}

	@Override
	public List<Section> getSectionsByOfferingId(long offeringId) {
		return sectionRepository.findAllByOfferingId(offeringId);
	}

	@Override
	public List<Section> getSectionsByFacultyId(long facultyId) {
		return sectionRepository.findAllByFacultyId(facultyId);
	}

	@Override
	public List<Section> getSectionsByStudentId(long studentId) {
		return sectionRepository.findAllByStudentId(studentId);
	}

}
