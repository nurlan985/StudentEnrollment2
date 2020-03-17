package edu.miu.cs.cs544.domain;

import java.util.Set;

import javax.persistence.Entity;

import edu.miu.cs.cs544.domain.security.Role;

@Entity
public class Student extends Person {
	private String studentId;

	public Student() { }

	public Student(String name, String email, String password, Set<Role> roles, String studentId) {
		super(name, email, password, roles);
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
