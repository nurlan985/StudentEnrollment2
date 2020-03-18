package edu.miu.cs.cs544.group1.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;
import edu.miu.cs.cs544.group1.repository.PersonRepository;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
		
	@PostConstruct
	public void init() {
		facultyRepository.save(
	    		  new Faculty(
	    				  "Nurlan", 
	    				  "nurlan985@gmail.com", 
	    				  "123", 
	    				  new HashSet<Role>(Arrays.asList(Role.ROLEFACULTY)), 
	    				  "Professor"));
		
		studentRepository.save(
				new Student(
						"Julius", 
						"jjjingo@miu.edu",
						"12345",
						new HashSet<Role> (Arrays.asList(Role.ROLESTUDENT)),
						"610576"));
										
	}
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentes() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(long studentId) throws NoSuchResouceException {
		return studentRepository.findById(studentId);
	}

	@Override
	public Student updateStudent(long studentId, Student student_update) {

		Student student = studentRepository.findById(studentId).orElseThrow(() -> new  NoSuchResouceException("No Student found  with" , studentId));
		
		student.setStudentId(student_update.getStudentId());
		student.setName(student_update.getName());
		student.setEmail(student_update.getEmail());
		
		return studentRepository.save(student);
		
	}

	@Override
	public Faculty addStudent(Faculty faculty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> getFaculties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Faculty> getFaculty(long facultyId) throws NoSuchResouceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty updateFaculty(long facultyId, Faculty faculty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkLogin(String email, String password) {
		List<Person> person = personRepository.findByEmailAndPassword(email, password);
		return(person.size() == 1);		
	}

	@Override
	public List<Person> getPeople() {
		return personRepository.findAll();
	}

}
