package com.nash.spring.dao;

import org.springframework.stereotype.Component;

import com.nash.model.Person;

@Component("tixDAO")
public class TicketDAO extends BaseDao{

	
	public Person getPerson(int id){
		System.out.println("In DAO class");
		Person p = (Person)getSession().get(Person.class, id);
		return p;
	}
}
