package com.saudia.qa.pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class CheckInPage extends TestBase {

	private ReportLog reportLog;

	/*********** Passengers Tab ***********/

	@FindBy(xpath = "//h1//span[contains(text(),'check-in')]")
	public WebElement checkInPageHeading;

	@FindBy(xpath = "//p[contains(text(),'Booking reference')]/following-sibling::p")
	public WebElement bookingReference;

	@FindBy(xpath = "//button[@aria-label='Click here to start your check-in process']")
	public WebElement startCheckInBTN;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement missingDetailsSaveAndContinue;

	@FindBy(xpath = "//p[text()='To check in, please provide any missing details ']")
	public WebElement missingDetailsPageHeader;

	@FindBy(xpath = "//span[@aria-label='Click here to complete your check-in ']")
	public WebElement completeCheckInBTN;
	
	@FindBy(xpath = "//h2[text()='Online Check-in']")
	public WebElement onlineCheckInPopUpHeader;
		
	@FindBy(xpath = "//button[@aria-label='Click here to agree and continue']")
	public WebElement AcceptAndContinuePopUp;

	public CheckInPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
	}

	// Verify CheckIn page is opened
	public void verifyCheckInPageIsOpened(String PNR) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(checkInPageHeading, Constants.highLoadTime, Constants.poolingTime_Min);
			Utilities.verifyTextEquals(bookingReference, PNR);
			reportLog.logPass("Verify checkIn page is opened");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying CheckIn page is opened");
		}
	}

	// Verify CheckIn page is opened
		public void startCheckIn() throws Exception {
			try {
				Utilities.waitForAllElementVisibilty(startCheckInBTN, Constants.highLoadTime, Constants.poolingTime_Min);
				Utilities.jsCLick(startCheckInBTN);
				reportLog.logPass("Start checkIn for customer");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Starting checkIn for customer");
			}
		}

	
	// Save and continue in Missing details page
	public void complteMissingCheckINDetails() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(missingDetailsPageHeader, Constants.highLoadTime,
					Constants.poolingTime_Min);
			Utilities.clickWebElement(missingDetailsSaveAndContinue);
			reportLog.logPass("Complete missing details in CheckIn page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Completing missing details in CheckIn page");
		}
	}

	// Click on Complete check-in in Missing details page
	public void completeCheckIn() throws Exception {
		try {
			Utilities.scrollToElementView(completeCheckInBTN);
			Utilities.jsCLick(completeCheckInBTN);
			reportLog.logPass("Click on complete CheckIn button");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Clicking on complete CheckIn buttons");
		}
	}
	
	// Verify Online Checkin Pop is opened
	public boolean checkInPopUpIsOpened() throws Exception {
		try {
			return Utilities.isDisplayed(onlineCheckInPopUpHeader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking chekIn popup is opened");
		}
	}
	
	
	// Accept Online Check-in popup
		public void acceptCheckInPopUp() throws Exception {
			try {
				Utilities.waitForAllElementVisibilty(onlineCheckInPopUpHeader, Constants.highLoadTime,
						Constants.poolingTime_Min);
				Utilities.clickWebElement(AcceptAndContinuePopUp);
				reportLog.logPass("Click on complete CheckIn button");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Clicking on complete CheckIn buttons");
			}
		}

}
