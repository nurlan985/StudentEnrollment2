package edu.miu.cs.cs544.group1.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.Course;
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
//		student.setPassword(students_update.getPassword());
//		student.clearSections();
//		for(Section sec: students_update.getSections()) {
//			sec = sectionRepository.findById(sec.getId()).orElse(null);
//			if(sec != null) {
//				student.addSection(sec);
//			}
//		}
		
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
		return studentRepository.findAllByFacultyIdAndSectionId(facultyId, sectionId);
	}

	@Override
	public List<Student> getStudentsBySectionId(long sectionId) {
		return studentRepository.findAllBySectionId(sectionId);
	}

	@Override
	public String makeEnrollment(long sectionId, Student stu) {
		Section section = sectionRepository.findById(sectionId).orElse(null);
		Student student = studentRepository.findById(stu.getId()).orElse(null);
		if(section != null && student != null) {
			if(student.getSections().size() < 4) {
				Date now = new Date();
				if(
						now.compareTo(student.getEntry().getEnrollmentStartDate()) >= 0 &&
						now.compareTo(student.getEntry().getEnrollmentEndDate()) <= 0
					) {
					student.addSection(section);
					studentRepository.save(student);
					return "Success";
				}else {
					return "Fail: You cannot enroll at this time";
				}
			}else {
				return "Fail: sections can't be more then 4!";
			}
		}
		return "Fail";
	}

	public List<Student> getStudentsByEntryId(long entryId) {
		return studentRepository.findAllStudentsByEntryId(entryId);
	}

	@Override
	public String updateStudentEnrolment(long studentId, long[] sectionIds) {

		Student student = studentRepository.findById(studentId).orElseThrow(()-> new  NoSuchResouceException("No Student found  with", studentId));

		student.clearSections();
		for(long secId: sectionIds) {
			Section sec = sectionRepository.findById(secId).orElse(null);
			if(sec != null) {
				student.addSection(sec);
			}
		}
		
		Student updated_student = studentRepository.save(student);
		
		return "Success";
	}

}
