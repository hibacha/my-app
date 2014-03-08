package com.nash.analyzer;

import java.util.Date;

import com.nash.exceptions.NoTicketInfoAvailableException;

public abstract class AbstractTravelTicket {

	boolean isAvailable;
	boolean isOneWay;
	Date startDate;
	Date returnDate;
	abstract public Double getLowestPrice() throws NoTicketInfoAvailableException;
	abstract public void selectLowestPrice() throws NoTicketInfoAvailableException;

}
