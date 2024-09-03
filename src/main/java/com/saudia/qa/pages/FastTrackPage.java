package com.saudia.qa.pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class FastTrackPage extends TestBase {

	private ReportLog reportLog;

	/* For Departing Flights */

	@FindBy(xpath = "//h2[contains(text(),'Fast Track')]")
	public WebElement fastTrackPageHeading;

	@FindBy(xpath = "(//*[text()='Add'])[1]")
	public WebElement addFastTrackBTN;

	@FindBy(xpath = "//span[@class='fast-track-currency ng-star-inserted']")
	public WebElement fastTrackAmountActual;

	@FindBy(xpath = "//div[@class='fare']//span[2]")
	public WebElement fastTrackSubTotal;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public WebElement confirmBTN;

	@FindBy(xpath = "//a[@aria-label='Click here to Remove Fast track']")
	public WebElement removeFastTrackLink;

	//@FindBy(xpath = "//div[@id='mat-tab-label-1-0']")
	@FindBy(xpath = "//div[@class='mat-tab-label-content']//p[contains(text(),'Departing') or contains(text(),'Flight 1')]")
	public WebElement departingTab;
	
	@FindBy(xpath = "//span[text()=' Next Flight ']")
	public WebElement nextFligt;

	@FindBy(xpath = "//div[text() = 'Fast track is not available on this flight']")
	public WebElement FastTrackNotAvailable;

	public FastTrackPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	// Verify fast track page is opened or not
	public void verifyFastTrackPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(departingTab, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify 'Fast Track' page is opened");
			Utilities.isDisplayed(departingTab);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking Fast Track page is opened or not");
		}
	}

	// Add Fast Track for All OW, RT, MC
	public int addFastTrackAllFlights(int fastTrackTotalAmount, String perfastTrackAmount, int flightNo, int noOfBounds)
			throws Exception {
		try {
			Thread.sleep(500);
			
			boolean purchased = false;
			int fastTrackAmount = Integer.parseInt(perfastTrackAmount.split(" ")[1]);
			
			Utilities.waitForAllElementVisibilty(addFastTrackBTN, flightNo, flightNo);
			Utilities.verifyTextEquals(fastTrackAmountActual, perfastTrackAmount);
			Utilities.verifyElementPresent(addFastTrackBTN);

			Utilities.moveToElementAndClick(addFastTrackBTN);
			Utilities.isDisplayed(removeFastTrackLink);

			fastTrackTotalAmount = fastTrackTotalAmount + fastTrackAmount;
			purchased = Utilities.verifyTextEquals(fastTrackSubTotal, "SAR " + fastTrackTotalAmount);
			if (purchased == true) {
				reportLog.logPass("Flight " + flightNo, " : Add Fast Track ");
			} else {
				throw new Exception("Error while Adding Fast Track for Departing flight");
			}
			return fastTrackTotalAmount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding Fast Track for Departing flight", e);
		}
	}

	// Check Fast Track Service available for flight in 'Fast track' Page
	public boolean checkFastTrackAvailableForFlight(int flightNo) throws Exception {
		try {
			Thread.sleep(500);

			boolean available = Utilities.verifyElementPresent(fastTrackPageHeading);
			if (available == false) {
				Utilities.verifyElementPresentEX(FastTrackNotAvailable);
				reportLog.logPass("Flight " + flightNo, " : Verify 'Fast Track' service is NOT available for this flight");
			} else {
				reportLog.logPass("Flight " + flightNo, " : Verify 'Fast Track' service is available for this flight");
			}
			return available;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding Fast Track for Departing flight", e);
		}
	}

	// Click on Next Flight button in 'Fast Track' Page
	public void clickNextFlightBTN() throws Exception {
		try {
			Utilities.clickWebElement(nextFligt);
			reportLog.logPass("Click on Next Flight Button in 'Fast Track' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Next flight button");
		}
	}

	// Click on Confirm button in 'Fast Track' Page
	public void clickConfirmBTN() throws Exception {
		try {
			Utilities.moveToElementAndClick(confirmBTN);
			reportLog.logPass("Click on Confirm Button in 'Fast Track' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Confirm button");
		}
	}
	
	// Modify Fast Track for All OW, RT, MC
		public void modifyFastTrackAllFlights(int flightNo) throws Exception {
			try {
				Utilities.waitForAllElementVisibilty(removeFastTrackLink, flightNo, flightNo);
				Utilities.verifyElementPresent(removeFastTrackLink);

				Utilities.moveToElementAndClick(removeFastTrackLink);
				boolean purchased = Utilities.isDisplayed(addFastTrackBTN);

				if (purchased == true) {
					reportLog.logPass("Flight " + flightNo, " : Modify Fast Track ");
				} else {
					throw new Exception("Error while Modifying Fast Track");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Modifying Fast Track", e);
			}
		}
}
