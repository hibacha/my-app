package com.nash.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.nash.model.Location;

@Component("LocationDao")
public class LocationDao extends BaseDao {
	public Location save(Location location){
		Session session = getSession();
		Transaction tx=null;
		try{
		
		tx = getSession().beginTransaction();
		session.save(location);
		session.flush();}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
	         session.close(); 
	      }
		return location;
	} 
}
