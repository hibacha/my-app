package com.nash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@Column(name="personid")
	private Integer personid;
	
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@Column(name="lastname", nullable=false)
	private String lastname;
	
	@Column(name="address", length=255)
	private String address;
	
	@Column(name="city", length=255)
	private String city;
	
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
