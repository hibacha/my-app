package com.nash.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Route {
	@Id
	@SequenceGenerator(name="RouteSequence", schema="public",sequenceName="route_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RouteSequence")
	private Integer id;
	
	private Location pickUp;
	
	private Location dropOff;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="PICKUP")
	public Location getPickUp() {
		return pickUp;
	}
	public void setPickUp(Location pickUp) {
		this.pickUp = pickUp;
	}
	@ManyToOne
	@JoinColumn(name="DROPOFF")
	public Location getDropOff() {
		return dropOff;
	}
	public void setDropOff(Location dropOff) {
		this.dropOff = dropOff;
	}
	
}
