package com.nash.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nash.model.Person;
import com.nash.spring.dao.TicketDAO;

@Service("TicSvc")
public class TicketService {

	@Autowired
	private TicketDAO tixDAO;

	public Person getTicket(int id) {
		System.out.println("get dao from service");
		return tixDAO.getPerson(id);
		
	}

	public void setTixDAO(TicketDAO tixDAO) {
		this.tixDAO = tixDAO;
	}
	
	
}
