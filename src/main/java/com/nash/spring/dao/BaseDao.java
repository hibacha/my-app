package com.nash.spring.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {

	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
