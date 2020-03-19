package edu.miu.cs.cs544.group1.domain;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Student;


@Entity
@NamedQuery(name = "Section.findAllSectionsByCourseId", query = "select s FROM Section s  WHERE s.offering.course.id = ?1")
@NamedQuery(name = "Section.findAllSectionsByBlockId", query = "select s FROM Section s  WHERE s.offering.block.id = ?1")
@NamedQuery(name = "Section.findAllByOfferingId", query = "select s FROM Section s  WHERE s.offering.id = ?1")
@NamedQuery(name = "Section.findAllByFacultyId", query = "select s FROM Section s  WHERE s.faculty.id = ?1")
@NamedQuery(name = "Section.findAllByStudentId", query = "select s FROM Student stu JOIN stu.sections s WHERE stu.id = ?1")
@NamedQuery(name = "Section.findAllStudentsByFacultyIdAndSectionId", query = "select s FROM Section sec JOIN sec.students s WHERE sec.faculty.id = ?1 and sec.id = ?2")
@NamedQuery(name = "Section.findAllStudentsBySectionId", query = "SELECT s FROM Section sec JOIN sec.students s WHERE sec.id = ?1")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="sectionDesc")
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "facultyId", nullable = true)
	private Faculty faculty;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offeringId", nullable = true)
	//@JsonIgnore
	private Offering offering;
	
	@ManyToMany(mappedBy="sections")
	private List<Student> students;
	
	
	public Section() {
		super();
	}

	public Section(String name, Faculty faculty, Offering offering) {
		super();
		this.name = name;
		this.faculty = faculty;
		this.offering = offering;
	}

	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public Offering getOffering() {
		return offering;
	}


	public void setOffering(Offering offering) {
		this.offering = offering;
	}


	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}


}
