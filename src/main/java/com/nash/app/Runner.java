package com.nash.app;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		sleep(10);
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
