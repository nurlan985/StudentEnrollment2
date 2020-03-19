package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
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
	
	Student s1;
	Student s2;
	List<Student> students = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception{
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLESTUDENT);
		MockitoAnnotations.initMocks(this);
		s1 = new Student("James", "ij@abc.xyz", "12345", roles, "610569");
		s2 = new Student("John", "jd@abc.xyz", "12345", roles, "788569");
		students.add(s1);
		students.add(s2);
	}
	
	@Test
	public void addStudentTest() {
		
		when(studentRepo.save(s1)).thenReturn(s1);
		assertEquals(s1, studentService.addStudent(s1));
	}
	
	@Test
	public void deleteStudentTest() {
<<<<<<< Updated upstream
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLESTUDENT);
		Student student = new Student("James", "ij@abc.xyz", "12345", roles, "610569");
		
		studentService.deleteStudent(student.getId());
		verify(studentRepo, times(1)).delete(student);
		
		studentService.deleteStudent(s1.getId());
=======
		
		studentService.deleteStudent(s1);
>>>>>>> Stashed changes
		verify(studentRepo, times(1)).delete(s1);
	} 
	
	@Test
	public void getAllStudentsTest() {
		
		when(studentRepo.findAll()).thenReturn(students);
<<<<<<< Updated upstream
		assertEquals(2, studentService.getStudents().size());
=======
		assertEquals(2, studentService.getAllStudents().size());
>>>>>>> Stashed changes
	}
}
