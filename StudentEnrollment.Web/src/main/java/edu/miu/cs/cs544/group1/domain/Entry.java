package edu.miu.cs.cs544.group1.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Entry {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message = "this field is required")
	private String name;
	
	@NotNull(message = "this field is required")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@NotNull(message = "this field is required")
	@Temporal(TemporalType.DATE)
	private Date enrollmentStartDate;
	@NotNull(message = "this field is required")
	@Temporal(TemporalType.DATE)
	private Date enrollmentEndDate;
	
	public Entry() {}
	
	public Entry(String name, Date startDate, Date enrollmentStartDate, Date enrollmentEndDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.enrollmentStartDate = enrollmentStartDate;
		this.enrollmentEndDate = enrollmentEndDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

