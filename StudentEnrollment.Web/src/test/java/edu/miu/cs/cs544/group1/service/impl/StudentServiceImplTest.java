package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest {

	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepo;
	
	@Test
	public void addStudentTest() {
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLESTUDENT);
		Student student = new Student("James", "ij@abc.xyz", "12345", roles, "610569");
		
		when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, studentService.addStudent(student));
	}
	
	@Test
	public void deleteStudentTest() {
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLESTUDENT);
		Student student = new Student("James", "ij@abc.xyz", "12345", roles, "610569");
		
		studentService.deleteStudent(student);
		verify(studentRepo, times(1)).delete(student);
		
	} 
}
