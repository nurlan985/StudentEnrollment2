package edu.miu.cs.cs544.group1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "this field is required")
	@Size(max = 2000)
	@Column(length = 2000)
	private String description;

	@NotBlank(message = "this field is required")
	private String name;

	@NotBlank(message = "this field is required")
	@Size(min = 3 , max = 7)
	@Column(length = 7)
	private String code;

	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(String code, String name, String description) {
		super();
		this.description = description;
		this.name = name;
		this.code = code;
	}


	public Long getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
