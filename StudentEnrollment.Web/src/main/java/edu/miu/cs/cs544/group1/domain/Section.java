package edu.miu.cs.cs544.group1.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.miu.cs.cs544.group1.domain.security.Faculty;


@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sectionId;

	@ManyToOne
	@JoinColumn(name = "facultyId", nullable = false)
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name = "offeringId", nullable = false)

	private Offering offering;
	
	
	public Section() {
		super();
	}


	public Section(Faculty faculty, Offering offering) {
		super();
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


	public Long getSectionId() {
		return sectionId;
	}
	
	

}
