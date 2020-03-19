package edu.miu.cs.cs544.group1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id 
	@GeneratedValue
	private long id;
	
	private String street;
	
	private String city;
	
	private int postalCode;
	
	private String country;

	
	public Address() {
		
	}	
	
	public Address(String street, String city, int postalCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
