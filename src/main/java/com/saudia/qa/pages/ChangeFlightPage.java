package com.saudia.qa.pages;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class ChangeFlightPage extends TestBase {

	private ReportLog reportLog;

	/*********** Change Tab ***********/
	@FindBy(xpath = "//button[@aria-label='Change departure flight']")
	public WebElement changeDepartureFlightBTN;
	
	@FindBy(xpath = "//button[@aria-label='Change return flight']")
	public WebElement changeReturnFlightBTN;

	@FindBy(xpath = "//div[@aria-label='Change Tab 1 Of 3 Currently']")
	public WebElement changeTab;

	@FindBy(xpath = "//div[@aria-label='Flight Tab 2 Of 3 Currently']")
	public WebElement flightTab;

	@FindBy(xpath = "//div[@aria-label='Change Tab 3 Of 3 Currently']")
	public WebElement paymentTab;

	@FindBy(xpath = "//input[@formcontrolname='journeyDate']")
	public WebElement CalenderDate;

	@FindBy(xpath = "(//span[@aria-label = 'Click here to open the calendar dropdown '])[1]")
	public WebElement calendarDDBTN;

	@FindBy(xpath = "(//th[@class='month drp-animate'])[1]")
	public WebElement currentMonthTitle;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[1]")
	public WebElement nxtMonthOWMCBTN;

	@FindBy(xpath = "//button[@aria-labelledby='Continue to Passenger']")
	public WebElement viewFlightsBTN;

	public List<WebElement> dateOW() {
		return driver.findElements(By.xpath(
				"(//tbody[@class='drp-animate'])[1]//td[ (contains(@class,'available')) and not(contains(@class,'off'))]"));
	}

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement calendarContOWBTN;

	@FindBy(xpath = "//h2[text()='Fare Confirmation']")
	public WebElement fareConfirmationTitle;

	@FindBy(xpath = " //span[text()=' Confirm  ']")
	public WebElement confirmBTN;

	@FindBy(xpath = "//button[@aria-labelledby='Continue to Payment']")
	public WebElement proceedToPaymentBTN;
	
	@FindBy(xpath = "//*[text()=' flight_land ']")
	public static WebElement flightLandOffImg;
	
	@FindBy(xpath = "(//*[text()=' flight_takeoff '])[2]")
	public static WebElement flightTakeOffImgR2;
	
	@FindBy(xpath = "(//div[@aria-label='Click here to clear flying from Destinations value '])[2]")
	public static WebElement ClearFromR2;
	
	@FindBy(xpath = "//div[@aria-label='Click here to clear flying to Destinations value ']")
	public static WebElement ClearTo;
	
	@FindBy(xpath = "//input[@data-placeholder='To']")
	public static WebElement inputFeildTo;
	
	@FindBy(xpath = "(//input[@data-placeholder='From'])[2]")
	public static WebElement inputFeildFromR2;

	/* Flights Tab */

	public ChangeFlightPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
	}
	
	/********* Payment Tab ********/
	
	@FindBy(xpath = "//section[contains(@class, 'fare-terms')]//mat-checkbox//span")
	public static WebElement consentCheckbox;
	
	@FindBy(xpath = "//app-jss-total-fare-details//button[contains(@class,'pay-button')]")
	public static WebElement payButton;
	
	@FindBy(xpath = "//form[contains(@class,'pay-by-cards')]")
	public static WebElement paymentBox;
	
	@FindBy(xpath = "//div[@class='content']//div[contains(text(), ' flight fare is the same as the original fare ')]")
	public static WebElement sameFareAsOriginalDeclaimer;
	
	@FindBy(xpath = "//div[@class='content']//p[contains(text(), 'Fare for the new flight is less than the original booking')]")
	public static WebElement refundDeclaimer;
	
	@FindBy(xpath = "//div[@class='fare-detail']/div")
	public static WebElement fareDetials;
	
	@FindBy(xpath = "//div[@class='title-wallet']/div")
	public static WebElement amount;

	// Verify change flight page is opened
	public void clickChangeFlightDepart() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(changeTab, Constants.highLoadTime, Constants.poolingTime_Min);
			Utilities.scrollDown();
			Utilities.jsCLick(changeDepartureFlightBTN);
			Utilities.scrollIntoView(CalenderDate);
			Utilities.scrollDown();

			reportLog.logPass("Change departure date of flight in MMB");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Changing departure date of flight in MMB");
		}
	}
	
	// Verify change flight page is opened
		public void clickChangeFlightReturn() throws Exception {
			try {
				Utilities.waitForAllElementVisibilty(changeTab, Constants.highLoadTime, Constants.poolingTime_Min);
				Utilities.scrollDown();
				Utilities.jsCLick(changeReturnFlightBTN);
				Utilities.scrollIntoView(CalenderDate);
				Utilities.scrollDown();

				reportLog.logPass("Change return date of flight in MMB");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Changing return date of flight in MMB");
			}
		}

	// select date in datepicker for OW
	public void datepickerCal(String monthInput, String dateInput) throws Exception {
		try {
			String datetxt = null;

			Utilities.scrollDown();
			Utilities.jsCLick(calendarDDBTN);

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
			reportLog.logPass("Select New Departure Date for change flight OW :  ", datetxt + currentmonthtext);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Selecting Departure Date for change flight OW");
		}
	}

	// Click on view flights in change flight
	public void viewFlights() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(viewFlightsBTN, Constants.maxTime, Constants.poolingTime_Min);
			Utilities.jsCLick(viewFlightsBTN);
			Utilities.waitForAllElementVisibilty(flightTab, Constants.highLoadTime, Constants.poolingTime_Min);
			reportLog.logPass("View flights in Change flight page MMB");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while view flights in MMB");
		}
	}

	// FrareCard and SubFareCard selection for One Way Trip on Flight Page
	public void selectFareCardOW(String depFareCard, String depSubFareCard) throws Exception {

		// WebElement selectedFareCard = selectedFareCard(depSubFareCard);
		CommonPageMethodUtil.selectFareCardOW(depFareCard, depSubFareCard);
	}

	// FrareCard and SubFareCard selection for Round Trip on Flight Page
	public void selectFareCardRT(String depFareCard, String depSubFareCard, String retFareCard, String retSubFareCard)
			throws Exception {

		CommonPageMethodUtil.selectFareCardRT(depFareCard, depSubFareCard, retFareCard, retSubFareCard);
	}
	
	// Verify Flight route on Flight details page
	public void verifyFlightRoute(int noOfBound, String origin1, String destination1) throws Exception {
		CommonPageMethodUtil.verifyFlightRoute(noOfBound, origin1, destination1);
	}

	// Handle fare confirmation pop-up
	public void fareConfirmationPopup() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(fareConfirmationTitle, Constants.maxTime, Constants.poolingTime_Min);
			Utilities.clickWebElement(confirmBTN);
			reportLog.logPass("Verify Fare Confirmation page is Opened in Change flight");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Fare Confirmation page is Opened in change flight");
		}
	}

	// Click on Proceed to payment
	public void proceedToPayment() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime_Min);
			Utilities.clickWebElement(proceedToPaymentBTN);
			reportLog.logPass("Click on 'Proceed to Payment' in Change flight");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Clicking on 'Proceed to Payment' in Change flight");
		}
	}

	// Pay Amount for Changed trip
	public void changeFlightPayment(String CardHolderName, String PaymentMode) throws Exception {
		try {
			CommonPageMethodUtil.getCardDetails();
			boolean sameFare = false, refundFare = false;

			Utilities.scrollToElementView(paymentBox);
			boolean paymentBoxPresent = Utilities.verifyElementPresent(paymentBox);

			if (paymentBoxPresent == false) {
				sameFare = Utilities.verifyElementPresent(sameFareAsOriginalDeclaimer);
				refundFare = Utilities.verifyElementPresent(refundDeclaimer);
			}

			System.out.println("****" + paymentBoxPresent + " - " + sameFare + "-" + refundFare);

			if(paymentBoxPresent == true && sameFare == false && refundFare == false) {
				System.out.println(
						"New flight fare is NOT same as the original fare paid. User need to pay extra amount");
				CommonPageMethodUtil.enterCardDetails(CommonPageMethodUtil.cardNumber, CommonPageMethodUtil.cardExpiry,
						CommonPageMethodUtil.cardCVV, CardHolderName, PaymentMode);
				Utilities.verifyTextEquals(fareDetials, "To be paid");
				String toPayAmoount = Utilities.getText(amount);
				reportLog.logPass(
						"New flight fare is NOT same as the original fare paid. To be paid amount = " + toPayAmoount);
			}
			else if (refundFare == true) {
				System.out.println("Fare for the new flight is less than the original booking");
				Utilities.verifyTextEquals(fareDetials, "Refund");
				String refundAmount = Utilities.getText(amount);
				reportLog.logPass(
						"Fare for the new flight is less than the original booking. Refund Amount = " + refundAmount);
			}
			else if (sameFare == true) {
				System.out.println("New flight fare is same as the original fare paid");
			}
			else {
				throw new Exception("Something went wronge!!! change flight payment page");
			}

			Utilities.clickWebElement(consentCheckbox);
			Utilities.clickWebElement(payButton);
			// Utilities.waitForInvisibilityOfElement(paymentLoader, Constants.maxTime,
			// Constants.poolingTime);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while completing payment for flight");
		}
	}

	// Change flight Route - TO field
	public void changeFlightRouteTO(String destinaion) throws Exception {
		try {

			Utilities.waitForAllElementVisibilty(flightLandOffImg, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(flightLandOffImg);
			Utilities.waitForAllElementVisibilty(ClearTo, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(ClearTo);
			Utilities.moveToElementAndEnter(inputFeildTo, destinaion);
			Thread.sleep(1000);
			Utilities.keyPress(Keys.ENTER, 1);
			reportLog.logPass("Change Flight route for Trip : New Destination => " + destinaion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Changing Destination for Trip in Change flight");
		}
	}
	
	// Change flight Route - From Field
		public void changeFlightRouteFROM(String origin) throws Exception {
			try {

				Utilities.waitForAllElementVisibilty(flightTakeOffImgR2, Constants.maxTime, Constants.poolingTime);
				Utilities.jsCLick(flightTakeOffImgR2);
				Utilities.waitForAllElementVisibilty(ClearFromR2, Constants.maxTime, Constants.poolingTime);
				Utilities.moveToElementAndClick(ClearFromR2);
				Utilities.moveToElementAndEnter(inputFeildFromR2, origin);
				Thread.sleep(1000);
				Utilities.keyPress(Keys.ENTER, 1);
				reportLog.logPass("Change Flight route for Trip : New Origin => " + origin);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while Changing Source for Trip in Change flight");
			}
		}

}
