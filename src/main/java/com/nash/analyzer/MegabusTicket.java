package com.nash.analyzer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MegabusTicket extends AbstractTravelTicket {
	
	private WebElement result;
	public MegabusTicket(WebElement result) {
		this.result=result;
	}
	
	@Override
	public void setPrice() {
		List<WebElement> list = result.findElements(By.xpath(".//ul"));
		
		for (int i = 0; i < list.size(); i++) {
			//skip header line
			if(0==i){
				continue;
			}
			String rawPrice = list.get(i).findElement(By.xpath(".//li[@class='five']")).getText();
			priceList.add(Double.parseDouble(rawPrice.replaceAll("\\$", "")));
		}
	}

}
