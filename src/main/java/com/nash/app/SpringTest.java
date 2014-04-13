package com.nash.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nash.model.Person;
import com.nash.spring.service.TicketService;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
		TicketService service = (TicketService)ctx.getBean("TicSvc");
		Person p=service.getTicket(1);
		System.out.println(p.getFirstname());
	}

}
