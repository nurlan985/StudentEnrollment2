package edu.miu.cs.cs544.group1.domain.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.domain.Section;

@Entity
@NamedQuery(name = "Student.findOneByEmail", query = "SELECT s FROM Student s WHERE s.email = ?1")
@NamedQuery(name = "Student.findAllStudentsByEntryId", query = "SELECT s FROM Student s WHERE s.entry.id = ?1")
@NamedQuery(name = "Student.findAllByFacultyIdAndSectionId", query = "select s FROM Student s JOIN s.sections sec WHERE sec.faculty.id = ?1 and sec.id = ?2")
@NamedQuery(name = "Student.findAllBySectionId", query = "SELECT s FROM Student s JOIN s.sections sec WHERE sec.id = ?1")
public class Student extends Person {
	private String studentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Entry entry;
	
	@ManyToOne
	private Address homeAddress;
	
	@ManyToOne
	private Address mailingAddress;
	
	@Size(max = 3)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Enrolment", joinColumns = {@JoinColumn(name="studentId")},
	inverseJoinColumns = {@JoinColumn(name="sectionId")})
	private List<Section> sections = new ArrayList();
	

	public Student() { }

	public Student(String name, String email, String password, Set<Role> roles, String studentId) {
		super(name, email, password, roles);
		this.studentId = studentId;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public List<Section> getSections() {
		return sections;
	}
	
	public void clearSections() {
		sections.clear();
	}
	
	public void addSection(Section section) {
		if(this.sections.size()<4) {
			this.sections.add(section);
		}else {
			throw new IndexOutOfBoundsException("Fail: sections can't be more then 4!");
		}
	}

	
	
}
