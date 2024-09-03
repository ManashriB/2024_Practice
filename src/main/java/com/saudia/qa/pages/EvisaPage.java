package com.saudia.qa.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class EvisaPage extends TestBase {

	private static Logger Log = Logger.getLogger(FlightPage.class);
	private ReportLog reportLog;

	/* Passenger Tab */
	@FindBy(xpath = "//h3[text()='Transit E-Visa application']")
	public WebElement eVisaPageHeading;

	@FindBy(xpath = "//input[@aria-labelledby='agreeandcontinuelabel']")
	public WebElement termsConditionsCheckBox;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement proceedBTN;

	/* Application Tab */
	@FindBy(xpath = "//mat-select[@formcontrolname='maritalStatus']")
	public WebElement maritalStatucDRP;

	@FindBy(xpath = "//mat-option/span[text()='Married']")
	public WebElement marriedOption;

	@FindBy(xpath = "//mat-option/span[text()='Single']")
	public WebElement singleOption;

	@FindBy(xpath = "//input[@formcontrolname='profession']")
	public WebElement profession;

	@FindBy(xpath = "//mat-select[@formcontrolname='religion']")
	public WebElement religionDRP;

	@FindBy(xpath = "//mat-option/span[text()='Islam']")
	public WebElement islamOption;

	@FindBy(xpath = "//mat-option/span[text()='Non-muslim']")
	public WebElement nonMuslimOption;

	@FindBy(xpath = "//mat-option/span[text()='I prefer not to say']")
	public WebElement notToSayOption;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement photoUpload;

	@FindBy(xpath = "//mat-select[@formcontrolname='passportType']")
	public WebElement passportType;

	@FindBy(xpath = "//mat-option[1]")
	public WebElement normalPassport;

	@FindBy(xpath = "//input[@formcontrolname='nationalID']")
	public WebElement nationalId;

	@FindBy(xpath = "//input[@aria-describedby='birthCountry']")
	public WebElement birthCountry;

	@FindBy(xpath = "//input[@formcontrolname='birthCity']")
	public WebElement birthCity;

	@FindBy(xpath = "//input[@aria-describedby='residenceCountry']")
	public WebElement residenceCountry;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement address;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='noForAll']//label//span")
	public WebElement notForAll;

	@FindBy(xpath = "//button[@aria-label='Click here to submit your application']")
	public WebElement submitBTN;
	
	@FindBy(xpath = "//mat-option[1]")
	public WebElement firstOption;

	@FindBy(xpath = "//mat-icon[text()=' calendar_today ']")
	public WebElement issueDate;
	
	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	public WebElement clickChooseDate;
	
	@FindBy(xpath = "//span[text()=' Confirm ']")
	public WebElement confirmBTN;
	
	@FindBy(xpath = "(//span[@class='mat-radio-container'])[1]")
	public WebElement selectFlight;
	
	public WebElement selectYear(String year)
	{
		return driver.findElement(By.xpath("//button[@aria-label='" + year + "']"));
	}
	
	public WebElement selectMonth(String monthYear)
	{
		return driver.findElement(By.xpath("//button[@aria-label='" + monthYear + "']"));
	}
	
	public WebElement selectDate(String monthYearDate)
	{
		return driver.findElement(By.xpath("//button[@aria-label='" + monthYearDate + "']"));
	}

	/* Review Tab */
	@FindBy(xpath = "//app-toast-message[@class='evisa-application-success ng-star-inserted']//span[@class='toast-header']")
	public WebElement successMessage;
	
	@FindBy(xpath = "//div[@class='evisa-faredetails__name']")
	public WebElement reviewName;
	
	@FindBy(xpath = "//div[@class='evisa-faredetails__price']")
	public WebElement reviewAmount;
	
	@FindBy(xpath = "//div[@class='evisa-faredetails__totalprice']//span/strong")
	public WebElement reviewTotalAmount;
	
	@FindBy(xpath = "//span[text() = 'Continue ']")
	public WebElement reviewContinueBTN;
	
	public EvisaPage(ReportLog reportLog) throws IOException {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Evisa Page - Intialize the Webelements in the driver");
	}

	// Verify flight details page is opened or not
	public void verifyEVisaApplicationPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(eVisaPageHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.verifyElementPresentEX(eVisaPageHeading);
			reportLog.logPass("Verify Transit E-Visa application page is opened");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying Transit E-Visa application page is opened");
		}
	}

	// Select flight radio button in Transit E-Visa Page
	public void selectStopOverFlight() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(selectFlight, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectFlight);
			reportLog.logPass("Select flight in Transit E-Visa form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while selecting flight in Transit E-Visa form");
		}
	}

	// Accept Terms and Conditions in Transit E-Visa Page
	public void acceptTermsAndConditions() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(termsConditionsCheckBox, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(termsConditionsCheckBox);
			reportLog.logPass("Accept Terms and Conditions in Transit E-Visa form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while accepting Terms and Conditions in Transit E-Visa form");
		}
	}

	// Click to Proceed to Application Button in Transit E-Visa Page
	public void clickProceedToApplicationBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.clickWebElement(proceedBTN);
			reportLog.logPass("Click on 'Proceed to application' in Transit E-Visa form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Clicking on 'Proceed to application' in Transit E-Visa form");
		}
	}

	// Fill Personal Information in e-Visa form
	public void fillpersonalInfo(String visaProfession) throws Exception {
		try {
			// Thread.sleep(2000);
			Utilities.waitForAllElementVisibilty(maritalStatucDRP, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(maritalStatucDRP);
			Utilities.jsCLick(singleOption);

			Utilities.setText(profession, visaProfession);

			Utilities.moveToElementAndClick(religionDRP);
			Utilities.moveToElementAndClick(nonMuslimOption);
			reportLog.logPass("Enter personal information in Transit E-Visa application form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Entering personal information in Transit E-Visa application form");
		}
	}

	// Upload personal photo in e-Visa form
	public void uploadPersonalPhoto(String photoPath) throws Exception {
		try {
			Utilities.setText(photoUpload, photoPath);
			reportLog.logPass("Upload photo in Transit E-Visa application form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while upload photo in Transit E-Visa application form");
		}
	}

	// Fill passport and national ID details in e-Visa form
	public void fillPassportAndNationalIdDetails(String Year, String Month, String Date, String NationalID)
			throws Throwable {
		try {
			// Thread.sleep(1000);
			Utilities.jsCLick(passportType);
			Utilities.jsCLick(normalPassport);
			issueDatepickerCal(Year, Month, Date);

			Utilities.setText(nationalId, NationalID);
			reportLog.logPass("Fill all passport and national ID details in Transit E-Visa application form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Fill all passport and national ID details in Transit E-Visa application form");
		}
	}

	// Fill Passenger details in e-Visa form
	public void fillPassengerDetails(String BirthCity, String eVisa_ResidenceCountry, String eVisa_Address,
			String eVisa_BirthCountry) throws Exception {
		try {
			Utilities.setTextAndEnter(birthCountry, eVisa_BirthCountry);
			Utilities.jsCLick(firstOption);
			Utilities.setText(birthCity, BirthCity);
			Utilities.setTextAndEnter(residenceCountry, eVisa_ResidenceCountry);
			Utilities.jsCLick(firstOption);
			Utilities.setText(address, eVisa_Address);
			reportLog.logPass("Fill all details in Passenger Details page in Transit E-Visa application form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(
					"Error while Fill all details in Passenger Details page in Transit E-Visa application form");
		}
	}

	// Fill medical information form
	public void medicalInfoDetails() throws Exception {
		try {
			Utilities.jsCLick(notForAll);
			reportLog.logPass("Select 'No' for all medical informatiom in Transit E-Visa application form");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(
					"Error while Select 'No' for all medical informatiom in Transit E-Visa application form");
		}
	}

	// Past date picker
	public void issueDatepickerCal(String Year, String Month, String Date) throws Throwable {
		try {

			Utilities.scrollToElement(issueDate);
			Thread.sleep(500);
			Utilities.jsCLick(issueDate);
			Utilities.jsCLick(clickChooseDate);
			Utilities.jsCLick(selectYear(Year));
			Utilities.jsCLick(selectMonth(Month));
			Utilities.jsCLick(selectDate(Date));
			Utilities.jsCLick(confirmBTN);

			reportLog.logPass("Select passport issue date");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Select passport issue date");
		}
	}

	// Verify SuccessMessage in Review Page in e-Visa form
	public void verifySuccessMessage(String message) throws Throwable {
		try {
			Utilities.verifyTextEquals(successMessage, message);
			reportLog.logPass("Verify Success Message after adding eVisa in Review Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Select passport issue date");
		}
	}

	// Verify Fare Details in Review Page in e-Visa form
	public void verifyFareDetails(String name, String amount, String totalAmount) throws Exception {
		try {
			Utilities.verifyTextEquals(reviewAmount, amount);
			Utilities.verifyTextEquals(reviewTotalAmount, totalAmount);
			reportLog.logPass("Verify Success Message after adding eVisa in Review Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Select passport issue date");
		}
	}

	// Click on Continue Button in Review Page in e-Visa form
	public void clickContinueBTN() throws Exception {
		try {
			Utilities.jsCLick(reviewContinueBTN);
			reportLog.logPass("Click Continue button in eVisa in Review Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Clicking Continue button in eVisa in Review Page");
		}
	}

	// Click on Continue Button in Review Page in e-Visa form
	public void clickSubmitBTN() throws Exception {
		try {
			Utilities.jsCLick(submitBTN);
			reportLog.logPass("Click Submit button in eVisa in Review Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Click Submit button in eVisa in Page");
		}
	}
}
