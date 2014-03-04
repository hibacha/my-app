package com.nash.analyzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractTravelTicket {

	boolean isAvailable;
	boolean isOneWay;
	Date startDate;
	Date returnDate;
	List<Double> priceList=new ArrayList<Double>();
	
	abstract public void setPrice();

}
