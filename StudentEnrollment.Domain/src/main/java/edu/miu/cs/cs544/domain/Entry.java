package edu.miu.cs.cs544.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Entity_Table")
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Entry_Name")
	private String name;
	@Column(name="enrollment_start_date")
	Date enrollmentStartDate;
	@Column(name="enrollment_end_date")
	Date enrollmentEndDate;
	
	
	public Entry() {

	}
	public Entry(String name, Date enrollmentStartDate, Date enrollmentEndDate) {
		super();
		this.name = name;
		this.enrollmentStartDate = enrollmentStartDate;
		this.enrollmentEndDate = enrollmentEndDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEnrollmentStartDate() {
		return enrollmentStartDate;
	}
	public void setEnrollmentStartDate(Date enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}
	public Date getEnrollmentEndDate() {
		return enrollmentEndDate;
	}
	public void setEnrollmentEndDate(Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}
	
	

}

