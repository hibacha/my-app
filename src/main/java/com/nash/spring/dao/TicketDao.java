package com.nash.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nash.Foo;
import com.nash.model.Person;
import com.nash.model.Ticket;

@Component("tixDAO")
public class TicketDAO extends BaseDao{

	@Autowired
	private Foo foo;
	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	public Person getPerson(int id){
		System.out.println("In DAO class");
		Person p = (Person)getSession().get(Person.class, id);
		return p;
	}
	
	public Ticket saveTicket(Ticket ticket){
		Session session = getSession();
		Transaction tx=null;
		try{
		
		tx = getSession().beginTransaction();
		session.save(ticket);
		session.flush();}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
	         session.close(); 
	      }
		return ticket;
	}
}
