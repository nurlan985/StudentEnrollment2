package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import edu.miu.cs.cs544.group1.domain.Section;
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

	@Override
	public List<Student> getStudentsByFacultyIdAndSectionId(long facultyId, long sectionId) {
		return sectionRepository.findAllStudentsByFacultyIdAndSectionId(facultyId, sectionId);
	}

	@Override
	public List<Student> getStudentsBySectionId(long sectionId) {
		return sectionRepository.findAllStudentsBySectionId(sectionId);
	}

	@Override
	public boolean makeEnrollment(long sectionId, Student stu) {
		Section section = sectionRepository.findById(sectionId).orElse(null);
		Student student = studentRepository.findById(stu.getId()).orElse(null);
		if(section != null && student != null) {
			student.addSection(section);
			studentRepository.save(student);
		}
		return false;
	}

}
