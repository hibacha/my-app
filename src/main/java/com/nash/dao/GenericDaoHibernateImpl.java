package com.nash.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.nash.finder.FinderExecutor;

public class GenericDaoHibernateImpl<T, PK extends Serializable> implements
		GenericDao<T, PK>, FinderExecutor<T> {
	
	static final Logger logger=LoggerFactory.getLogger(GenericDaoHibernateImpl.class);
	private Class<T> type;

	private SessionFactory sessionFactory;

	public GenericDaoHibernateImpl(Class<T> type) {
		this.type = type;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public PK create(T o) {
		Session session = getSession();
		PK id = (PK)session.save(o);
		logger.info("persist a POJO of "+o.getClass());
		return id;
	}

	@SuppressWarnings("unchecked")
	public T read(PK id) {
		return (T) getSession().get(type, id);
	}

	public void update(T o) {
		getSession().update(o);
	}

	public void delete(T o) {
		getSession().delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeFinder(Method method, Object[] queryArgs) {
		final String queryName = queryNameFromMethod(method);
		final Query namedQuery = getSession().getNamedQuery(queryName);
		for (int i = 0; i < queryArgs.length; i++) {
			Object arg = queryArgs[i];
			namedQuery.setParameter(i, arg);
		}
		return (List<T>) namedQuery.list();
	}

	private String queryNameFromMethod(Method method){
		String qualifiedClassName = type.getName();
		String methodName = method.getName();
		StringBuilder sb = new StringBuilder();
		sb.append(qualifiedClassName).append(".").append(methodName);
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterateFinder(Method method, Object[] queryArgs) {
		final String queryName = queryNameFromMethod(method);
		final Query namedQuery = getSession().getNamedQuery(queryName);
		for (int i = 0; i < queryArgs.length; i++) {
			Object arg = queryArgs[i];
			namedQuery.setParameter(i, arg);
		}
		return (Iterator<T>)namedQuery.iterate();
	}

	// Not showing implementations of getSession() and setSessionFactory()

}