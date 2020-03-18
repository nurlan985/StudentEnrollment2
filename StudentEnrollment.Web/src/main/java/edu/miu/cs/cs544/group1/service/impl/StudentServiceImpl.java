package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.StudentService;

@Service
public class StudentServiceImpl implements  StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStduent(Student students) {
		
		return studentRepository.save(students);
	}

	@Override
	public List<Student> getStudents() {
		
		return  null;
	}

	@Override
	public Student getCourse(long studentId) throws NoSuchResouceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(long studentId, Student students) throws NoSuchResouceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteStudent(long studentId) throws NoSuchResouceException {
		// TODO Auto-generated method stub
		return null;
	}

}
