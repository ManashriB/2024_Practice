package com.AmazonDemo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saudia.qa.config.Constants;
import com.saudia.qa.config.Utility;

public class AppTest {

	

	@Test
	public void amazonTestCase() {

		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		String amazonLabel = driver.findElement(By.xpath("//div[@id='nav-logo']")).getText();

		Assert.assertEquals(amazonLabel, ".in");
	}

	@Test
	public void amazonLogin() throws Exception {

		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));

		driver.findElement(By.xpath("//span[text () ='Hello, sign in']")).click();
		WebElement enterMobileNo = driver
				.findElement(By.xpath("//input[@aria-label = 'Enter your mobile number or email']"));
		enterMobileNo.click();
		enterMobileNo.sendKeys("8483860062");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();

		WebElement enterPassword = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));

		enterPassword.click();

		enterPassword.sendKeys("Manu@123");

		driver.findElement(By.id("signInSubmit")).submit();

	}

	// ----------------------Select class--DropDown Code-------------

	@Test
	public void amazonAllCategories() {
		// ...................... Test case for Select Class..............

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));

		Select allShoppingCategories = new Select(driver.findElement(By.tagName("select")));

		// Select by visible Text...
		allShoppingCategories.selectByVisibleText("Amazon Devices");

		// Select by value.....
		allShoppingCategories.selectByValue("search-alias=collectibles");

		List<WebElement> listOfAllShoppingCategories = allShoppingCategories.getOptions();

		for (WebElement textOfAllShoppingCategories : listOfAllShoppingCategories) {

			textOfAllShoppingCategories.getText();

			System.out.println("text of all shopping catogries" + "   " + textOfAllShoppingCategories.getText());
		}

	}

	// ------------------Radio Button Code----------------------

	 @Test 
	public void LangSelectRadioButton() throws Exception { 
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://www.amazon.in/"); 
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT)); 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT)); 
	
	
	driver.findElement(By.xpath("//div[text() = 'EN']")).click(); 
	
	WebElement LanguageSelection = driver.findElement(By.xpath("//span[contains(text(), '  मराठी'         )]"));

	boolean isLangDisplayed = LanguageSelection.isDisplayed();																												
	System.out.println("Is Marathi lang is displayed >>"+" "+isLangDisplayed);
	
	
	 boolean isLangSelected= LanguageSelection.isSelected(); 
	System.out.println("Is Marathi lang is Selected >>"+" "+isLangSelected);
	
	
	 boolean isLangEnabled = LanguageSelection.isEnabled(); 
	System.out.println("Is Marathi lang is Enabled >>"+" "+isLangEnabled); 
	 
	LanguageSelection.click();
	 } 

	 
	@Test
	public void DyanamictRadioButtonSelection() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));

		driver.findElement(By.xpath("//div[text() = 'EN']")).click();

		List<WebElement> ListOfLanguades = driver.findElements(By.xpath("//div[@class = 'a-radio a-radio-fancy']"));

		driver.findElement(By.xpath("//span[contains(text(), ' मराठी -' )]")).click();

		System.out.println("in langauge");

		for (WebElement LangText : ListOfLanguades) {

			System.out.println("in loop langauge");

			LangText.getAttribute("value").equals("IN");

			System.out.println("in looppppp langauge");

			LangText.click(); 

			System.out.println("in IN langauge");
		}

	}

	@Test
	public void verifyCountOfLabel() throws Exception {
		
		/*
		 * WebDriver driver = Utility.BrowserSetup(); 
		 * 
		 * Utility.openUrl("https://www.tutorialspoint.com/selenium/practice/webtables.php", driver);
		 * 
		 * WebElement labelHeading = driver.findElement(By.xpath( "/html/body/main/div/div/div[2]/form/div[2]/table/thead/tr"));
		 * 
		 * List<WebElement> lableHeading = labelHeading.findElements(By.tagName("th"));
		 * 
		 * ArrayList<String> actLableHeading = new ArrayList<String>();
		 * 
		 * for( WebElement labetList : lableHeading) {
		 * 
		 * String labelHeadingText = labetList.getText();
		 * 
		 * actLableHeading.add(labelHeadingText);
		 * 
		 * 
		 * 
		 * System.out.println("Actual Table Heading Names >>" + " "+labelHeadingText );
		 * 
		 * System.out.println("Actual Size of Array>>"+actLableHeading.size()); }
		 * 
		 */
	String path = "(//tr)[1]";
	String tag = "th";
	ArrayList<String> actLableHeading = Utility.getListOfHeadingLabels(path, tag);
	ArrayList<String> expLableHeading = Utility.getExpectedListOfLabel();
	  
	/*
	 * ArrayList<String> expLableHeading = new ArrayList<String>();
	 * 
	 * expLableHeading.add(" Name"); expLableHeading.add("Last Name");
	 * expLableHeading.add("Age"); expLableHeading.add("Email");
	 * expLableHeading.add("Salary"); expLableHeading.add("Department");
	 * expLableHeading.add("Action");
	 * 
	 * System.out.println("Expected Table Heading Names >>" + " "+ expLableHeading);
	 * 
	 * System.out.println("Expected Size of Array>>"+expLableHeading.size());
	 */
	Assert.assertEquals(actLableHeading.size(),expLableHeading.size() );
	
	
	  }
	
		@Test
		public void verifyLabelSequance() throws Exception {

			String path = "(//tr)[1]";
			String tag = "th";
			ArrayList<String> actLableHeading = Utility.getListOfHeadingLabels(path, tag);
			ArrayList<String> expLableHeading = Utility.getExpectedListOfLabel();

			if (actLableHeading.size() == expLableHeading.size()) {

				ArrayList<Boolean> AlFlag = new ArrayList<>();
				
				for (int i = 0; i < expLableHeading.size(); i++) {

					String labelExp = expLableHeading.get(i);
					String labelAct = actLableHeading.get(i);
					// if label is not equal -------
					if (!labelExp.equals(labelAct)) {
						System.out.println("Label is >>" +"  "+ labelAct + "  "+"Label should be"+"  " + labelExp);
						
						AlFlag.add(false);
					}else {
						AlFlag.add(true);
					  } 
					}
				Boolean checkTheFalseEntry	= AlFlag.contains(false); // true
				Assert.assertFalse(checkTheFalseEntry);
				
			
// if 204 label size is not matching in that before going for loop method goes in else and method will fail
		} else {

				Assert.assertEquals(true, false);
			}

		}

		
		
		
		
		
	}





    
