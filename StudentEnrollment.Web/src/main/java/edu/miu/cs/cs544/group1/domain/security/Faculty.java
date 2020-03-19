package edu.miu.cs.cs544.group1.domain.security;

import java.util.Set;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Faculty extends Person {
	@NotBlank
	private String title;

	public Faculty() {
		super();
	}

	
	
	public Faculty(String name, String email, String password, Set<Role> roles, String title) {
		super(name, email, password, roles);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
