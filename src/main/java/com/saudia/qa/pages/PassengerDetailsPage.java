package com.saudia.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class PassengerDetailsPage extends TestBase {

	private static Logger Log = Logger.getLogger(PassengerDetailsPage.class);
	private ReportLog reportLog;

	@FindBy(xpath = "//*[@class='passenger-information']")
	public WebElement pssngrInfoTitle;
	
	@FindBy(xpath = "//*[text()=' Passenger details ']")
	public WebElement pssngrDetailsTitle;

	@FindBy(xpath = "//*[@class='control-wrapper passenger-title-input']//span[text()=' expand_more ']")
	public WebElement titleExpandArraw;

	@FindBy(xpath = "(//*[@class='control-wrapper passenger-title-input']//span[text()=' expand_more '])[2]")
	public WebElement titleExpandArraw2;

	@FindBy(xpath = "//button[text()='Edit search ']")
	public WebElement editSearchBTN;

	@FindBy(xpath = "//*[text()='First name']")
	public WebElement firstNameInput;

	@FindBy(xpath = "(//*[text()='First name'])[2]")
	public WebElement firstNameInput2;

	@FindBy(xpath = "//*[text()='Last name']")
	public WebElement lastNameInput;

	@FindBy(xpath = "(//*[text()='Last name'])[2]")
	public WebElement lastNameInput2;

	@FindBy(xpath = "//*[@aria-label='Date of birth']")
	public WebElement dobInput;

	@FindBy(xpath = "(//*[@aria-label='Date of birth'])[2]")
	public WebElement dobInput2;

	@FindBy(xpath = "//*[@aria-label='Nationality']")
	public WebElement nationalityInput;

	@FindBy(xpath = "//*[@aria-label='Nationality']")
	public WebElement nationalityInput2;

	@FindBy(xpath="(//mat-option[@role='option'])[1]")
	public WebElement dropdownOption;
	
	@FindBy(xpath = "//*[@formcontrolname='passportNumber']")
	public WebElement passportNumInput;

	@FindBy(xpath = "//*[@aria-label='Expiry date']")
	public WebElement expiryDOBInput;

	@FindBy(xpath = "//*[@aria-label='Issuing country/territory']")
	public WebElement issuingCountryInput;

	@FindBy(xpath = "//*[@aria-label='Continue']")
	public WebElement verifyingDetailsContBTN;

	@FindBy(xpath = "//*[@aria-label='Add special needs']")
	public WebElement addSplNeedsBTN;

	@FindBy(xpath = "//*[text()='Deaf passenger ']//parent::span/preceding-sibling::span//input")
	public WebElement deafPasngrCHKBOX;

	@FindBy(xpath = "//*[text()='Meet and assist']//parent::span/preceding-sibling::span//input")
	public WebElement meetAndAssistCHKBOX;

	@FindBy(xpath = "//*[text()='Wheelchair for steps']//parent::span/preceding-sibling::span//input")
	public WebElement wheelChairForStepsCHKBOX;

	@FindBy(xpath = "//*[text()='Confirm']")
	public WebElement confirmBTN;

	@FindBy(xpath = "//*[text()=' Confirm ']")
	public WebElement adultDetailsConfirmBTN;

	@FindBy(xpath = "//*[@aria-label='Country/Territory code']")
	public WebElement contactDetailtsCountryInput;

	@FindBy(xpath = "//*[@formcontrolname='phoneNumber']")
	public WebElement phoneNumInput;

	@FindBy(xpath = "//*[@formcontrolname='emailAddress']")
	public WebElement emailAddrInput;

	@FindBy(xpath = "//span[@class='selectaddons']")
	//@FindBy(xpath = "//span[text()='Select seats ']")
	public WebElement selectSeatsBTN;

	@FindBy(xpath = "//*[@class='complete-icon']")
	public WebElement adult1CompleteIcon;

	@FindBy(xpath = "//*[contains(@class,'passenger-frequent-flyer')]//span[text()=' expand_more ']")
	public WebElement ffProgramDDArrow;

	@FindBy(xpath = "//*[@formcontrolname='loyaltyNumber']")
	public WebElement ffNumINPUT;

	@FindBy(xpath = "//*[@formcontrolname='mealPreference']//parent::div//following-sibling::div//span[text()=' expand_more ']")
	public WebElement mealPrefDDArraow;

	@FindBy(xpath = "(//*[text()=' Next passenger '])[1]")
	public WebElement nxtPassengerBTN;

	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[1]")
	public WebElement adultfirstNameInput;
	
	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[2]")
	public WebElement iNSadultfirstNameInput;
	
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[1]")
	public WebElement adultLasttNameInput;
	
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[2]")
	public WebElement iNSadultLastNameInput;
	
	@FindBy(xpath = "(//*[@placeholder='DD/MM/YYYY'])[1]")
	public WebElement adultDOBInput;
	
	@FindBy(xpath = "(//*[@placeholder='DD/MM/YYYY'])[2]")
	public WebElement iNSadultDOBInput;
	
	@FindBy(xpath = "(//*[@aria-label='Nationality'])[1]")
	public WebElement adultNationationnput;
	
	@FindBy(xpath = "(//*[@aria-label='Nationality'])[2]")
	public WebElement iNSadultNationationnput;
	
	@FindBy(xpath = "(//*[@formcontrolname='passportNumber'])[1]")
	public WebElement adultPassportNumInput;
	
	@FindBy(xpath = "(//*[@formcontrolname='passportNumber'])[2]")
	public WebElement iNSadultPassportNumInput;
	
	@FindBy(xpath = "(//*[@aria-label='Expiry date'])[1]")
	public WebElement adultExpiryDateInput;
	
	@FindBy(xpath = "(//*[@aria-label='Expiry date'])[2]")
	public WebElement iNSadultExpiryDateInput;
	
	@FindBy(xpath = "(//*[@aria-label='Issuing country/territory'])[1]")
	public WebElement adultIssuingCountryInput;
	
	@FindBy(xpath = "(//*[@aria-label='Issuing country/territory'])[2]")
	public WebElement iNSadultIssuingCountryInput;
	
	@FindBy(xpath = "(//*[text()=' calendar_today '])")
	public WebElement calendarDOBICON;
	
	@FindBy(xpath = "(//*[text()=' calendar_today '])[2]")
	public WebElement calendarexpiryICON;
	
	@FindBy(xpath = "(//*[text()=' calendar_today '])[3]")
	public WebElement calendarINSDOBICON;
	
	@FindBy(xpath = "(//*[text()=' calendar_today '])[4]")
	public WebElement calendarINSexpiryICON;
	
	@FindBy(xpath = "//*[@aria-label='Choose month and year']")
	public WebElement selectMonthAndYear;
	
	@FindBy(xpath = "//*[text()='Hijri Calendar']//ancestor::div//span[text()=' Confirm ']")
	public WebElement calendarDOBConfirmBTN;
	
	@FindBy(xpath = "(//*[text()=' Next passenger '])[2]")
	public WebElement nxtPassengerChildBTN;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='pregress-stepper']//div[contains(@class,'active')]//span[text()='Passenger']")
	public WebElement passengerTab;
	
	@CacheLookup
	@FindBy(xpath="//h2[text()='Contact details']")
	public WebElement contactDetailsHeading;
	
	public WebElement infantTitleExpandArrow() {
		return Utilities.driver.findElement(By.xpath("(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[text()=' expand_more '])[1]"));
	}

	public WebElement childTitleExpandArrow() {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Child')]//parent::div//following-sibling::div//span[text()=' expand_more '])[1]"));
	}
	
	public WebElement titleExpandArraw2(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[@class='control-wrapper passenger-title-input']//span[text()=' expand_more '])[" + index + "]"));
	}

	public WebElement firstNameInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[text()='First name'])[" + index + "]"));
	}

	
	
	public WebElement lastNameInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[text()='Last name'])[" + index + "]"));
	}

	public WebElement dobInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[@aria-label='Date of birth'])[" + index + "]"));
	}

	public WebElement nationalInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[@aria-label='Nationality'])[" + index + "]"));
	}

	public WebElement passportNumInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[@formcontrolname='passportNumber'])[" + index + "]"));
	}

	public WebElement docTypeTitle(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[text()=' Document Type '])[" + index + "]"));
	}
	
	public WebElement expiryDate2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[@aria-label='Expiry date'])[" + index + "]"));
	}

	public WebElement issuingCountryInput2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[@aria-label='Issuing country/territory'])[" + index + "]"));
	}

	public WebElement nxtPassengerBTN2(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[text()=' Next passenger '])[" + index + "]"));
	}

	public WebElement infantTitleExpandArrow(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[text()=' expand_more '])["
						+ index + "]"));
	}

	public WebElement infantFirstNameInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[@formcontrolname='firstName'])["
						+ index + "]"));
	}

	public WebElement infantLastNameInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[@formcontrolname='lastName'])["
						+ index + "]"));
	}

	public WebElement infantDOBInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[@aria-label='Date of birth'])["
						+ index + "]"));
	}

	public WebElement infantNationalityInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Infant on-lap details '][1]//parent::div//following-sibling::div//*[@aria-label='Nationality'])["
						+ index + "]"));
	}

	public WebElement infantPassportNumInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Document details (infant) '][1]//parent::div//following-sibling::div//*[@formcontrolname='passportNumber'])["
						+ index + "]"));
	}

	public WebElement infantExpiryDateInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Document details (infant) '][1]//parent::div//following-sibling::div//*[@aria-label='Expiry date'])["
						+ index + "]"));
	}

	public WebElement infantIssuingCountryInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[text()=' Document details (infant) '][1]//parent::div//following-sibling::div//*[@aria-label='Issuing country/territory'])["
						+ index + "]"));
	}

	public WebElement childTitleExpandArrow(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//span[text()=' expand_more '])["
						+ index + "]"));
	}

	public WebElement childFirstNameInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//*[@formcontrolname='firstName'])["
						+ index + "]"));
	}

	public WebElement childLastNameInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//*[@formcontrolname='lastName'])["
						+ index + "]"));
	}

	public WebElement childDOBInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//*[@aria-label='Date of birth'])["
						+ index + "]"));
	}

	public WebElement childNationalityInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//*[@aria-label='Nationality'])["
						+ index + "]"));
	}

	public WebElement childPassportNumInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//input[@formcontrolname='passportNumber'])["
						+ index + "]"));
	}

	public WebElement childExpiryDateInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//input[@aria-label='Expiry date'])["
						+ index + "]"));
	}

	public WebElement childIssuingCountryInput(int index) {
		return Utilities.driver.findElement(By.xpath(
				"(//*[contains(text(),' Child')]//parent::div//following-sibling::div//input[@aria-label='Issuing country/territory'])["
						+ index + "]"));
	}

	public WebElement iNSTitleExpandArrow(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//*[text()=' expand_more '])["
						+ index + "]"));
	}

	public WebElement iNSFirstNameInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//*[@formcontrolname='firstName'])["
						+ index + "]"));
	}

	public WebElement iNSLastNameInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//*[@formcontrolname='lastName'])["
						+ index + "]"));
	}

	public WebElement iNSDOBInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//*[@aria-label='Date of birth'])["
						+ index + "]"));
	}

	public WebElement iNSNationalityInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//*[@aria-label='Nationality'])["
						+ index + "]"));
	}

	public WebElement iNSPassportNumInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//input[@formcontrolname='passportNumber'])["
						+ index + "]"));
	}

	public WebElement iNSExpiryDateInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//input[@aria-label='Expiry date'])["
						+ index + "]"));
	}

	public WebElement iNSIssuingCountryInput(int index) {
		return Utilities.driver.findElement(By.xpath("(//*[contains(text(),' Infant on Seat')]//parent::div//following-sibling::div//input[@aria-label='Issuing country/territory'])["
						+ index + "]"));
	}
//	https://www.saudia.com/en-SA/booking/passengerDetails

	public PassengerDetailsPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}
	
	public void addPassengerDetails(String title, String firstName, String lastName, String birthdayDate,
			String nationality, String passportNumber, String passportExpiryDate, String passportIssuingCountry)
			throws Throwable {
		try {
			String ddxpath = "//*[@role='listbox']//span";
			Utilities.waitForAllElementVisibilty(pssngrInfoTitle, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(titleExpandArraw);
			Utilities.clickDD(ddxpath, title);
			Utilities.moveToElementAndEnter(firstNameInput, firstName);
			Utilities.moveToElementAndEnter(lastNameInput, lastName);
			Utilities.DoubleClick(dobInput);
			Utilities.setText(dobInput, birthdayDate);
			// Utilities.moveToElementAndClick(nationalityInput);
			Utilities.moveToElementAndEnter(nationalityInput, nationality);
			Utilities.jsCLick(dropdownOption);
			Utilities.moveToElementAndEnter(passportNumInput, passportNumber);
			Utilities.DoubleClick(expiryDOBInput);
			Utilities.setText(expiryDOBInput, passportExpiryDate);
			Utilities.moveToElementAndEnter(issuingCountryInput, passportIssuingCountry);
			Utilities.jsCLick(dropdownOption);
			Utilities.moveToElementAndClick(adultDetailsConfirmBTN);

			// WebElement element =
			// Utilities.waitForElementVisibiltyToCheckElementPresent(verifyingDetailsContBTN,
			// Constants.minTime, Constants.poolingTime);
			// System.out.println("element -----------" + element);
			// ----------------Bug--------------------------/
			if (Utilities.verifyElementPresent(verifyingDetailsContBTN)) {
				Utilities.moveToElementAndClick(verifyingDetailsContBTN);
			}
			Utilities.waitForAllElementVisibilty(adult1CompleteIcon, Constants.maxTime, Constants.poolingTime);

			// make a separate method for adding special needs to be added later for special
			// needs
			/*
			 * Utilities.moveToElementAndClick(addSplNeedsBTN);
			 * Utilities.moveToElementAndClick(deafPasngrCHKBOX);
			 * Utilities.moveToElementAndClick(meetAndAssistCHKBOX);
			 * Utilities.moveToElementAndClick(wheelChairForStepsCHKBOX);
			 * Utilities.moveToElementAndClick(confirmBTN);
			 */
			// Thread.sleep(2000);
			reportLog.logPass("Add passenger details in 'Passenger page'");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While adding passenger details in 'Passenger page'");
			throw new Exception("Error While adding passenger details in 'Passenger page'");
		}

	}

	public void addAdult1PassengerDetails(int i) throws Throwable {
		try {

			String ddxpath = "//*[@role='listbox']//span";
			Utilities.waitForAllElementVisibilty(titleExpandArraw2(i), Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(titleExpandArraw2(i));
			Utilities.clickDD(ddxpath, "Mrs");
			Utilities.moveToElementAndEnter(firstNameInput2(i), "Banu" + Utilities.gendricRandomString(3));
			Utilities.moveToElementAndEnter(lastNameInput2(i), "Sekar" + Utilities.gendricRandomString(3));
			Utilities.DoubleClick(dobInput2(i));
			Utilities.setText(dobInput2(i), "18061994");
			// Utilities.moveToElementAndClick(nationalityInput);
			Utilities.moveToElementAndEnter(nationalInput2(i), "India");
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			Utilities.moveToElementAndEnter(passportNumInput2(i), "R65" + Utilities.gendricRandomInteger(3));
			Utilities.DoubleClick(expiryDate2(i));
			Utilities.setText(expiryDate2(i), "13062025");
			Utilities.moveToElementAndEnter(issuingCountryInput2(i), "India");
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addAdultAndInfantPassengerDetails(int i) throws Throwable {
		try {

			String ddxpath = "//*[@role='listbox']//span";
			Utilities.waitForAllElementVisibilty(titleExpandArraw2(i), Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(titleExpandArraw2(i));
			Utilities.clickDD(ddxpath, "Mrs");
	//		Utilities.moveToElementAndEnter(firstNameInput2(i), "Banu" + Utilities.gendricRandomString(3));
	//		Utilities.moveToElementAndEnter(lastNameInput2(i), "Sekar" + Utilities.gendricRandomString(3));
			Utilities.moveToElementAndEnter(adultfirstNameInput, "Banu" + Utilities.gendricRandomString(2));
			Utilities.moveToElementAndEnter(adultLasttNameInput, "Sekar" + Utilities.gendricRandomString(2));
			//addomg adult dob
			if (i==1) {
				addingAdultDOB(1);	
			} else {
				addingAdultDOBmorethan1(2);
			}
			
		//	Utilities.waitForAllElementVisibilty(adultNationationnput, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndEnter(adultNationationnput, "India");
			selectingCountryRobotMethod();
			Utilities.moveToElementAndEnter(adultPassportNumInput, "R65" + Utilities.gendricRandomInteger(3));
			addingAdultExpiryDate(1); 		 // Selecting Adult Expiry date
			Utilities.moveToElementAndEnter(adultIssuingCountryInput, "India");
			selectingCountryRobotMethod();
			reportLog.logPass("Adult Details", "has been entered");
			Thread.sleep(1000);
			Utilities.scrollToElementView(infantTitleExpandArrow());
	//		Utilities.waitForAllElementVisibilty(infantTitleExpandArrow(), Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(infantTitleExpandArrow());
			Utilities.clickDD(ddxpath, "Miss");
		//	Utilities.moveToElementAndEnter(infantFirstNameInput(i), "Kavin" + Utilities.gendricRandomString(3));
		//	Utilities.moveToElementAndEnter(infantLastNameInput(i), "VB" + Utilities.gendricRandomString(3));
			Utilities.moveToElementAndEnter(iNSadultfirstNameInput, "Kavin" + Utilities.gendricRandomString(2));
			Utilities.moveToElementAndEnter(iNSadultLastNameInput, "VB" + Utilities.gendricRandomString(2));
			// Selecting infant DOB
			if (i==1) {
				addingINSDOB(1); 	
			} else {
				addingINSDOBmorethan1(); 
			}
			
			
   			Utilities.moveToElementAndEnter(iNSadultNationationnput, "India");
			selectingCountryRobotMethod();
			Utilities.moveToElementAndEnter(iNSadultPassportNumInput, "R65" + Utilities.gendricRandomInteger(3));
		//	addingINSExpiryDate(1); // Selecting infant Expiry date
			if (i==1) {
				addingINSExpiryDate(1); 	
			} else {
				addingINSExpiryDateMoreThan1(); 
			}
			
			Utilities.moveToElementAndEnter(iNSadultIssuingCountryInput, "India");
			selectingCountryRobotMethod();
			reportLog.logPass("Infant Details", "has been entered");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void selectingCountryRobotMethod() throws Throwable {
		try {
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingAdultDOB(int i) throws Throwable {
		try {
			boolean enabled = calendarDOBICON.isEnabled();
			System.out.println(enabled);
			Thread.sleep(2000);
		//	Utilities.waitForAllElementVisibilty(calendarDOBICON, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElementView(calendarDOBICON);
			Thread.sleep(1000);
	//		Utilities.waitForAllElementVisibilty(calendarDOBICON, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(calendarDOBICON);
				Thread.sleep(2000);
		//		Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(selectMonthAndYear);
				String calendarInput = "//*[@class='mat-calendar-body']//span//span";
				Utilities.clickDD(calendarInput, "1994");
				Thread.sleep(1000);
				Utilities.clickDD(calendarInput, "May");
				Thread.sleep(1000);
				String dateInput = "//*[@class='mat-calendar-body']//td//div[1]";
				Utilities.clickDD(dateInput, "20");
				Thread.sleep(2000);
			//	Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
				Utilities.scrollToElementView(calendarDOBConfirmBTN);
				Utilities.jsCLick(calendarDOBConfirmBTN);
			

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingAdultDOBmorethan1(int i) throws Throwable {
		try {
			boolean enabled = calendarDOBICON.isEnabled();
			System.out.println(enabled);
			Thread.sleep(2000);
		//	Utilities.waitForAllElementVisibilty(calendarDOBICON, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElementView(calendarDOBICON);
			Thread.sleep(1000);
	//		Utilities.waitForAllElementVisibilty(calendarDOBICON, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(calendarDOBICON);
				Utilities.scrollDown();
				Thread.sleep(2000);
		//		Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(selectMonthAndYear);
				String calendarInput = "//*[@class='mat-calendar-body']//span//span";
				Utilities.clickDD(calendarInput, "1994");
				Thread.sleep(1000);
				Utilities.clickDD(calendarInput, "May");
				Thread.sleep(1000);
				String dateInput = "//*[@class='mat-calendar-body']//td//div[1]";
				Utilities.clickDD(dateInput, "20");
				Thread.sleep(2000);
			//	Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
				Utilities.scrollToElementView(calendarDOBConfirmBTN);
				Utilities.jsCLick(calendarDOBConfirmBTN);
			

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingAdultExpiryDate(int i) throws Throwable {
		try {
			Utilities.scrollToElementView(calendarexpiryICON);
		//	Utilities.waitForAllElementVisibilty(calendarexpiryICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(calendarexpiryICON);
		//	Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(selectMonthAndYear);
			String calendarInput = "//*[@class='mat-calendar-body']//span//span";
			Utilities.clickDD(calendarInput, "2025");
			Thread.sleep(1000);
			Utilities.clickDD(calendarInput, "Dec");
			Thread.sleep(1000);
			String expiryDateInput = "//*[@class='mat-calendar-body']//td//div[1]";
			Utilities.clickDD(expiryDateInput, "20");
			//Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.scrollToElementView(calendarDOBConfirmBTN);
			Utilities.jsCLick(calendarDOBConfirmBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingINSDOB(int i) throws Throwable {
		try {

			Utilities.scrollToElementView(calendarINSDOBICON);
		//	Utilities.waitForAllElementVisibilty(calendarINSDOBICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
				Utilities.moveToElementAndClick(calendarINSDOBICON);
		//		Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
				Thread.sleep(2000);
				Utilities.moveToElementAndClick(selectMonthAndYear);
				Thread.sleep(2000);
				String calendarInput = "//*[@class='mat-calendar-body']//span//span";
				Utilities.clickDD(calendarInput, "2022");
				Thread.sleep(1000);
				Utilities.clickDD(calendarInput, "May");
				Thread.sleep(1000);
				String dateInput = "//*[@class='mat-calendar-body']//td//div[1]";
				Utilities.clickDD(dateInput, "20");
		//		Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
				Thread.sleep(2000);
				Utilities.scrollToElementView(calendarDOBConfirmBTN);
				Utilities.jsCLick(calendarDOBConfirmBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingINSDOBMoreThanOne(int i) throws Throwable {
		try {

			Utilities.scrollToElementView(calendarINSDOBICON);
		//	Utilities.waitForAllElementVisibilty(calendarINSDOBICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
				Utilities.moveToElementAndClick(calendarINSDOBICON);
		//		Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
				Thread.sleep(2000);
				Utilities.moveToElementAndClick(selectMonthAndYear);
				Utilities.scrollDown();
				Thread.sleep(2000);
				String calendarInput = "//*[@class='mat-calendar-body']//span//span";
				Utilities.clickDD(calendarInput, "2022");
				Thread.sleep(1000);
				Utilities.clickDD(calendarInput, "May");
				Thread.sleep(1000);
				String dateInput = "//*[@class='mat-calendar-body']//td//div[1]";
				Utilities.clickDD(dateInput, "20");
		//		Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
				Thread.sleep(2000);
				Utilities.scrollToElementView(calendarDOBConfirmBTN);
				Utilities.jsCLick(calendarDOBConfirmBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingINSDOBmorethan1() throws Throwable {
		try {

			Utilities.scrollToElementView(calendarINSDOBICON);
		//	Utilities.waitForAllElementVisibilty(calendarINSDOBICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
				Utilities.moveToElementAndClick(calendarINSDOBICON);
		//		Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
				Utilities.scrollDown();
				Thread.sleep(2000);
				Utilities.moveToElementAndClick(selectMonthAndYear);
				Thread.sleep(2000);
				String calendarInput = "//*[@class='mat-calendar-body']//span//span";
				Utilities.clickDD(calendarInput, "2022");
				Thread.sleep(1000);
				Utilities.clickDD(calendarInput, "May");
				Thread.sleep(1000);
				String dateInput = "//*[@class='mat-calendar-body']//td//div[1]";
				Utilities.clickDD(dateInput, "20");
		//		Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
				Thread.sleep(2000);
				Utilities.scrollToElementView(calendarDOBConfirmBTN);
				Utilities.jsCLick(calendarDOBConfirmBTN);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingINSExpiryDate(int i) throws Throwable {
		try {

			Utilities.scrollToElementView(calendarINSexpiryICON);
		//	Utilities.waitForAllElementVisibilty(calendarINSexpiryICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(calendarINSexpiryICON);
		//	Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(selectMonthAndYear);
			String calendarInput = "//*[@class='mat-calendar-body']//span//span";
			Utilities.clickDD(calendarInput, "2025");
			Thread.sleep(1000);
			Utilities.clickDD(calendarInput, "Dec");
			Thread.sleep(1000);
			String expiryDateInput = "//*[@class='mat-calendar-body']//td//div[1]";
			Utilities.clickDD(expiryDateInput, "20");
	//		Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.scrollToElementView(calendarDOBConfirmBTN);
			Utilities.jsCLick(calendarDOBConfirmBTN);
			

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addingINSExpiryDateMoreThan1() throws Throwable {
		try {

			Utilities.scrollToElementView(calendarINSexpiryICON);
		//	Utilities.waitForAllElementVisibilty(calendarINSexpiryICON, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(calendarINSexpiryICON);
		//	Utilities.waitForAllElementVisibilty(selectMonthAndYear, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollDown();
			Thread.sleep(2000);
			Utilities.moveToElementAndClick(selectMonthAndYear);
			String calendarInput = "//*[@class='mat-calendar-body']//span//span";
			Utilities.clickDD(calendarInput, "2025");
			Thread.sleep(1000);
			Utilities.clickDD(calendarInput, "Dec");
			Thread.sleep(1000);
			String expiryDateInput = "//*[@class='mat-calendar-body']//td//div[1]";
			Utilities.clickDD(expiryDateInput, "20");
	//		Utilities.waitForAllElementVisibilty(calendarDOBConfirmBTN, Constants.maxTime, Constants.poolingTime);
			Thread.sleep(2000);
			Utilities.scrollToElementView(calendarDOBConfirmBTN);
			Utilities.jsCLick(calendarDOBConfirmBTN);
			
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	public void addChildPassengerDetails(int i) throws Throwable {
		try {

			String ddxpath = "//*[@role='listbox']//span";
		//	Utilities.waitForAllElementVisibilty(childTitleExpandArrow(), Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(childTitleExpandArrow());
			Utilities.clickDD(ddxpath, "Miss");
			Utilities.moveToElementAndEnter(childFirstNameInput(i), "Banu" + Utilities.gendricRandomString(3));
			Utilities.moveToElementAndEnter(childLastNameInput(i), "Sekar" + Utilities.gendricRandomString(3));
			Utilities.DoubleClick(childDOBInput(i));
			Utilities.setText(childDOBInput(i), "18062016");
			// Utilities.moveToElementAndClick(nationalityInput);
			Utilities.moveToElementAndEnter(childNationalityInput(i), "India");
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			Utilities.moveToElementAndEnter(childPassportNumInput(i), "R65" + Utilities.gendricRandomInteger(3));
			Utilities.DoubleClick(childExpiryDateInput(i));
			Utilities.setText(childExpiryDateInput(i), "13062025");
			Utilities.moveToElementAndEnter(childIssuingCountryInput(i), "India");
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Adult Details", "has been entered");
			
	
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addINSDetails(int i) throws Throwable {
		try {

			String ddxpath = "//*[@role='listbox']//span";
			Utilities.waitForAllElementVisibilty(iNSTitleExpandArrow(i), Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(iNSTitleExpandArrow(i));
			Utilities.clickDD(ddxpath, "Miss");
			Utilities.moveToElementAndEnter(iNSFirstNameInput(i), "Banu" + Utilities.gendricRandomString(3));
			Utilities.moveToElementAndEnter(iNSLastNameInput(i), "Sekar" + Utilities.gendricRandomString(3));
			Utilities.DoubleClick(iNSDOBInput(i));
			Utilities.setText(iNSDOBInput(i), "18062023");
			// Utilities.moveToElementAndClick(nationalityInput);
			Utilities.moveToElementAndEnter(iNSNationalityInput(i), "India");
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			Utilities.moveToElementAndEnter(iNSPassportNumInput(i), "R65" + Utilities.gendricRandomInteger(3));
			Utilities.DoubleClick(iNSExpiryDateInput(i));
			Utilities.setText(iNSExpiryDateInput(i), "13062025");
			Utilities.moveToElementAndEnter(iNSIssuingCountryInput(i), "India");
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Infant Details", "has been entered");
			
	
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void clickOnNextPassenger(int i) throws Throwable {
		try {
			Utilities.scrollToElementView(nxtPassengerChildBTN);
			Utilities.waitForAllElementVisibilty(nxtPassengerChildBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(nxtPassengerChildBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void clickOnChildNextPassenger() throws Throwable {
		try {
			Thread.sleep(1000);
			Utilities.scrollToElementView(nxtPassengerChildBTN);
			Utilities.moveToElementAndClick(nxtPassengerChildBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	public void verifyingDetailsCont() throws Throwable {
		try {

			Utilities.waitForAllElementVisibilty(verifyingDetailsContBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(verifyingDetailsContBTN);
			Utilities.waitForAllElementVisibilty(adult1CompleteIcon, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addPassengerConfirmBTN() throws Throwable {
		try {

			Utilities.waitForAllElementVisibilty(adultDetailsConfirmBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(adultDetailsConfirmBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void infantOnAdultDetails() throws Throwable {
		try {
			String ddxpath = "//*[@role='listbox']//span";
			Utilities.waitForAllElementVisibilty(pssngrInfoTitle, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(titleExpandArraw);
			Utilities.clickDD(ddxpath, "Mrs");
			Utilities.moveToElementAndEnter(firstNameInput, "Banu");
			Utilities.moveToElementAndEnter(lastNameInput, "Sekar");
			Utilities.DoubleClick(dobInput);
			Utilities.setText(dobInput, "18061994");
			// Utilities.moveToElementAndEnter(dobInput, "18061994");
			Utilities.moveToElementAndClick(nationalityInput);
			Utilities.moveToElementAndEnter(nationalityInput, "India");
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addContactDetails(String countryCode, String phoneNumber, String email) throws Throwable {
		try {
			Utilities.moveToElementAndEnter(contactDetailtsCountryInput, countryCode);
			/*Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);*/
			
			Utilities.jsCLick(dropdownOption);
			Utilities.moveToElementAndEnter(phoneNumInput, phoneNumber);
			Utilities.moveToElementAndEnter(emailAddrInput, email);
			Utilities.waitForAllElementVisibilty(selectSeatsBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectSeatsBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addffProgram(String ffprogram, String ffNum) throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(ffProgramDDArrow, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(ffProgramDDArrow);
			String ddxpath = "//*[@role='option']//span//span";
			Utilities.clickDD(ddxpath, ffprogram);
			Thread.sleep(2000);
			Utilities.moveToElementAndEnter(ffNumINPUT, ffNum);

			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}

	public void addMealPreferences(String mealPreference) throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(mealPrefDDArraow, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(mealPrefDDArraow);
			String ddxpath = "//*[@role='option']//span";
			Utilities.clickDD(ddxpath, mealPreference);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}

	}
	
	//Verify Passenger details page is opened or not
	public void verifyPassengerDetailsPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(contactDetailsHeading, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Passenger details page is opened");
			Utilities.isDisplayed(contactDetailsHeading);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking Passenger details page is opened or not");
		}
	}
}
