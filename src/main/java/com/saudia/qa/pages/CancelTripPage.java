package com.saudia.qa.pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class CancelTripPage extends TestBase {

	private ReportLog reportLog;

	/*********** Passengers Tab ***********/

	@FindBy(xpath = "//button[contains(@class,'continue-btn')]")
	public WebElement continueButton;

	@FindBy(xpath = "//*[text()='Cancel trip']")
	public WebElement cancelTripPage;

	@FindBy(xpath = "//span[text()='check_circle']")
	public WebElement passengerIsSelected;

	@FindBy(xpath = "//section[contains(@class, 'fare-terms')]//mat-checkbox//span")
	public static WebElement consentCheckbox;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	public static WebElement confirmButton;

	@FindBy(xpath = "//span[text()='cancel']")
	public static WebElement cancelBookingStatus;

	public CancelTripPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
	}

	// Handle Passengers Tab

	public void passengerTab() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(cancelTripPage, Constants.highLoadTime, Constants.poolingTime_Min);
			Utilities.verifyElementPresent(passengerIsSelected);
			Utilities.jsCLick(continueButton);
			reportLog.logPass("Check passenger is selected for cancel trip and click on continue button");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(
					"Error while Checking passenger is selected for cancel trip and click on continue button");
		}
	}

	// Handle Review Tab

	public void reviewTab() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(consentCheckbox, Constants.maxTime, Constants.poolingTime_Min);
			Utilities.scrollToElement(confirmButton);
			Thread.sleep(1000);
			Utilities.jsCLick(consentCheckbox);
			Utilities.jsCLick(confirmButton);
			reportLog.logPass("Check Review Page and confirm in Cancel Trip page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Checking Review Page and confirm in Cancel Trip page");
		}
	}

	// Verify Trip is canceled
	public void verifyTripIsCanceled() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(cancelBookingStatus, Constants.maxTime, Constants.poolingTime_Min);
			Utilities.verifyElementPresent(cancelBookingStatus);
			reportLog.logPass("Verify Trip is cancelled");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying Trip is cancelled");
		}
	}

}
