package com.nash.app;

import java.io.IOException;
import java.util.List;

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
		Reader reader = new Reader();
		WebDriver driver = new ChromeDriver();
		String url = reader.getProperty("MEGA_BUS_NY_TO_BOS_APR_27_2014");
		driver.get(url);
		WebElement resultDiv = driver.findElement(By.xpath("//div[@class='journeyresult']"));
		AbstractTravelTicket megabus=new MegabusTicket(resultDiv);
		megabus.setPrice();
		//sleep(10);
		//driver.quit();
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
