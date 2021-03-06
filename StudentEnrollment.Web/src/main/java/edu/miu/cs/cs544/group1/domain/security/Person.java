package edu.miu.cs.cs544.group1.domain.security;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Person.findByEmailAndPassword", query = "FROM Person p WHERE LOWER(p.email) = LOWER(?1) and p.password = ?2")
@NamedQuery(name = "Person.findPersonByEmail", query = "SELECT p FROM Person p WHERE p.email = ?1")
public abstract class Person {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message = "this field is required")
	private String name;
	@Column(unique = true)
	@NotBlank(message = "this field is required")
	@Email
	private String email;
	@JsonIgnore
	private String password;

	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "personRole", joinColumns = @JoinColumn(name = "personId"))
	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	@Size(min = 1)
	private Set<Role> roles;

	public Person() {}

	public Person(String name, String email, String password, Set<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}