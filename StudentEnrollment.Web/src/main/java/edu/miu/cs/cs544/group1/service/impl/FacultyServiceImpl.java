package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;
import edu.miu.cs.cs544.group1.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	FacultyRepository facultyRepository;
	@Override
	public Faculty createFaculty(Faculty faculty) {
		
		return facultyRepository.saveAndFlush(faculty);
	}

	@Override
	public List<Faculty> getFaculties() {
		
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFaculty(Long Id) {
		
		return facultyRepository.getOne(Id);
	}

	@Override
	public Faculty updateFaculty(Long Id, Faculty fuculty) throws Exception {
		try {
		Faculty updatableFaculty=getFaculty(Id);
		if(updatableFaculty !=null) {
			fuculty.setId(Id);
			
		}
		}catch (Exception e) {
			 throw new Exception(e);
		}
		return facultyRepository.saveAndFlush(fuculty);
		
	}

	@Override
	public Faculty deleteFaculty(Long id) throws Exception {
		Faculty faculty=null;
		try {
			faculty= getFaculty(id);
		if(faculty !=null) {
			facultyRepository.deleteById(id);
			
		}
		}catch (Exception e) {
			throw new Exception(e);
		}
		return faculty;
	}

}
