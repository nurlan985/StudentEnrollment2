package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student deleteStudent(Student student) {
		studentRepository.delete(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
