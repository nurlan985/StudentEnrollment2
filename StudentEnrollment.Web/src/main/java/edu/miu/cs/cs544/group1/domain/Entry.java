package edu.miu.cs.cs544.group1.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Entry {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date enrollmentStartDate;
	@Temporal(TemporalType.DATE)
	private Date enrollmentEndDate;
	
	public Entry(String name, Date enrollmentStartDate, Date enrollmentEndDate) {
		super();
		this.name = name;
		this.enrollmentStartDate = enrollmentStartDate;
		this.enrollmentEndDate = enrollmentEndDate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}

