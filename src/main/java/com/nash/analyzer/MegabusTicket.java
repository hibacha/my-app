package com.nash.analyzer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nash.exceptions.NoTicketInfoAvailableException;

public class MegabusTicket extends AbstractTravelTicket {
	final Logger logger = LoggerFactory.getLogger(MegabusTicket.class);
	private final static Double INIT_PRICE = Double.POSITIVE_INFINITY;
	private WebElement result;
	private Double lowestPrice=INIT_PRICE;
	private WebElement radioButton4lowestPrice=null;
	public MegabusTicket(WebElement result) {
		this.result=result;
	}
	
	public void checkPrice() throws NoTicketInfoAvailableException{
		logger.info("check price once");
		List<WebElement> ticketsList = result.findElements(By.cssSelector("ul[class='journey standard']"));
		isTicketInfoAvailable(ticketsList);
		for (int i = 0; i < ticketsList.size(); i++) {
			WebElement price = ticketsList.get(i).findElement(By.xpath(".//li[@class='five']"));
			Double currentPrice = Double.parseDouble(price.getText().replaceAll("\\$", ""));
			
			if(currentPrice<lowestPrice){
				lowestPrice= currentPrice;
				radioButton4lowestPrice =price.findElement(By.xpath("(./preceding-sibling::li)[1]//input"));
			}
			lowestPrice= currentPrice<lowestPrice?currentPrice:lowestPrice;
		}
	}


	private void isTicketInfoAvailable(List<WebElement> list)
			throws NoTicketInfoAvailableException {
		if(list.size()==0){
			throw new NoTicketInfoAvailableException();
		}
	}

	
	@Override
	public Double getLowestPrice() throws NoTicketInfoAvailableException {
		if(lowestPrice.equals(INIT_PRICE)){
			checkPrice();
		}
		return lowestPrice;
	}

	@Override
	public void selectLowestPrice() throws NoTicketInfoAvailableException {
		if(lowestPrice.equals(INIT_PRICE)){
			checkPrice();
		}
		radioButton4lowestPrice.click();
	}

}
