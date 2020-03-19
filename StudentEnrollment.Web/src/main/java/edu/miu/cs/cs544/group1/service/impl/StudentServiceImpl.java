package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.SectionRepository;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.StudentService;

@Service
public class StudentServiceImpl implements  StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SectionRepository sectionRepository;

	@Override
	public Student addStudent(Student students) {
		
		return studentRepository.save(students);
	}

	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(long studentId) throws NoSuchResouceException {
		Student student = studentRepository.findById(studentId).orElseThrow(()-> new  NoSuchResouceException("No Student found  with", studentId));

		return student;
	}

	@Override
	public Student updateStudent(long studentId, Student students_update) throws NoSuchResouceException {
		
		Student student = studentRepository.findById(studentId).orElseThrow(()-> new  NoSuchResouceException("No Student found  with", studentId));

		student.setEmail(students_update.getEmail());
		student.setEntry(students_update.getEntry());
		student.setHomeAddress(students_update.getHomeAddress());
		student.setMailingAddress(students_update.getMailingAddress());
		student.setName(students_update.getName());
		student.setPassword(students_update.getPassword());
		
		Student updated_student = studentRepository.save(student);
		
		return updated_student;
		
		
	}

	@Override
	public ResponseEntity<Void> deleteStudent(long studentId) throws NoSuchResouceException {
		Student student= studentRepository.findById(studentId)
				.orElseThrow(() -> new NoSuchResouceException("No Course found  with", studentId));

		studentRepository.delete(student);

		return ResponseEntity.noContent().build();
	}

	@Override
	public List<Student> getStudentsByFacultyIdAndSectionId(long facultyId, long sectionId) {
		return sectionRepository.findAllStudentsByFacultyIdAndSectionId(facultyId, sectionId);
	}

	@Override
	public List<Student> getStudentsBySectionId(long sectionId) {
		return sectionRepository.findAllStudentsBySectionId(sectionId);
	}

}
