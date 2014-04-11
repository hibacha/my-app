package com.nash.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nash.model.Person;

public class HibernateConnection {
	static final Logger logger = LoggerFactory
			.getLogger(HibernateConnection.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder
				.build());
		  logger.info("connect database");
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		try {
			buildSessionFactory();
//			Session session = sessionFactory.openSession();
//			Query query = session.createQuery("select p from "
//					+ Person.class.getName() + " p");
//			List list = query.list();
//			System.out.println(list.size());
			HibernateConnection hconn= new HibernateConnection();
			hconn.addPerson();
		} catch (Exception e) {
			System.err.println("error");
		} finally {
			shutdown();
		}
	}
	public  void addPerson(){
		Transaction tx = null;
	      Session session = sessionFactory.openSession();
	      try{
	    	  logger.info("transaction");
	         tx = session.beginTransaction();
	         Person p = new Person();
	         p.setPersonid(192);
	         p.setFirstname("momm");
	         session.save(p);
	         session.flush();
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
	}
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
		System.exit(0);
	}

}
