package com.saudia.qa.pages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.CommonMethodUtil;
import com.saudia.qa.util.LayoutHeader;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class SeatSelectionPage extends TestBase {

	private static Logger Log = Logger.getLogger(SeatSelectionPage.class);
	private ReportLog reportLog;

	/* Seat Selection Service */

	@FindBy(xpath = "//span[text()='Seat Selection ']")
	public WebElement seatSelection;

	@FindBy(xpath = "//div[@class='passenger-name']//div[2]")
	public WebElement passengerName;

	@FindBy(xpath = "//p[@class='seat-details ng-star-inserted'][1]")
	public WebElement passDetails;

	@FindBy(xpath = "//p[@class='seat-details ng-star-inserted'][2]")
	public WebElement seatType;

	@FindBy(xpath = "//div[@class='fare seats-fare']//span[2]")
	public WebElement seatTotalAmount;

	@FindBy(xpath = "//span[contains(text(),'Arrival')]/span[4]")
	public WebElement seatAmount;

	@FindBy(xpath = "//span[text()='Passengers']")
	public WebElement pageTitile;

	@FindBy(xpath = "(//td[@class='border-area'])[5]")
	public WebElement scrollBar;
	
	@FindBy(xpath = "(//img[not(@alt='Unavailable') and @class='nonhover-image ng-star-inserted'])[1]")
	public WebElement seatAvaialble;

	@FindBy(xpath = "(//img[not(@alt='Unavailable') and @class='nonhover-image ng-star-inserted'])[1]/ancestor::button")
	public WebElement seatAvialbleText;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane seat-selector-popup']")
	public WebElement switchPopUp;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane seat-selector-popup']//div[@class='content-left']/h1")
	public WebElement popupseatName;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane seat-selector-popup']//div[@class='content-left']/h2")
	public WebElement popupseatAmount;

	@FindBy(xpath = "//span[text()=' Confirm ']")
	public WebElement confirmPopUp;

	@FindBy(xpath = "//div[contains(text(), 'Seat selection is not available on this flight'])")
	public WebElement seatSelectionNotAvailable;

	@FindBy(xpath = "//span[contains(text(),'Continue to next flight')]")
	public WebElement continueNextFlightBTN;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public WebElement confirmBTN;

	@FindBy(xpath = "//span[text()='cancel']")
	public WebElement cancelSeat;

	@FindBy(xpath = "//div[@class='passenger-details']/div/div[2]")
	public WebElement passengerDetails;

	public SeatSelectionPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	public WebElement seatSelectBTN() throws Exception {
		try {

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='hover-image']"));
			/*
			 * WebElement farecardElement = null; for (WebElement card : list) {
			 * farecardElement = card; break; }
			 */
			return list.get(9);

			// return farecardElement;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting Seat");
		}
	}

	// Verify 'Seat Selection ' Page is open or not
	public void verifySeatSelectionPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(pageTitile, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Seat Selection page is opened");
			Utilities.isDisplayed(pageTitile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking Seat Selection page is opened or not");
		}
	}

	// Check 'Seat Selection ' available for flight in ''Seat Selection ' Page
	public boolean checkSeatAvailableForFlight(int flightNo) throws Exception {
		try {
			Thread.sleep(2000);
			boolean available = Utilities.verifyElementPresent(scrollBar);

			if (available == true) {
				Utilities.verifyElementPresentEX(scrollBar);
				reportLog.logPass("Flight " + flightNo,
						" : Verify 'Seat Selection' service is available for this flight");
			} else {
				reportLog.logPass("Flight " + flightNo,
						" : Verify 'Seat Selection ' service is NOT available for this flight");
			}
			return available;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while 'Seat Selection '  for  flight", e);
		}
	}
	
	
	public String getSeatValue(String SeatType) {
		String seatAmount = null;
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='adjust-div']/div"));
		for(WebElement name : list) {
			String[] seat = name.getText().split("Up to");
			String anscillarySeatName = SeatType.trim();
			String seatType = seat[0].trim(); 
			
			System.out.print("anscillarySeatName => " + anscillarySeatName + "  ---" + "Seat[0] => " + SeatType);

			if(anscillarySeatName.equalsIgnoreCase(seatType)) {
				System.out.println(" Enter inside loop");
				seatAmount= seat[1];
				System.out.println("Seat Name : " + seat[0] + "Seat Amount : " + seat[1]);
				break;
			}	
		}
		System.out.println("Seat amount => " + seatAmount);
		return seatAmount;
	}

	// Seat Selection Service for All OW, RT, MC
	public double seatSelectionAllFlights(double subTotalAmount, int i) throws Exception {
		try {
			Thread.sleep(1000);
			Utilities.waitForAllElementVisibilty(seatAvaialble, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(scrollBar);
			Thread.sleep(2000);
			Utilities.moveToElement(seatAvaialble);
			Utilities.moveToElementAndClick(seatAvaialble);

			String[] seat = seatAvialbleText.getAttribute("aria-label").split(" . ");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(LayoutHeader.Anscillary_Seat_Name, seat[0]);
			map.put(LayoutHeader.Anscillary_Seat_Type, seat[1]);
			map.put(LayoutHeader.Anscillary_Seat_Amount, seat[2]);
			Utilities.waitForAllElementVisibilty(switchPopUp, Constants.maxTime, Constants.poolingTime);
			String popUpText = Utilities.getText(popupseatName) + " . " + Utilities.getText(popupseatAmount);
			String verifyPopText = map.get(LayoutHeader.Anscillary_Seat_Name) + " . " + map.get(LayoutHeader.Anscillary_Seat_Amount);
			if (popUpText.equalsIgnoreCase(verifyPopText)) {
				reportLog.logPass("Verify 'Confirm Seat' Pop up while selecting seats");
			} else {
				throw new Exception("Error while verifying Pop-up Text");
			}
			Utilities.clickWebElement(confirmPopUp);
			
			// Note - create separate methods for pop up and verifying details
			/*
			 * Utilities.waitForAllElementVisibilty(passengerName, Constants.maxTime,
			 * Constants.poolingTime); String passengerDetails =
			 * Utilities.getText(passDetails) + " . " + Utilities.getText(seatType);
			 * 
			 * String verifyPassengerDetail = map.get("seatNo") + " . " +
			 * map.get("seatAmount") + " . " + map.get("seatType");
			 * 
			 * System.out.println("verifyPassengerDetail-----------------"+
			 * verifyPassengerDetail); System.out.println("passDeatils-----------------"+
			 * passengerDetails);
			 * 
			 * if (verifyPassengerDetail.equalsIgnoreCase(passengerDetails)) {
			 * reportLog.logPass("Verify Passenger Details after selecting seat."); } else { throw
			 * new Exception("Error while verifying passenger details"); }
			 */

			System.out.println("Anscillary_Seat_Amount  => " + getSeatValue(seat[1]));
			
			double seatAMT = CommonMethodUtil.getDoubleValueFromString(getSeatValue(seat[1]).split(" ")[1]);
			
			
			subTotalAmount = subTotalAmount + seatAMT;
			String seatAmt = seatTotalAmount.getText();
			double selectedServiceAmount = 0.00;
			// if-else temporarily added for issue else is actual code
			if (seatAmt.equalsIgnoreCase(LayoutHeader.Anscillary_Free_Seat)) {
				// double selectedServiceAmount = "SAR 0.00";
				System.out.println("Seat Total amount is free");
			} else {
				selectedServiceAmount = CommonMethodUtil
						.getDoubleValueFromString(seatTotalAmount.getText().split(" ")[1]);
			}
			if (selectedServiceAmount == subTotalAmount) {
				reportLog.logPass("Flight " + i + " : Seat Selected");
			} else {
				throw new Exception("Error while selecting seat");
			}
			return subTotalAmount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while selecting seat", e);
		}
	}

	// Click on Next Flight button in 'Seat Selection '' Page
	public void clickNextFlightBTN() throws Exception {
		try {
			Utilities.clickWebElement(continueNextFlightBTN);
			reportLog.logPass("Click on Next Flight Button in ''Seat Selection 'e' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Next flight button");
		}
	}

	// Click on Confirm button in ''Seat Selection '' Page
	public void clickConfirmBTN() throws Exception {
		try {
			Utilities.moveToElementAndClick(confirmBTN);
			reportLog.logPass("Click on Confirm Button in 'Seat Selection ' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Confirm button");
		}
	}

	public void modifySeatSelectedAllFlights(String passengerInfo) {
		try {
			Thread.sleep(2000);
			Utilities.waitForAllElementVisibilty(cancelSeat, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(cancelSeat);
			String passDeatils = passengerDetails.getText();
			if (passDeatils.equalsIgnoreCase(passengerInfo)) {
				reportLog.logPass("Removed selected seat for Passenger and verify details");
			} else {
				throw new Exception("Error while Removed selected seat for Passenger and verify details");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
