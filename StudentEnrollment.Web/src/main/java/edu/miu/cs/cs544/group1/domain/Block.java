package edu.miu.cs.cs544.group1.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Block {

	@Id
	@GeneratedValue
	private long id;

	@NotBlank(message = "this field is required")
	@Size(min = 6 , max = 10)
	@Column(length = 10)
	private String code;

	@NotBlank(message = "this field is required")
	private String name;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Semester semester;
	private int blockSequencyNo;
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date endDate;
	
	
	public Block(String code, String name, Semester semester, int blockSequencyNo, Date startDate, Date endDate) {
		super();
		this.code = code;
		this.name = name;
		this.semester = semester;
		this.blockSequencyNo = blockSequencyNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Block() {	}

	public Long getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getBlockSequencyNo() {
		return blockSequencyNo;
	}
	public void setBlockSequencyNo(int blockSequencyNo) {
		this.blockSequencyNo = blockSequencyNo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	

}
