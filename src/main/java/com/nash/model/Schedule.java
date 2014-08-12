package com.nash.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Schedule {
	@Id
	@SequenceGenerator(name="ScheduleSequence",schema="public",sequenceName="schedule_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ScheduleSequence")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ROUTE")
	private Route route;
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	private Float length;
	private Float price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Float getLength() {
		return length;
	}
	public void setLength(Float length) {
		this.length = length;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	
}
