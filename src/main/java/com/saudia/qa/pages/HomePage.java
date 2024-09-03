package com.saudia.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.LayoutHeader;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class HomePage extends TestBase {

	private static Logger Log = Logger.getLogger(HomePage.class);
	private ReportLog reportLog;

	@FindBy(xpath = "//input[@placeholder='Search country/territory'][1]")
	public WebElement searchCountryTXT;

	@CacheLookup
	@FindBy(xpath = "(//h5[text()= ' Saudi Arabia'])[1]")
	public WebElement saudiOPT;

	@FindBy(xpath = "//span[text()= 'English']")
	public WebElement englishOPT;

	@FindBy(xpath = "//img[@aria-label='Click to change Country/Territory & Language']")
	public WebElement chooseCounrtBTN;

	@FindBy(xpath = "//input[@placeholder='From']")
	public WebElement fromTXT;

	@FindBy(xpath = "//span[text()=' cancel ']")
	public WebElement fromCancelBTN;

	//@CacheLookup
	@FindBy(xpath = "//span[contains( text(),'Yes' )]")
	public WebElement acceptCookiesBTN;

	@FindBy(xpath = "//input[@aria-label='From']")
	public WebElement originTXT;

	@FindBy(xpath = "(//input[@aria-label='From'])[1]")
	public WebElement originMC1TXT;

	@FindBy(xpath = "(//input[@aria-label='From'])[2]")
	public WebElement originMC2TXT;

	@FindBy(xpath = "//*[text()=' flight_takeoff ']")
	public WebElement flightTakeOffImg;

	@FindBy(xpath = "(//*[text()=' flight_takeoff '])[1]")
	public WebElement flightTakeOffMC1Img;

	@FindBy(xpath = "(//*[text()=' flight_takeoff '])[2]")
	public WebElement flightTakeOffMC2Img;

	@FindBy(xpath = "//div[@aria-label='Click here to clear flying from Destinations value ']")
	public WebElement originCancelBTN;

	@FindBy(xpath = "//*[contains(@class,'light__landing is-focused')]//input")
	public WebElement destinationTXT;

	@FindBy(xpath = "(//*[contains(@class,'light__landing is-focused')]//input)[1]")
	public WebElement destinationMC1TXT;

	@FindBy(xpath = "(//*[contains(@class,'light__landing is-focused')]//input)[2]")
	public WebElement destinationMC2TXT;

	@FindBy(xpath = "//span[text()='Don’t change']//parent::div")
	public WebElement dontChangeBTN;

	//@FindBy(xpath = "(//span[@aria-label = 'Click here to open the calendar dropdown '])[1]")
	@FindBy(xpath = "(//*[@class='material-icons ngx-daterangepicker-action'])[1]")
	public WebElement calendarDDBTN;

	@FindBy(xpath = "(//span[@aria-label = 'Click here to open the calendar dropdown '])[2]")
	public WebElement calendarDD2MCBTN;

	@FindBy(xpath = "(//th[@class='month drp-animate'])[2]/div")
	public WebElement currentMonth;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[2]")
	public WebElement nxtMonthRTBTN;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[1]")
	public WebElement nxtMonthOWMCBTN;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[2]")
	public WebElement nxtMonthOWMC2BTN;

	@FindBy(xpath = "(//td[@class='weekend ng-star-inserted available'])[1]")
	public WebElement departDate;

	@FindBy(xpath = "(//td[@class='weekend ng-star-inserted available'])[2]")
	public WebElement returnDate;

	@FindBy(xpath = "(//td[@class='weekend ng-star-inserted available'])[14]")
	public WebElement mc2ReturnDate;

	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public WebElement calendarContRTBTN;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement calendarContOWBTN;

	@FindBy(xpath = "//span[text()= 'Search Flights']")
	public WebElement searchFlightsBTN;

	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public WebElement calendarContMC2BTN;

	@FindBy(xpath = "//*[@aria-labelledby='Continue to Passenger']")
	public WebElement contToPssngrBTN;

	@FindBy(xpath = "//*[@class='passenger-information']")
	public WebElement pssngrInfoTitle;

	@FindBy(xpath = "//*[@class='control-wrapper passenger-title-input']//span[text()=' expand_more ']")
	public WebElement titleExpandArraw;

	@FindBy(xpath = "//*[text()='First name']")
	public WebElement firstNameInput;

	@FindBy(xpath = "//*[text()='Last name']")
	public WebElement lastNameInput;

	@FindBy(xpath = "//button[text()='Edit search ']")
	public WebElement editSearchBTN1;

	@FindBy(xpath = "//*[@class='passanger-arrow']")
	public WebElement passengerArrowBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Adults']")
	public WebElement adultAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Children']")
	public WebElement childrenAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Infants']")
	public WebElement infantsAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Infant on seat']")
	public WebElement infantOnSeatAddBTN;

	@FindBy(xpath = "//div[@class='class-details']//*[text()='Guest']")
	public WebElement guestRadioBTN;

	@FindBy(xpath = "//div[@class='class-details']//*[text()='Business']")
	public WebElement guestBusinessBTN;

	@FindBy(xpath = "//div[@class='class-details']//*[text()='First']")
	public WebElement guestFirstBTN;

	@FindBy(xpath = "//*[@class='passenfer-confirm-wrapper']//button")
	public WebElement passengerConfirmBTN;

	@FindBy(xpath = "//*[text()=' One way ']//parent::span//parent::label//input[@type='radio']")
	public WebElement oneWayRadioBTN;

	@FindBy(xpath = "//*[text()=' Round trip  ']//parent::span//parent::label//input[@type='radio']")
	public WebElement RTRadioBTN;

	@FindBy(xpath = "//*[text()='Multi-city']")
	public WebElement mcBTN;
	
	@FindBy(xpath = "//input[@value='multicity']")
	public WebElement mcRadioBTN;

	@FindBy(xpath = "//*[text()=' swap_horiz ']")
	public WebElement swapHorizBTN;

	@FindBy(xpath = "(//th[@class='month drp-animate'])[1]")
	public WebElement currentMonthTitle;

	@FindBy(xpath = "(//th[@class='month drp-animate'])[2]")
	public WebElement currentMonthTitleRT;

	@FindBy(xpath = "//*[@class='table-condensed ng-star-inserted']//span")
	public WebElement date1;

	@FindBy(xpath = "//h2[text() = 'Would you like to change your selected country?']")
	public WebElement changeYourSelectedCountryPopUp;

	@FindBy(xpath = "//span[text()='Add flight']")
	public WebElement addFlight;

	@FindBy(xpath = "//span[text() = 'keyboard_arrow_down']")
	public WebElement inActivePassengerAndClassDropDown;

	@FindBy(xpath = "//p[@id='passenger-input']")
	public WebElement passengerAndClassDropDown;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[2]")
	public WebElement nxtMonthRtBTN;

	@FindBy(xpath = "//div[@id='1']//div[@class='flightcard-cabin']//*[@class='mat-card mat-focus-indicator flexcard guest_card flight-card']")
	public WebElement selectGuestCard;

	@FindBy(xpath = "//div[@id='1']//div[@class='flightcard-cabin']//*[@class='mat-card mat-focus-indicator flexcard business_card flight-card']")
	public WebElement selectBusinessCard;

	@FindBy(xpath = "//div[@id='1']//div[@class='flightcard-cabin']//*[@class='mat-card mat-focus-indicator flexcard First_card flight-card']")
	public WebElement selectFirstCard;

	@FindBy(xpath = "//*[@aria-label='Select Guest Basic Flight']")
	public WebElement selectBasicFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Guest Saver Flight']")
	public WebElement selectSaverFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Guest Flex Flight']")
	public WebElement selectGuestFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Guest Semi Flex Flight']")
	public WebElement selectGuestSemiFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Business Basic Flight']")
	public WebElement selectBusinessBasicFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Business Semi Flex Flight']")
	public WebElement selectBusinessSemiFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Business Flex Flight']")
	public WebElement selectBusinessFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select First Semi Flex Flight']")
	public WebElement selectFirstSemiFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Business Flex Flight']")
	public WebElement selectFirstFlexFlightBTN;

	@FindBy(xpath = "//button[text()='Edit search ']")
	public WebElement editSearchBTN;

	@FindBy(xpath = "//div[@class = 'flightList ng-star-inserted']//app-jss-flight-record[1]")
	public WebElement flightCard;

	@FindBy(xpath = "(//button[@id='login-btn-spinner'])[1]")
	public WebElement loginBTNSpinner;

	@FindBy(xpath = "//td[contains(@class,'cell-selected')]")
	public WebElement selctedCell;

	@FindBy(xpath = "//div[contains(@class,'flexi-date-selector-title')]")
	public WebElement flexibleDatePopUpHeading;

	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement flexibleDatePopUpconfirmBTN;
	
	//@FindBy(xpath="(//img[@alt='Saudia Header logo'])[2]")
	@FindBy(xpath="//app-jss-saudia-logo//a")
	public WebElement saudiaLogo;
	
	@FindBy(xpath="(//button[@id='login-btn'])[1]")
	public WebElement loginBTN;
	
	public WebElement date(int index) {
		return Utilities.driver
				.findElement(By.xpath("(//*[@class='table-condensed ng-star-inserted']//span)[" + index + "]"));
	}

	public WebElement listCalendarIconMC(int index) {

		return Utilities.driver.findElement(By.xpath(
				"(//div[contains(@class,'custom-datepicker')]//span[@aria-label = 'Click here to open the calendar dropdown '])["
						+ index + "]"));
	}

	public WebElement listCurrentMonthTitleMC(int index) {
		return Utilities.driver.findElement(By.xpath("(//th[@class='month drp-animate'])[" + index + "]"));
	}

	public WebElement listNxtMonthOWMCBTNMC(int index) {
		return Utilities.driver
				.findElement(By.xpath("(//th[@class='next available ng-star-inserted'])[" + index + "]"));
	}

	public WebElement listCalendarContOWBTNMC(int index) {
		return Utilities.driver.findElement(By.xpath("(//button[text()='Continue'])[" + index + "]"));
	}

	public List<WebElement> dateMC(int index) {
		return driver.findElements(By.xpath("(//tbody[@class=\"drp-animate\"])[" + index
				+ "]//td[contains(@class,'available') and not(contains(@class,'off'))]//span"));
	}

	public List<WebElement> dateOW() {
		return driver.findElements(By.xpath(
				"(//tbody[@class='drp-animate'])[1]//td[ (contains(@class,'available')) and not(contains(@class,'off'))]//span"));
	}

	public List<WebElement> dateRT() {
		/*return driver.findElements(By.xpath(
				"(//tbody[@class='drp-animate'])[2]//td[ (contains(@class,'available')) and not(contains(@class,'off'))]"));*/
		
		return driver.findElements(By.xpath(
				"(//tbody[@class='drp-animate'])[2]//td[contains(@class,'available') and not(contains(@class,'off'))]"));
	}

	public WebElement FareCardRadioSelection(String fareCardClass) {
		return Utilities.driver.findElement(By.xpath("//div[@class='class-details']//*[text()='" + fareCardClass  +"']"));
	}
	
	/* MMB */
	
	@FindBy(xpath="//div[@role='tab'][2]")
	public WebElement MMBTab;
	
	@FindBy(xpath="//span[@class='mat-radio-container']/span")
	public WebElement bookingReferenceRadioMMB;
	
	@FindBy(xpath="//span[@class='mat-radio-container']//input[@value='frequent-flyer']")
	public WebElement frequentFlyerMMB;
	
	@FindBy(xpath="//input[@formcontrolname='eticketnum']")
	public WebElement bookingReferenceInputMMB;
	
	@FindBy(xpath="//input[@formcontrolname='lastName' or @formcontrolname='lastname']")
	public WebElement lastNameInputMMB;
	
	@FindBy(xpath="//div[@class='manage-booking__btns']/button")
	public WebElement continueBTNMMB;
	
	@FindBy(xpath="//div[@class='checkin-tab__btns']/button")
	public WebElement checkInBTNMMB;
	
	/* CheckIn */
	
	@FindBy(xpath = "//div[@role='tab'][3]")
	public WebElement checkInTab;
	
	public HomePage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");
	}

	public void acceptPrivacyCookies() throws Exception {
		try {
			Utilities.waitForInvisibilityOfElement(loginBTNSpinner, Constants.highLoadTime, Constants.poolingTime_Min);
			Thread.sleep(1000);
			Utilities.jsCLick(acceptCookiesBTN);
		} catch (Exception e) {
			e.printStackTrace();
			if(Utilities.verifyElementPresent(acceptCookiesBTN) == true)
			{
				System.out.println("Cookies are not accepted!!");
				Utilities.jsCLick(acceptCookiesBTN);
			}
		}
	}

	public void changeCountryIndiaToSaudiArabia(String searchCountryText) throws Throwable {
		try {
			String country = Utilities.getAttributeValueOfElement(chooseCounrtBTN, "src");			
			if (!country.contains("Flag-saudi_arabia")) {
				Utilities.moveToElementAndClick(chooseCounrtBTN);
				Utilities.moveToElementAndClick(searchCountryTXT);
				Utilities.setText(searchCountryTXT, searchCountryText);
				Utilities.enterBackspaceKey(searchCountryTXT, 1);
				Utilities.moveToElementAndClick(saudiOPT);
				Utilities.moveToElementAndClick(englishOPT);
			}
			reportLog.logPass("Saudia Arabia Country is selected with English language");
		} catch (Exception e) {
			reportLog.logFail("Saudia Arabia Country is NOT selected", " with English language");
			throw new Exception("Error while Changing Country to Saudia");
		}
	}

	public void datepickerCalOW(String monthInput, String dateInput) throws Throwable {
		try {
			String datetxt=null;

			Utilities.moveToElementAndClick(calendarDDBTN);

			String currentmonthtext = currentMonthTitle.getText().trim();

			System.out.println("Month on UI :" + currentmonthtext);
			System.out.println("Month in TestData  :" + monthInput);

			while (!currentmonthtext.equalsIgnoreCase(monthInput)) {
				nxtMonthOWMCBTN.click();
				currentmonthtext = currentMonthTitle.getText().trim();
				System.out.println("currentmonthtext " + currentmonthtext);
				Thread.sleep(2000);
			}

			System.out.println("dateOW[] Size : " + dateOW().size());
			for (int i = 0; i < dateOW().size(); i++) {
				 datetxt = dateOW().get(i).getText().trim();
				System.out.println("datetxt.trim() ->  " + datetxt.trim());
				if (datetxt.equals(dateInput)) {
					System.out.println("Calender date selected - " + datetxt);
					Utilities.scrollToElementView(calendarContOWBTN);
					Utilities.jsCLick(dateOW().get(i));
					Utilities.jsCLick(calendarContOWBTN);
					break;
				}
				
			}
			reportLog.logPass("Select Departure Date for One Way Trip :  ", datetxt + currentmonthtext );
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Selecting the date in Round way Trip calendar");
		}
	}

	public String datepickerCalRT(String monthInput, String dateInput) throws Throwable {
		try {

			String date = null;
			String datetxt = null;
			//Utilities.moveToElementAndClick(calendarDDBTN);

			String currentmonthtext = currentMonthTitleRT.getText().trim();

			System.out.println("Month on UI :" + currentmonthtext);
			System.out.println("Month in TestData  :" + monthInput);

			while (!currentmonthtext.equalsIgnoreCase(monthInput)) {
				nxtMonthRtBTN.click();
				currentmonthtext = currentMonthTitleRT.getText().trim();
				System.out.println("currentmonthtext " + currentmonthtext);
				Thread.sleep(2000);
			}

			System.out.println("dateRt[2] Size : " + dateRT().size());
			for (int i = 0; i < dateRT().size(); i++) {
				datetxt = dateRT().get(i).getText().split("\n")[0].trim();
				System.out.println("datetxt.trim() ->  " + datetxt.trim());
				if (datetxt.equals(dateInput)) {
					System.out.println("i " + i + "Date Selected = "+ datetxt);
					Utilities.jsCLick(dateRT().get(i));
					//Utilities.jsCLick(dateRT().get(i));
					//Utilities.jsCLick(calendarContRTBTN);
					break;
				}
			}
			System.out.println("Calender date selected - " + datetxt);
			date = datetxt + currentmonthtext;	
			return date;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Selecting the date in Round way Trip calendar");
		}
	}

	
	public void datePickerRT(String departingMonth, String departingDate, String retunMonth, String returnDate)
			throws Exception {

		try {
			
			Utilities.moveToElementAndClick(calendarDDBTN);
			String depDate = datepickerCalRT(departingMonth, departingDate);
			reportLog.logPass("Select Departure Date for Round Trip :  ", depDate);
			String retDate = datepickerCalRT(retunMonth, returnDate);
			
			//Utilities.scrollDownVertically();
			Utilities.jsCLick(calendarContRTBTN);
			reportLog.logPass("Select Return Date for Round Trip :  ", retDate);

		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception("Error while Selecting the date in Round way Trip calendar");
		}
	}
	
	/*
	 * public void serachFlight() throws Throwable {
	 * 
	 * try { Utilities.scrollToElement(searchFlightsBTN);
	 * Utilities.jsCLick(searchFlightsBTN); } catch (Exception e) {
	 * e.printStackTrace(); throw new Exception("Error while searching Flight"); }
	 * 
	 * }
	 */

	public void webtable() throws Throwable {
		try {

			Utilities.moveToElementAndClick(calendarDDBTN);
			// this will find all matching nodes in calendar
			// List<WebElement>
			// allDates=driver.findElements(By.xpath("(//*[@class='table-condensed
			// ng-star-inserted']//span)"));

			List<WebElement> d = driver.findElements(By.xpath("(//*[@class='drp-animate'])[2]//tr//td//span"));
			// iterate list
			for (int i = 0; i < d.size(); i++) {
				System.out.println("size is:" + d.size());
				// check expected data
				String s = d.get(i).getText();
				System.out.println("ssss :" + s);
				if (s.equals("10")) {
					System.out.println("index :" + i);
					Utilities.scrollToElement(date(i));
					Utilities.jsCLick(date(i));
					Utilities.scrollToElement(calendarContOWBTN);
					Utilities.jsCLick(calendarContOWBTN);
					break;
				}
			}

		}

		catch (Exception e) {
			reportLog.logFail("One way ", "Date is not slected");
			throw new Exception("Error while Selecting the date in One way Trip calendar");
		}
	}

	public void roundTripMethod(String origin, String destination) throws Throwable {

		try {

			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(swapHorizBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(swapHorizBTN);
			Thread.sleep(3000);
			Utilities.jsCLick(RTRadioBTN);
			Utilities.waitForAllElementVisibilty(flightTakeOffImg, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(flightTakeOffImg);
			Thread.sleep(1000);
			Utilities.waitForAllElementVisibilty(originCancelBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(originCancelBTN);
			Utilities.moveToElementAndEnter(originTXT, origin);
			Thread.sleep(1000);
			Utilities.keyPress(Keys.ENTER, 1);
			Utilities.moveToElementAndEnter(destinationTXT, destination);
			Thread.sleep(1000);
			Utilities.keyPress(Keys.ENTER, 1);
			reportLog.logPass("Select Origin and Destination for Round Trip :  ", origin + " => " + destination);
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting the Origin and Destination");
			throw new Exception("Error While selecting the Origin and Destination");
		}
	}

	public void oneWayTripMethod(String origin, String destination) throws Throwable {

		try {

			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(swapHorizBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(swapHorizBTN);
			Thread.sleep(3000);
			Utilities.jsCLick(oneWayRadioBTN);
			Utilities.waitForAllElementVisibilty(flightTakeOffImg, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(flightTakeOffImg);
			Utilities.waitForAllElementVisibilty(originCancelBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(originCancelBTN);
			Utilities.moveToElementAndEnter(originTXT, origin);
			Thread.sleep(1000);
			Utilities.keyPress(Keys.ENTER, 1);
			Utilities.moveToElementAndEnter(destinationTXT, destination);
			Thread.sleep(1000);
			Utilities.keyPress(Keys.ENTER, 1);
			reportLog.logPass("Select Origin and Destination for One Way Trip :  ", origin + " => " + destination);
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting the Origin and Destination");
			throw new Exception("Error While selecting the Origin and Destination");
		}
	}

	public void multiCityMethod(String origin, String destination) throws Throwable {

		try {

			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(swapHorizBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(swapHorizBTN);
			Thread.sleep(3000);
			Utilities.jsCLick(mcBTN);
			Utilities.waitForAllElementVisibilty(flightTakeOffMC1Img, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollDown();
			Utilities.jsCLick(flightTakeOffMC1Img);
			Utilities.waitForAllElementVisibilty(originCancelBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(originCancelBTN);
			Utilities.moveToElementAndEnter(originMC1TXT, origin);
			reportLog.logPass("Origin : ", origin + " is selected ");
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Utilities.moveToElementAndEnter(destinationMC1TXT, destination);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Destination : ", destination + " is selected ");

			Utilities.moveToElementAndEnter(originTXT, destination);
			reportLog.logPass("Origin : ", destination + " is selected ");
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Utilities.moveToElementAndEnter(destinationTXT, origin);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Destination : ", origin + " is selected ");
		} catch (Exception e) {
			reportLog.logFail("Error", "While selecting the Origin and Destination");
			throw new Exception("Error While selecting the Origin and Destination");
		}

	}

	public void addPassenger() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(passengerArrowBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(passengerArrowBTN);
			Utilities.moveToElementAndClick(adultAddBTN);
			Utilities.moveToElementAndClick(childrenAddBTN);
			Utilities.moveToElementAndClick(infantsAddBTN);
			Utilities.moveToElementAndClick(infantOnSeatAddBTN);
			Utilities.moveToElementAndClick(guestRadioBTN);
			Utilities.moveToElementAndClick(passengerConfirmBTN);

			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addAdultsPassenger(int count) throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(passengerArrowBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(passengerArrowBTN);

			for (int i = 1; i < count; i++) {
				Utilities.waitForAllElementVisibilty(adultAddBTN, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(adultAddBTN);
			}

			reportLog.logPass("Add " + count + " Adult Passenger while flight booking");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While adding passenger while booking");
			throw new Exception("Error While adding passenger while booking");
		}

	}

	public void addChildrenPassenger(int count) throws Throwable {
		try {
			for (int i = 1; i <= count; i++) {
				Utilities.waitForAllElementVisibilty(childrenAddBTN, Constants.maxTime, Constants.poolingTime);
				// Utilities.scrollToElement(childrenAddBTN);
				Utilities.jsCLick(childrenAddBTN);

			}

			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addInfantsPassenger(int count) throws Throwable {
		try {
			for (int i = 1; i <= count; i++) {
				Utilities.waitForAllElementVisibilty(infantsAddBTN, Constants.maxTime, Constants.poolingTime);
				// Utilities.scrollToElement(infantsAddBTN);
				Utilities.jsCLick(infantsAddBTN);

			}

			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addIOSPassenger(int count) throws Throwable {
		try {
			for (int i = 1; i <= count; i++) {
				Utilities.waitForAllElementVisibilty(infantOnSeatAddBTN, Constants.maxTime, Constants.poolingTime);
				// Utilities.scrollToElement(infantOnSeatAddBTN);
				Utilities.jsCLick(infantOnSeatAddBTN);
			}

			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void selectGuestClass() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(passengerConfirmBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(guestRadioBTN);
			Utilities.moveToElementAndClick(passengerConfirmBTN);
			reportLog.logPass("Select Guest class while booking");
		} catch (Exception e) {
			e.printStackTrace();
			// reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While Selecting Guest class");
		}

	}

	public void selectBusinessClass() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(guestBusinessBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(guestBusinessBTN);
			Utilities.moveToElementAndClick(passengerConfirmBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void selectFirstClass() throws Throwable {
		try {

			Utilities.waitForAllElementVisibilty(guestFirstBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(guestFirstBTN);
			Utilities.moveToElementAndClick(passengerConfirmBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void selectjourneydatesRT() throws Throwable {

		try {

			Utilities.moveToElementAndClick(calendarDDBTN);
			String departureMonth = "July 2023";
			nxtMonthRTBTN.click();
			System.out.println("selecting the dates for journey");
			Thread.sleep(2000);
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(departDate, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(departDate);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(returnDate);
			Thread.sleep(2000);
			reportLog.logPass("Select Date : ", " From and Return date is selected");
			Thread.sleep(2000);
			System.out.println("clicking on Continue button");
			Utilities.jsCLick(calendarContRTBTN);
			System.out.println("clicking on Search Flights ");
			Utilities.moveToElementAndClick(searchFlightsBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting the dates and search Flights");
			throw new Exception("Error While selecting the dates and search Flights");
		}
	}

	public void selectjourneydatesOW() throws Throwable {

		try {

			Utilities.moveToElementAndClick(calendarDDBTN);
			nxtMonthOWMCBTN.click();
			System.out.println("selecting the dates for journey");
			Thread.sleep(2000);
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(departDate, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(departDate);
			Thread.sleep(2000);
			System.out.println("clicking on Continue button");
			Utilities.jsCLick(calendarContOWBTN);
			System.out.println("clicking on Search Flights ");

			Utilities.moveToElementAndClick(calendarDD2MCBTN);
			nxtMonthOWMC2BTN.click();
			System.out.println("selecting the dates for journey");
			Thread.sleep(2000);
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(mc2ReturnDate, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(mc2ReturnDate);
			Thread.sleep(2000);
			System.out.println("clicking on Continue button");
			Utilities.jsCLick(calendarContMC2BTN);
			System.out.println("clicking on Search Flights ");

			Utilities.moveToElementAndClick(searchFlightsBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting the dates and search Flights");
			throw new Exception("Error While selecting the dates and search Flights");
		}
	}

	public void selectjourneydatesMC() throws Throwable {

		try {

			Utilities.moveToElementAndClick(calendarDDBTN);
			nxtMonthOWMCBTN.click();
			System.out.println("selecting the dates for journey");
			Thread.sleep(2000);
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(departDate, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(departDate);

			Utilities.moveToElementAndClick(calendarDD2MCBTN);
			nxtMonthOWMC2BTN.click();

			Thread.sleep(2000);
			Utilities.moveToElementAndClick(returnDate);
			Thread.sleep(2000);
			reportLog.logPass("Select Date : ", " From and Return date is selected");
			Thread.sleep(2000);
			System.out.println("clicking on Continue button");
			Utilities.jsCLick(calendarContRTBTN);
			System.out.println("clicking on Search Flights ");
			Utilities.moveToElementAndClick(searchFlightsBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting the dates and search Flights");
			throw new Exception("Error While selecting the dates and search Flights");
		}
	}

	public void dontChangeBTNMethod() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(changeYourSelectedCountryPopUp, Constants.maxTime,
					Constants.poolingTime);
			Utilities.moveToElementAndClick(dontChangeBTN);
			reportLog.logPass("Click on 'Don't Change' button in the change selected country Pop-up'");
		} catch (Exception e) {
			throw new Exception("Error While clicking on Don't change button in Change selected country button", e);
		}
	}

	public void selectFareCardRT() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(editSearchBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectBasicFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBasicFlightBTN);
			reportLog.logPass("Depart Flight Search", "has been selected sucessfully");
			Utilities.waitForAllElementVisibilty(selectGuestCard, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectBasicFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBasicFlightBTN);
			reportLog.logPass("Return Flight Search", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting Return Flight Search");
			throw new Exception("Error While selecting Return Flight Search");
		}
	}

	public void selectGuestBasicFareCardOW() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(editSearchBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(selectGuestCard, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectBasicFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBasicFlightBTN);
			reportLog.logPass("Depart Flight Search", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting Return Flight Search");
			throw new Exception("Error While selecting Return Flight Search");
		}
	}

	public void selectBusinessFlexFareCardOW() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(editSearchBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(selectBusinessCard, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBusinessCard);
			Utilities.waitForAllElementVisibilty(selectBusinessFlexFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBusinessFlexFlightBTN);
			reportLog.logPass("Depart Flight Search", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting Return Flight Search");
			throw new Exception("Error While selecting Return Flight Search");
		}
	}

	public void selectGuestSemiFlexFareCardOW() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(editSearchBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(selectGuestCard, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectGuestSemiFlexFlightBTN, Constants.maxTime,
					Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestSemiFlexFlightBTN);
			reportLog.logPass("Depart Flight Search", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting Return Flight Search");
			throw new Exception("Error While selecting Return Flight Search");
		}
	}

	/// this method is copy. Have to write logic
	public void selectFlightDepartReturn() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(editSearchBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectBasicFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBasicFlightBTN);
			reportLog.logPass("Depart Flight Search", "has been selected sucessfully");
			Utilities.waitForAllElementVisibilty(selectGuestCard, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectGuestCard);
			Utilities.waitForAllElementVisibilty(selectBasicFlightBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectBasicFlightBTN);
			reportLog.logPass("Return Flight Search", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While selecting Return Flight Search");
			throw new Exception("Error While selecting Return Flight Search");
		}
	}

	
	// Click on 'Continue to Passenger' button to open Passenger details page
	public void clickContToPassenger() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(contToPssngrBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(contToPssngrBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking to 'Continue to Passenger' button");
		}
	}

	// Select date in Calendar for Multicity flight booking
	public void datepickerCalMC(String monthInput, String dateInput, int index) throws Throwable {
		try {

			Utilities.waitForAllElementVisibilty(listCalendarIconMC(index), Constants.maxTime, Constants.poolingTime);
			// Utilities.scrollToElement(listCalendarIconMC(index));
			if(index >=4 )
			{
				Utilities.scrollDownByPixcels(500);
			}
			
			listCalendarIconMC(index).click();
			String currentmonthtext = listCurrentMonthTitleMC(index).getText().trim();

			if (!listNxtMonthOWMCBTNMC(index).isDisplayed()) {
				listCalendarIconMC(index).click();
			}

			System.out.println("Month on UI :" + currentmonthtext);
			System.out.println("Month in TestData  :" + monthInput);

			while (!currentmonthtext.equalsIgnoreCase(monthInput)) {
				listNxtMonthOWMCBTNMC(index).click();
				currentmonthtext = listCurrentMonthTitleMC(index).getText().trim();
				System.out.println("currentmonthtext " + currentmonthtext);
				Thread.sleep(2000);
			}

			System.out.println("dateMC[1] Size : " + dateMC(index).size());
			// for (int i = 1; i <= dateMC(index).size(); i++) {
			for (int i = 0; i < dateMC(index).size(); i++) {
				String datetxt = dateMC(index).get(i).getText().trim();
				System.out.println("datetxt.trim() ->  " + datetxt.trim());
				if (datetxt.equals(dateInput)) {
					System.out.println("Calender date selected - " + datetxt);
					Utilities.jsCLick(dateMC(index).get(i));
					Utilities.jsCLick(listCalendarContOWBTNMC(index));
					// Utilities.scrollToElement(searchFlightsBTN);
					// Utilities.jsCLick(searchFlightsBTN);
					break;
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw new Exception("Error while selecting date in calendar for Multicity flight booking");
		}
	}

	// Enter data in 'From' and 'To' field and select calendar date for Multicity Flight booking
	public void multiCityMethod(String[] route, List<String> departingMonthDataMC, List<String> departingDateDataMC)
			throws Exception {

		try {
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(swapHorizBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(swapHorizBTN);
			Thread.sleep(3000);
			Utilities.jsCLick(mcRadioBTN);
			Utilities.waitForAllElementVisibilty(flightTakeOffMC1Img, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollDown();
			Utilities.jsCLick(flightTakeOffMC1Img);
			Utilities.waitForAllElementVisibilty(originCancelBTN, Constants.maxTime, Constants.poolingTime);

			// 1st bound - origin
			Utilities.moveToElementAndClick(originCancelBTN);
			Utilities.moveToElementAndEnter(originTXT, route[0]);

			Thread.sleep(2000);
			Utilities.keyPress(Keys.ENTER, 1);

			int noOfBounds = route.length - 1;

			// for remaining bounds
			for (int i = 0; i < noOfBounds; i++) {
				if (i > 1) {
					Utilities.moveToElementAndClick(addFlight);
				}

				Utilities.moveToElementAndEnter(destinationTXT, route[i + 1]);
				Thread.sleep(2000);
				Utilities.keyPress(Keys.ENTER, 1);
				reportLog.logPass(" Select Origin and Destination for Bound no.  " + (i + 1) + " : ",
						route[i] + " -> " + route[i + 1]);

				Thread.sleep(1000);
				datepickerCalMC(departingMonthDataMC.get(i), departingDateDataMC.get(i), i + 1);
				reportLog.logPass("Select Departure Date for Bound no.  " + (i + 1) + " : ",
						departingDateDataMC.get(i) + " " + departingMonthDataMC.get(i));

			}

		} catch (Throwable t) {
			t.printStackTrace();
			throw new Exception(
					"Error while Entering data in From and To field/ calendar while booking Multicity flight");
		}

	}

	// Click on 'Search Flight' button in Home page
	public void clickSearchFlightsBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(searchFlightsBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollDownByPixcels(100);
			Utilities.jsCLick(searchFlightsBTN);
			reportLog.logPass("Click on the 'Search Flights' button");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Search Flights button");
		}
	}

	// Expand Passenger and class dropdown before changing flight class or Passenger
	public void expandPassengerandClassDropdown() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(passengerArrowBTN, Constants.maxTime, Constants.poolingTime);
			if (inActivePassengerAndClassDropDown.isDisplayed()) {
				Thread.sleep(2000);
				Utilities.jsCLick(passengerAndClassDropDown);
				reportLog.logPass("Expand Continue to 'Passenger and class' dropdown");
			} else {
				reportLog.logPass("Continue to 'Passenger and class' dropdown is already expanded");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Expanding Continue to 'Passenger and class' dropdown", e);
		}
	}

	// Select FareCard[Guest, Business, First] Class on Home Page
	public void selectFareCardClass(String fareCardclass) throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(FareCardRadioSelection(fareCardclass), Constants.maxTime,
					Constants.poolingTime);
			Utilities.moveToElementAndClick(FareCardRadioSelection(fareCardclass));
			Utilities.moveToElementAndClick(passengerConfirmBTN);
			reportLog.logPass("Select " + fareCardclass + " FareCard on Home");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting farecard on Home page");
		}
	}

	//Handle flexible date selector pop coming for international routes RT
	public void handleFlexibleDateSelector() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(flexibleDatePopUpHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(selctedCell);
			Utilities.moveToElementAndClick(flexibleDatePopUpconfirmBTN);
			reportLog.logPass("Select highlighted cell in flexible date popup");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While select highlighted cell in flexible date popup");
		}
	}
	
	// Click on saudia logo to open home page
	public void clickOnSaudiaLogo() throws Exception {
		try {
			/*
			 * if (Utilities.verifyElementPresent(chooseCounrtBTN) == false) { }
			 */

			Utilities.waitForAllElementVisibilty(saudiaLogo, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(saudiaLogo);
			// Utilities.waitForAllElementVisibilty(chooseCounrtBTN, Constants.maxTime,
			// Constants.poolingTime);
			Utilities.waitForTextToBePresentInElement(loginBTN, LayoutHeader.HomePage_LoginBTN, Constants.highLoadTime,
					Constants.poolingTime_Min);
			reportLog.logPass("Click on Saudia Logo to go to Home Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Saudia Logo");
		}
	}

	// Click on MMB in home page and search for PNR
	public void searchPNRinMMBTab(String PNR, String lastName) throws Exception {
		try {

			Utilities.waitForAllElementVisibilty(MMBTab, Constants.highLoadTime, Constants.poolingTime);
			Utilities.clickWebElement(MMBTab);
			Utilities.waitForAllElementVisibilty(bookingReferenceRadioMMB, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(bookingReferenceRadioMMB);
			Utilities.waitForAllElementVisibilty(bookingReferenceRadioMMB, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(bookingReferenceRadioMMB);
			Utilities.moveToElementAndEnter(bookingReferenceInputMMB, PNR);
			Utilities.moveToElementAndEnter(lastNameInputMMB, lastName);
			Utilities.jsCLick(continueBTNMMB);

			reportLog.logPass("Search PNR in MMB tab on Home Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Searching PNR in MMB tab on Home Page");
		}
	}

	// Click on CheckIn in home page and search for PNR
	public void searchPNRinCheckINTab(String PNR, String lastName) throws Exception {
		try {

			Utilities.waitForAllElementVisibilty(checkInTab, Constants.highLoadTime, Constants.poolingTime);
			Utilities.jsCLick(checkInTab);
			
			if(Utilities.getAttributeValueOfElement(checkInTab,"aria-selected") != "true")
			{
				Utilities.jsCLick(checkInTab);
			}
			
			Utilities.waitForAllElementVisibilty(bookingReferenceRadioMMB, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(bookingReferenceRadioMMB);
			Utilities.waitForAllElementVisibilty(bookingReferenceRadioMMB, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(bookingReferenceRadioMMB);
			Utilities.moveToElementAndEnter(bookingReferenceInputMMB, PNR);
			Utilities.moveToElementAndEnter(lastNameInputMMB, lastName);
			Utilities.jsCLick(checkInBTNMMB);

			reportLog.logPass("Search PNR in CheckIn tab on Home Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Search PNR in CheckIn tab on Home Page");
		}
	}

}