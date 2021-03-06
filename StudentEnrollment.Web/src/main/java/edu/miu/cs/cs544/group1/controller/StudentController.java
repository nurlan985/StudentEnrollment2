package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.service.SectionService;
import edu.miu.cs.cs544.group1.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController {

	@Autowired
	private SectionService sectionService;

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/")
	public Student save(Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/{Id}")
	public Student getStudent(@PathVariable long Id) {
		return studentService.getStudent(Id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {

		return studentService.updateStudent(id, student);
	}
	
	@PutMapping("/{studentId}/updateEnrollments")
	public String updateStudentEnrollments(@PathVariable long studentId, @RequestBody long[] sectionIds) {
		return studentService.updateStudentEnrolment(studentId, sectionIds);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/enrollment/{sectionId}")
	public String makeEnroll(@PathVariable long sectionId) {
		Student currentStudent = getCurrentStudent();
		if (currentStudent != null) {
			try {
				return studentService.makeEnrollment(sectionId, currentStudent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Authontication fail";
	}

	@GetMapping(value = "/{studentId}/sections")
	public List<Section> getSections(@PathVariable long studentId) {
		return sectionService.getSectionsByStudentId(studentId);
	}

}
