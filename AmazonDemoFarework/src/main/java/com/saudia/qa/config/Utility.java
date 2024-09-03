package com.saudia.qa.config;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


// Read property file , ask for any value, 

public class Utility {

public static WebDriver BrowserSetup() throws Exception {
	
	
	FileInputStream fis = new FileInputStream("data.properties");
	
	Properties Properties = new Properties();
	
	Properties.load(fis);
	
String brName = Properties.getProperty("brName");	
	
	
	WebDriver driver = null;
	
	if(brName.equals("chrome")){
		
		driver = new ChromeDriver();
		
	}
	
	if (brName.equals("edge")) {
		
		driver = new EdgeDriver();
		
   }
	
	//driver.get("https://www.amazon.in/");
	
	return driver;
	
	
}
	
public static void openUrl(String url, WebDriver driver) {
	
	driver.get(url);
	
}


public static ArrayList<String> getListOfHeadingLabels(String path, String tag) throws Exception {

	WebDriver driver = Utility.BrowserSetup();

	Utility.openUrl("https://www.tutorialspoint.com/selenium/practice/webtables.php", driver);
	
    WebElement WebEement = driver.findElement(By.xpath(path));

	List<WebElement> lableHeading = WebEement.findElements(By.tagName(tag));

	ArrayList<String> actLableHeading = new ArrayList<String>();

	for (WebElement labetList : lableHeading) {

		String labelHeadingText = labetList.getText();

		actLableHeading.add(labelHeadingText);

		System.out.println("Actual Table Heading Names >>" + " " + labelHeadingText);

		System.out.println("Actual Size of Array>>" + actLableHeading.size());

	
	}
	
	return actLableHeading;
	
}
	
public static ArrayList<String> getExpectedListOfLabel() {
	
ArrayList<String> expLableHeading = new ArrayList<String>();
	
	expLableHeading.add("First Name");
	expLableHeading.add("Last Name");
	expLableHeading.add("Age");
	expLableHeading.add("Email");
	expLableHeading.add("Salary");
	expLableHeading.add("Department");
	expLableHeading.add("Action");
	  
	System.out.println("Expected Table Heading Names >>" + " "+ expLableHeading);
	
	System.out.println("Expected Size of Array>>"+expLableHeading.size());
	
	return expLableHeading;
		
	
 }


}
