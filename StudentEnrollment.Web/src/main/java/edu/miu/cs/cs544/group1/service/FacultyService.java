package edu.miu.cs.cs544.group1.service;

import java.util.List;

import edu.miu.cs.cs544.group1.domain.security.Faculty;



public interface FacultyService {
	public Faculty createFaculty(Faculty faculty);
	public List<Faculty> getFaculties();
	public Faculty  getFaculty(Long Id);
	public Faculty updateFaculty(Long Id, Faculty fuculty) throws Exception;
	public Faculty deleteFaculty(Long id) throws Exception;
		
}
