package edu.miu.cs.cs544.group1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.miu.cs.cs544.group1.domain.security.Faculty;


@Entity
public class Section{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sectionId;
	
	@Column(name="sectionDesc")
	private String name;

	@ManyToOne
	@JoinColumn(name = "facultyId", nullable = true)
	//@JsonIgnore
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name = "offeringId", nullable = true)
	//@JsonIgnore
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


	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	
	
	
	
	

}
