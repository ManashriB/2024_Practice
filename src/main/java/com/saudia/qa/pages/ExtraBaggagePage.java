package com.saudia.qa.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class ExtraBaggagePage extends TestBase {

	private static Logger Log = Logger.getLogger(ExtraBaggagePage.class);
	private ReportLog reportLog;

	/* For Departing Flights */
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public WebElement confirmBTN;

	@FindBy(xpath = "//*[contains(text(),'Extra baggage')]")
	public WebElement extraBaggageTitle;

	@FindBy(xpath = "//*[text()='add']")
	public WebElement addBaggagePlusBTN;

	@FindBy(xpath = "(//div[@class='extraBaggage-content-container']//span[text()='remove']/following-sibling::span[1])[1]")
	public WebElement extraBagsCount;

	@FindBy(xpath = "//div[@class='baggage-weight ng-star-inserted']//span[@class='weight']")
	public WebElement baggageWeight;

	@FindBy(xpath = "//div[@class='baggage-weight ng-star-inserted']//span[@class='weight count']")
	public WebElement baggageWeightCount;

	@FindBy(xpath = "//div[@class='fare']/span[2]")
	public WebElement totalFare;

	@FindBy(xpath = "(//span[text()='remove' and contains(@class, 'disabledbtn')])[1]")
	public WebElement disabledremoveBaggageMinusBTN;

	@FindBy(xpath = "(//span[text()='add' and contains(@class, 'disabledbtn')])[1]")
	public WebElement disabledaddBaggagePlusBTN;

	@FindBy(xpath = "//span[contains(text(),'Baggages added')]")
	public WebElement baggagedAddedText;

	@FindBy(xpath = "//span[text()='remove']")
	public WebElement removeBaggageMinusBTN;

	@FindBy(xpath = "//span[text()=' Next Flight ']")
	public WebElement nextFligt;

	/* For Return FLights */
	@FindBy(xpath = "(//span[text()='remove' and contains(@class, 'disabledbtn')])[1]")
	public WebElement disabledremoveBaggageMinusBTNReturn;

	@FindBy(xpath = "//*[text()='add']")
	public WebElement addBaggagePlusBTNReturn;

	@FindBy(xpath = "(//div[@class='extraBaggage-content-container']//span[text()='remove']/following-sibling::span[1])[1]")
	public WebElement extraBagsCountReturn;

	@FindBy(xpath = "//div[@class='baggage-weight ng-star-inserted']//span[@class='weight']")
	public WebElement baggageWeightReturn;

	@FindBy(xpath = "//div[@class='baggage-weight ng-star-inserted']//span[@class='weight count']")
	public WebElement baggageWeightCountReturn;

	@FindBy(xpath = "(//span[text()='add' and contains(@class, 'disabledbtn')])[1]")
	public WebElement disabledaddBaggagePlusBTNReturn;
	
	@FindBy(xpath = "//span[text()='remove']")
	public WebElement removeBaggageMinusBTNReturn;

	public ExtraBaggagePage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	// Add 'n' bags per passenger and verify it adds bags up to maximum count only - Departur Flight
	public String addExtraBaggageDeparting(int bagsToAdd, String amountPerBag, String weight) throws Exception {
		try {
			Thread.sleep(2000);
			double perBagAmount = Double.parseDouble(amountPerBag.split(" ")[1]);

			Utilities.verifyTextEquals(extraBagsCount, "0");
			Utilities.verifyElementPresent(disabledremoveBaggageMinusBTN);
			double totalAmount = 0.00d;
			String totalAmountFormatted = null;
			for (int i = 1; i <= bagsToAdd; i++) {
				Utilities.clickWebElement(addBaggagePlusBTN);
				Utilities.verifyTextEquals(extraBagsCount, String.valueOf(i));
				Utilities.verifyTextEquals(baggageWeight, weight);
				Utilities.verifyTextEquals(baggageWeightCount, String.valueOf(i));
				totalAmount = totalAmount + perBagAmount;
				totalAmountFormatted = String.format("%.2f", totalAmount);
				Utilities.verifyTextEquals(totalFare, "SAR " + totalAmountFormatted);
			}

			if (bagsToAdd == 4) {
				Utilities.verifyElementPresent(disabledaddBaggagePlusBTN);
			}

			boolean purchased = Utilities.verifyTextEquals(extraBagsCount, String.valueOf(bagsToAdd));

			if (purchased == true) {
				reportLog
						.logPass("Flight 1 : Add " + bagsToAdd + " additional checked baggage for passenger");
				return bagsToAdd + ":SAR " + String.format("%,.2f", totalAmount);
			} else {
				throw new Exception("Error while Adding extra baggage for Departing flight");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding bags per passenger for Departing flight", e);
		}
	}

	// Add 'n' bags per passenger and verify it adds bags up to maximum count only - Return Flight
	public String addExtraBaggageReturning(int bagsToAdd, String amountPerBag, String weight,
			String totalAmountDeparting, int FlightCount) throws Exception {
		
		try {
			Thread.sleep(2000);
			double perBagAmount = Double.parseDouble(amountPerBag.split(" ")[1]);
			//Utilities.waitForAllElementVisibilty(confirmBTN, Constants.maxTime, Constants.poolingTime);
			//Utilities.verifyTextEquals(extraBagsCountReturn, "0");
			Utilities.verifyElementPresent(disabledremoveBaggageMinusBTNReturn);

			double totalAmount = Double.parseDouble(totalAmountDeparting.split(" ")[1]);
			String totalAmountFormatted = null;
			for (int i = 1; i <= bagsToAdd; i++) {
				Utilities.clickWebElement(addBaggagePlusBTNReturn);
				Utilities.verifyTextEquals(extraBagsCountReturn, String.valueOf(i));
				Utilities.verifyTextEquals(baggageWeightReturn, weight);
				Utilities.verifyTextEquals(baggageWeightCountReturn, String.valueOf(i));
				totalAmount = totalAmount + perBagAmount;
				totalAmountFormatted = String.format("%.2f", totalAmount);
				Utilities.verifyTextEquals(totalFare, "SAR " + totalAmountFormatted);
			}
			 
			if (bagsToAdd == 4) {
				Utilities.verifyElementPresent(disabledaddBaggagePlusBTNReturn);
			}

			boolean purchased = Utilities.verifyTextEquals(extraBagsCountReturn, String.valueOf(bagsToAdd));

			if (purchased == true) {
				reportLog.logPass("Flight "+ FlightCount +": Add " + bagsToAdd + " additional checked baggage for passenger");
				return bagsToAdd + ":SAR " + String.format("%,.2f", totalAmount);
			} else {
				throw new Exception("Error while Adding extra baggage for return flight");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while adding bags per passenger for return flight", e);
		}
	}

	// Modify ExtraBags added and verify it removes bags up to maximum count only - Departure Flight
	public String modifyExtraBagsAddedDeparting(int bagsAdded, String amountPerBag, int noOfBagsRemove, String weight,
			double totalAmount) throws Exception {
		
		try {

			double perBagAmount = Double.parseDouble(amountPerBag.split(" ")[1]);
			Utilities.waitForAllElementVisibilty(extraBaggageTitle, Constants.maxTime, Constants.poolingTime);

			int totalBags = bagsAdded;
			String totalAmountFormatted = null;
			for (int i = noOfBagsRemove; i >= 1; i--) {
				// Utilities.verifyTextEquals(extraBagsCount, String.valueOf(bagsAdded));
				Utilities.clickWebElement(removeBaggageMinusBTN);
				totalAmount = totalAmount - perBagAmount;
				totalBags = totalBags - 1;
				Utilities.verifyTextEquals(extraBagsCount, String.valueOf(totalBags));

				if (totalBags != 0) {
					Utilities.verifyTextEquals(baggageWeight, weight);
					Utilities.verifyTextEquals(baggageWeightCount, String.valueOf(totalBags));
					totalAmountFormatted = String.format("%.2f", totalAmount);
					Utilities.verifyTextEquals(totalFare, "SAR " + totalAmountFormatted);
				}
			}
			boolean modified = Utilities.verifyTextEquals(extraBagsCount, String.valueOf(totalBags));
			if (noOfBagsRemove == 4) {
				Utilities.verifyElementPresent(disabledremoveBaggageMinusBTN);
			}

			if (modified == true) {
				reportLog.logPass("Flight 1 : Modify(Remove) " + noOfBagsRemove + " additional checked baggage for passenger");
				return totalBags + ":SAR " + String.format("%,.2f", totalAmount);
			} else {
				throw new Exception("Error while Modifying extra baggages");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Modifying extra baggages", e);
		}
	}
	
	// Modify ExtraBags added and verify it removes bags up to maximum count only - Return Flight
	public String modifyExtraBagsAddedReturning(int bagsAdded, String amountPerBag, int noOfBagsRemove, String weight,
			double totalAmount, int FlightCount) throws Exception {
		
		try {

			double perBagAmount = Double.parseDouble(amountPerBag.split(" ")[1]);
			Utilities.waitForAllElementVisibilty(extraBaggageTitle, Constants.maxTime, Constants.poolingTime);

			int totalBags = bagsAdded;
			String totalAmountFormatted = null;
			for (int i = noOfBagsRemove; i >= 1; i--) {
				// Utilities.verifyTextEquals(extraBagsCount, String.valueOf(bagsAdded));
				Utilities.clickWebElement(removeBaggageMinusBTNReturn);
				totalAmount = totalAmount - perBagAmount;
				totalBags = totalBags - 1;
				Utilities.verifyTextEquals(extraBagsCountReturn, String.valueOf(totalBags));

				if (totalBags != 0) {
					Utilities.verifyTextEquals(baggageWeightReturn, weight);
					Utilities.verifyTextEquals(baggageWeightCountReturn, String.valueOf(totalBags));
					totalAmountFormatted = String.format("%.2f", totalAmount);
					Utilities.verifyTextEquals(totalFare, "SAR " + totalAmountFormatted);
				}
			}
			boolean modified = Utilities.verifyTextEquals(extraBagsCount, String.valueOf(totalBags));
			if (noOfBagsRemove == 4) {
				Utilities.verifyElementPresent(disabledremoveBaggageMinusBTN);
			}

			if (modified == true) {
				reportLog.logPass("Flight " +FlightCount +": Modify(Remove) " + noOfBagsRemove + " additional checked baggage for passenger");
				return totalBags + ":SAR " + String.format("%,.2f", totalAmount);
			} else {
				throw new Exception("Error while Modifying extra baggages");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Modifying extra baggages", e);
		}
	}

	// Click on Confirm button in 'Extra Baggage' Page
	public void clickConfirmBTN() throws Exception {
		try {
			Utilities.moveToElementAndClick(confirmBTN);
			reportLog.logPass("Click on Confirm Button in 'Extra Bagggage' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Confirm button");
		}
	}

	//Click on Next Flight button in 'Extra Baggage' Page
	public void clickNextFlightBTN() throws Exception {
		try {
			Utilities.clickWebElement(nextFligt);
			reportLog.logPass("Click on Next Flight Button in 'Extra Bagggage' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Next flight button");
		}
	}
}
