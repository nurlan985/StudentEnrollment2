package edu.miu.cs.cs544.group1.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Block_Table")
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Block_Code")
	private String code;
	@Column(name = "Block_Name")
	private String name;
	@Column(name = "Block_Semester")
	private String semester;
	@Column(name = "Block_SequenceNumber")
	private int blockSequencyNo;
	@Column(name = "Block_StartDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "Block_EndDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
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
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
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
