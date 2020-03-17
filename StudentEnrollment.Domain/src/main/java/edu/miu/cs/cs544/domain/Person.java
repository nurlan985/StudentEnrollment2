package edu.miu.cs.cs544.domain;

import java.util.Set;
import javax.persistence.*;

import edu.miu.cs.cs544.domain.security.Role;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;
	private String password;

	@ElementCollection
	@CollectionTable(name = "personRole", joinColumns = @JoinColumn(name = "personId"))
	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
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