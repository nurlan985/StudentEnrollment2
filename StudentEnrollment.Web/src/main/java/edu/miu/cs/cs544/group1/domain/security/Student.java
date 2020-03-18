package edu.miu.cs.cs544.group1.domain.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.domain.Section;

@Entity
@NamedQuery(name = "Student.findOneByEmail", query = "SELECT s FROM Student s WHERE s.email = ?1")
public class Student extends Person {
	private String studentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Entry entry;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Address homeAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Address mailingAddress;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Enrolment", joinColumns = {@JoinColumn(name="studentId")},
	inverseJoinColumns = {@JoinColumn(name="sectionId")})
	private List<Section> sections = new ArrayList();
	

	public Student() { }

	public Student(String name, String email, String password, Set<Role> roles, String studentId) {
		super(name, email, password, roles);
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void addSection(Section section) {
		sections.add(section);
	}
	
}
