package edu.miu.cs.cs544;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@Mock
	private StudentRepository studentRepo;
	
	@Test
	void addStudentTest() {
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLE_STUDENT);
		Student student = new Student("James", "ij@abc.xyz", "12345", roles, "610569");
		
		when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, studentService.addStudent(student));
	}
	
}
