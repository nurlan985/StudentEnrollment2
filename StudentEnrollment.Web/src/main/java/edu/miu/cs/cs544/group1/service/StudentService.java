package edu.miu.cs.cs544.group1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface StudentService {
	
	public Student addStudent(Student students);

	public List<Student> getStudents();

	public Student getStudent(long studentId) throws NoSuchResouceException;

	public Student updateStudent(long studentId, Student students) throws NoSuchResouceException;

	public ResponseEntity<Void> deleteStudent(long studentId) throws NoSuchResouceException;

	public List<Student> getStudentsByFacultyIdAndSectionId(long facultyId, long sectionId);

	public List<Student> getStudentsBySectionId(long sectionId);
	

	public boolean makeEnrollment(long sectionId, Student student);

	public List<Student> getStudentsByEntryId(long entryId);


}
