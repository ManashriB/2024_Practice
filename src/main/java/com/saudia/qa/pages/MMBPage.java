package com.saudia.qa.pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class MMBPage extends TestBase {

	private ReportLog reportLog;

	@FindBy(xpath = "//p[text()='Booking reference ']")
	public WebElement bookingReference;

	@FindBy(xpath = "//a[text()='Change flight']")
	public WebElement changeFlightLink;
	
	@FindBy(xpath = "//a[text()='Cancel trip']")
	public WebElement cancelFlightLink;
	
	@FindBy(xpath = "//button[@aria-label='Cancel Trip']")
	public WebElement cancelFlightbutton;
	
	@FindBy(xpath = "//h2[@class='mat-dialog-title']")
	public WebElement noRefundPopUp;

	@FindBy(xpath = "//h2[text()='Verification required']")
	public WebElement verifcationRequiredPopUp;

	@FindBy(xpath = "//label[@class='mat-radio-label']/span")
	public WebElement emailAddressRadio;
	
	@FindBy(xpath = "//span[text()='Send code']")
	public WebElement sendCodeBTN;
	
	@FindBy(xpath = "//button[@aria-label='Confirm']")
	public WebElement confirmBTN;

	public MMBPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
	}

	// Verify MMB page is opened
	public void verifyMMBPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(bookingReference, Constants.highLoadTime, Constants.poolingTime_Min);
			reportLog.logPass("Verify MMB page is opened");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying MMB page is opened");
		}
	}

	// Verify MMB page is opened
	public void changeFlight() throws Exception {
		try {
			Utilities.jsCLick(changeFlightLink);
			Utilities.verifyElementPresent(verifcationRequiredPopUp);
			Utilities.clickWebElement(emailAddressRadio);
			Utilities.jsCLick(sendCodeBTN);
			Thread.sleep(60000);
			
			reportLog.logPass("Click on 'Change Flight' Link in MMB page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Clicking on 'Change Flight' Link in MMB page");
		}
	}
	
	// Verify MMB page is opened
		public void cancelFlight() throws Exception {
			try {
				Utilities.waitForAllElementVisibilty(bookingReference, Constants.highLoadTime, Constants.poolingTime_Min);
				Utilities.jsCLick(cancelFlightLink);
				/*boolean refundPopup = Utilities.verifyElementPresent(verifcationRequiredPopUp);
				if(refundPopup)
				{
					Utilities.clickWebElement(cancelFlightbutton);
				}*/
				Utilities.verifyElementPresent(verifcationRequiredPopUp);
				//Utilities.jsCLick(sendCodeBTN);
				
				
				reportLog.logPass("Click on 'Change Flight' Link in MMB page");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Clicking on 'Change Flight' Link in MMB page");
			}
		}
	
}
