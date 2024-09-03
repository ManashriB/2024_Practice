package com.AmazonDemo;

import org.testng.annotations.Test;

import com.saudia.qa.config.Constants;
import com.saudia.qa.config.Utility;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @Test(dataProviderClass = DiffDataProviderClass.class,dataProvider = "amazonLoginTestData")
  public void AmazonLogin(String uName, String Password) throws Exception {
	  
	WebDriver driver = Utility.BrowserSetup();
	
	Utility.openUrl("https://www.amazon.in/", driver);
	
	driver.findElement(By.xpath("//span[text () ='Hello, sign in']")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
	driver.findElement(By.xpath("//input[@aria-label = 'Enter your mobile number or email']")).sendKeys(uName);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
   	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
   
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
   	
	driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(Password);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
	
	driver.findElement(By.id("signInSubmit")).submit();
	  
	  
	  
  }

	/*
	 * @DataProvider public Object[][] amazonLoginTestData() { return new Object[][]
	 * {
	 * 
	 * new Object[] { "8483860062", "Manu@123" }, new Object[] { "8483860062",
	 * "Manu@124" }, }; }
	 */
}
