package edu.miu.cs.cs544.group1.domain.security;

import javax.persistence.Entity;

@Entity
public class Faculty extends Person {
	
	private String title;

	public Faculty() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
