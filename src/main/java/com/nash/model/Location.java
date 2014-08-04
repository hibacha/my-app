package com.nash.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Location {
	@Id
	@SequenceGenerator(name="LocationSequence", schema="public", sequenceName="location_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LocationSequence")
	private Integer id;
	private String address;
	private String latitude;
	private String longitude;
	private String abbreviation;
	private String city;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pickUp",cascade=CascadeType.ALL)
	private Set<Route> routeGivenByPickUp = new HashSet<Route>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "dropOff",cascade=CascadeType.ALL)
	private Set<Route> routeGivenByDropOff = new HashSet<Route>();
	
	public Set<Route> getRouteGivenByPickUp(){
		return this.routeGivenByPickUp;
	}
	
	public Set<Route> getRouteGivenByDropOff() {
		return routeGivenByDropOff;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	public void setRouteGivenByDropOff(Set<Route> routeGivenByDropOff) {
		this.routeGivenByDropOff = routeGivenByDropOff;
	}
	public void setRouteGivenByPickUp(Set<Route> routeGivenByPickUp) {
		this.routeGivenByPickUp = routeGivenByPickUp;
	}
	
	

	
}
