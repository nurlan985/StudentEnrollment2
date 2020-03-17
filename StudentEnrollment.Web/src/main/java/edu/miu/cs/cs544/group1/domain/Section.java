package edu.miu.cs.cs544.group1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Section {
	@Id
	@GeneratedValue
	private long sectionId;
	
	
	
	@ManyToOne
	@Column(name="facultId")
	
	private Faculty faculty;
	
	@ManyToOne
	@Column(name="offeringId")
	private Offering offering;
	
	
	public Section() {
		super();
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
