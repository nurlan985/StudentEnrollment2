package edu.miu.cs.cs544.group1.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs544.group1.domain.security.Student;

public interface StudentService {
	public Student addStudent(Student student);
	public Optional<Student> getStudent(long id);
	public Student deleteStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student> getAllStudents();
}
