
package com.saudia.qa.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.CommonMethodUtil;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class AltanfeethiVIPServicePage extends TestBase {

	private static Logger Log = Logger.getLogger(AltanfeethiVIPServicePage.class);
	private ReportLog reportLog;

	/* Altanfeethi VIP Service */

	@FindBy(xpath = "//h2[contains(text(),'Altanfeethi VIP Service')]")
	public WebElement addALTVIPServicePageTitle;

	@FindBy(xpath = "//span[contains(text(),'Select')]")
	public WebElement addALTVIPSelectBTN;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement editALTVIPSelectBTN;

	@FindBy(xpath = "//div[@class='fare']//span[2]")
	public WebElement AltanfeethiTotalAmount;

	@FindBy(xpath = "//span[contains(text(),'Arrival')]/span[4]")
	public WebElement AltanfeethiAmount;

	@FindBy(xpath = "//div[contains(text(), 'Fast track is not available on this flight'])")
	public WebElement AltanfeethiNotAvailable;

	@FindBy(xpath = "//span[contains(text(),'Continue to next flight')]")
	public WebElement continueNextFlightBTN;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public WebElement confirmBTN;

	public WebElement selectALTVIPService(String serviceName) {
		return driver.findElement(By.xpath(
				"//span[contains(text(),'" + serviceName + "')]/parent::div/parent::div/following-sibling::div"));
	}

	public AltanfeethiVIPServicePage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	// Verify Altanfeethi VIP Service Page is open or not
	public void verifyALTVIPServicePageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(addALTVIPServicePageTitle, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Altanfeethi page is opened");
			Utilities.isDisplayed(addALTVIPServicePageTitle);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking Altanfeethi page is opened or not");
		}
	}

	// Add Altanfeethi VIP Service for All OW, RT, MC
	public double addAltanfeethiAllFlights(double subTotalAmount, String perALTServiceAmount, String serviceName, int i)
			throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("perALTServiceAmount---->" + perALTServiceAmount.split(" ")[1]);
			double altanfeethiAMT = CommonMethodUtil.getDoubleValueFromString(perALTServiceAmount.split(" ")[1]);
			Utilities.waitForAllElementVisibilty(addALTVIPSelectBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.clickWebElement(addALTVIPSelectBTN);
			Utilities.clickWebElement(selectALTVIPService(serviceName));
			Utilities.waitForAllElementVisibilty(editALTVIPSelectBTN, Constants.maxTime, Constants.poolingTime);
			subTotalAmount = subTotalAmount + altanfeethiAMT;
			double selectedServiceAmount = CommonMethodUtil.getDoubleValueFromString(AltanfeethiTotalAmount.getText().split(" ")[1]);
			if (selectedServiceAmount == subTotalAmount) {
				reportLog.logPass("Flight " + i + " : Add Altanfeethi VIP Service ");
			} else {
				throw new Exception("Error while Adding Altanfeethi VIP Service");
			}
			return subTotalAmount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding Altanfeethi VIP Service", e);
		}
	}

	// Modify Altanfeethi VIP Service for All OW, RT, MC
	public void modifyAltanfeethiAllFlights(String altanfeethiTotalAmount, String perALTServiceTrackAmount,
			String serviceName, int flightNo) throws Exception {
		try {

			Utilities.waitForAllElementVisibilty(editALTVIPSelectBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.clickWebElement(editALTVIPSelectBTN);
			Utilities.clickWebElement(selectALTVIPService(serviceName));
			Utilities.waitForAllElementVisibilty(addALTVIPSelectBTN, Constants.maxTime, Constants.poolingTime);
			boolean purchased = Utilities.isDisplayed(addALTVIPSelectBTN);
			if (purchased == true) {
				reportLog.logPass("Flight " + flightNo, " : Modify  Altanfeethi VIP Service");
			} else {
				throw new Exception("Error while Modifying Altanfeethi VIP Service");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Modifying Altanfeethi VIP Service", e);
		}
	}

	// Check Altanfeethi Service available for flight in 'Altanfeethi ' Page
	public boolean checkAltanfeethiAvailableForFlight(int flightNo) throws Exception {
		try {
			Thread.sleep(500);

			boolean available = Utilities.verifyElementPresent(addALTVIPServicePageTitle);
			if (available == false) {
				Utilities.verifyElementPresentEX(AltanfeethiNotAvailable);
				reportLog.logPass("Flight " + flightNo,
						" : Verify 'Altanfeethi VIP Service' service is NOT available for this flight");
			} else {
				reportLog.logPass("Flight " + flightNo,
						" : Verify 'Altanfeethi VIP Service' service is available for this flight");
			}
			return available;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding Altanfeethi VIP Service  for  flight", e);
		}
	}

	// Click on Next Flight button in 'Fast Track' Page
	public void clickNextFlightBTN() throws Exception {
		try {
			Utilities.clickWebElement(continueNextFlightBTN);
			reportLog.logPass("Click on Next Flight Button in 'Altanfeethi VIP Service' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Next flight button");
		}
	}

	// Click on Confirm button in 'Fast Track' Page
	public void clickConfirmBTN() throws Exception {
		try {
			Utilities.moveToElementAndClick(confirmBTN);
			reportLog.logPass("Click on Confirm Button in 'Altanfeethi VIP Service' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Confirm button");
		}
	}

}
