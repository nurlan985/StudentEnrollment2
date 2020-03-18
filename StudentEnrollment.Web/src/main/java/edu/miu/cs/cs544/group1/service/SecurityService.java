package edu.miu.cs.cs544.group1.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface SecurityService {
	public Student addStudent(Student student);
	public List<Student> getStudentes();
	public Optional<Student> getStudent(long studentId) throws NoSuchResouceException;
	public Student updateStudent(long studentId,  Student student);

	public Faculty addStudent(Faculty faculty);
	public List<Faculty> getFaculties();
	public Optional<Faculty> getFaculty(long facultyId) throws NoSuchResouceException;
	public Faculty updateFaculty(long facultyId,  Faculty faculty);

	public boolean checkLogin(String email, String password);
	public List<Person> getPeople();

}
