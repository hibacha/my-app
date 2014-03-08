package com.nash.app;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nash.analyzer.AbstractTravelTicket;
import com.nash.analyzer.MegabusTicket;

/**
 * Hello world!
 * 
 */

public class Runner {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();

		Reader reader = new Reader();
		driver.get(reader.getProperty("MEGA_BUS_NY_TO_BOS_APR_27_2014"));
		
		WebElement resultDiv = driver.findElement(By.xpath("//div[@class='journeyresult']"));
		AbstractTravelTicket megabus=new MegabusTicket(resultDiv);
		try {
			System.out.println(megabus.getLowestPrice());
			megabus.selectLowestPrice();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	public static void sleep(int seconds){
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
