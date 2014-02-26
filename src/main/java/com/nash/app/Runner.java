package com.nash.app;

/**
 * Hello world!
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class App {

	public static void main(String[] args) {
		//set chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"/Users/zhouyf/workspace/my-app/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		// And now use this to visit Google
		driver.get("http://www.google.com");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		// Enter something to search for
		element.sendKeys("test");
		WebElement submit = driver.findElement(By.id("gbqfb"));
		// Now submit the form. WebDriver will find the form for us from the
		// element
		submit.click();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		Assert.assertEquals(true, true);
	}

}
