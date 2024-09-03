package com.saudia.qa.util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;

public class CommonPageMethodUtil extends TestBase {

	public static String cardNumber;
	public static String cardExpiry;
	public static String cardCVV;

	/************ Flights page *************/

	@FindBy(xpath = "//span[contains(text(),'Continue with')]")
	public static WebElement continueCardBTN;
	
	@FindBy(xpath = "(//div[@class='flight-class'])[1]")
	public static WebElement flightClass;

	public static WebElement selectedFareCard(String subFareCard) {
		return driver.findElement(By.xpath("//*[text()='" + subFareCard + "']"));
	}

	public static WebElement selectSubFareCard(String subFareCard) {
		// return driver.findElement(By.xpath("//*[@aria-label='Select " + subFareCard +
		// " Flight']"));
		return driver.findElement(By.xpath("//div[@class='fare-name' and text()='" + subFareCard + "']"));

	}

	public static WebElement selectSubFareCardBTN(String subFareCard) {
		return driver.findElement(By.xpath("//div[@class='fare-name' and text()='" + subFareCard
				+ "']/ancestor::div[@class= 'fare-cards ng-star-inserted']//button[text()=' Select ']"));
	}

	public static List<WebElement> fareCardList() {
		// return driver.findElements(By.xpath("//mat-card-title[@class='mat-card-title
		// title']"));
		return driver.findElements(By.xpath("//div[@class='flight-class']"));
	}

	public static List<WebElement> getFlightNameUI() {
		// return driver.findElements(By.xpath("//span[text() = 'Select trip']"));
		return driver.findElements(By.xpath("//div[@class='flightDetails-title']"));
	}

	/******** Payment page xpath *********/

	@FindBy(xpath = "//*[@aria-describedby='cardNumber']")
	public static WebElement cardNumInput;

	@FindBy(xpath = "//*[@aria-describedby='cardHolderName']")
	public static WebElement cardHolderInput;

	@FindBy(xpath = "//*[text()='CVV/CVC']")
	public static WebElement cvvInput;

	@FindBy(xpath = "//*[@formcontrolname='month']//parent::div//following-sibling::div//span[text()=' expand_more ']")
	public static WebElement monthArrowBTN;

	@FindBy(xpath = "//*[@formcontrolname='year']//parent::div//following-sibling::div//span[text()=' expand_more ']")
	public static WebElement yearArrowBTN;

	@FindBy(xpath = "//*[@formcontrolname='paymentMethod']//input[@id='CC-input']")
	public static WebElement cardOptionRadioBTN;

	public static WebElement monthInCard(String month) {
		return driver.findElement(By.xpath("//mat-option[" + month + "]"));
	}

	public static WebElement yearInCard(String year) {
		return driver.findElement(By.xpath("//mat-option/span[text() = ' " + year + " ']"));
	}

	public CommonPageMethodUtil() {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		PageFactory.initElements(driver, this);
		Log.info("********Intialize the Webelements in CommonPageMethodUtils");

	}

	// FareCard and SubFareCard selection for One Way Trip on Flight Page
	public static void selectFareCardOW(String depFareCard, String depSubFareCard) throws Exception {
		try {
			subFareCard(depFareCard, depSubFareCard);
			// Utilities.verifyTextEquals(selectedFareCard(depSubFareCard), depSubFareCard);
			Utilities.verifyTextEquals(selectedFareCard(depSubFareCard), depSubFareCard);
			Thread.sleep(2000);
			Utilities.clickWebElement(continueCardBTN);
			reports.logPass("Select '" + depSubFareCard + "' subfare card for Depart flight for One Way Trip");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting Depart Farecard Flight Search");
		}
	}

	// FrareCard and SubFareCard selection for Round Trip on Flight Page
	public static void selectFareCardRT(String depFareCard, String depSubFareCard, String retFareCard,
			String retSubFareCard) throws Exception {
		try {
			CommonPageMethodUtil.subFareCard(depFareCard, depSubFareCard);
			Utilities.verifyTextEquals(selectedFareCard(depSubFareCard), depSubFareCard);
			reports.logPass("Select '" + depSubFareCard + "' subfare card for Depart flight for Round Trip");
			Utilities.clickWebElement(continueCardBTN);
			Utilities.scrollDown();
			Utilities.waitForAllElementVisibilty(flightClass, Constants.maxTime, Constants.poolingTime);
			CommonPageMethodUtil.subFareCard(retFareCard, retSubFareCard);
			Utilities.verifyTextEquals(selectedFareCard(retSubFareCard), retSubFareCard);
			Utilities.clickWebElement(continueCardBTN);
			reports.logPass("Select '" + retSubFareCard + "' subfare card for Return Flight for Round Trip");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting Depart/Return Farecard Flight Search");
		}
	}

	@SuppressWarnings("null")
	public static boolean checkFareCardAvailableForFlight(WebElement farecardElement) throws Exception {
		try {
			Thread.sleep(2000);
			boolean available = false;
			// boolean available = Utilities.verifyElementPresent(farecardElement);

			if (farecardElement != null) {
				available = true;
				Utilities.verifyElementPresentEX(farecardElement);
				reports.logPass(
						" : Verify   '" + farecardElement.getText() + "'  FareCard  is available for this flight");
			} else {
				System.out.println("'" + farecardElement.getText() + "'  FareCard is NOT avaialble for this flight");
				throw new Exception("Change Flight : Verify '" + farecardElement.getText()
						+ "' FareCard is NOT available for this flight");
			}
			return available;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while '" + farecardElement.getText() + "''FareCard Selection'  for  flight", e);
		}
	}

	// Check 'SubFare Card ' available for flight in 'Flight Details ' Page
	public static boolean checkSubFareCardAvailableForFlight(WebElement subFareCard, String depSubFareCard)
			throws Exception {
		try {
			Thread.sleep(2000);
			boolean available = Utilities.verifyElementPresent(subFareCard);

			if (available == true) {
				Utilities.verifyElementPresentEX(subFareCard);
				reports.logPass(" Verify '" + depSubFareCard + "' SubFareCard  is available for this flight");
			} else {
				System.out.println(
						"Verify	'" + depSubFareCard + "'SubFareCard service is NOT available for this flight");
				// reportLog.logPass(" Verify '" + depSubFareCard + "' SubFareCard service is
				// NOT available for this flight");
				throw new Exception(
						"Verify	'" + depSubFareCard + "'SubFareCard service is NOT available for this flight");
			}
			return available;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while '" + depSubFareCard + "'	SubFareCard Selection  for  flight", e);
		}
	}

	// FareCard selection for dynamically selection
	public static WebElement fareCardList(String fareCardName) throws Exception {
		try {

			List<WebElement> list = fareCardList();
			WebElement farecardElement = null;
			for (WebElement card : list) {
				if (card.getText().equalsIgnoreCase(fareCardName)) {
					farecardElement = card;
					break;
				}
			}
			return farecardElement;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting Farecard Flight Search");
		}
	}

	// Dynamic Sub FareCard selection for different flight segments in Flight
	// details page
	public static void subFareCard(String fareCard, String subFareCard) throws Exception {
		try {
			WebElement fareCardBtn = fareCardList(fareCard);
			System.out.println("Testdata fare card =>" + fareCard + " :  SubFareCard => " + subFareCard);

			boolean fareCardAvailable = checkFareCardAvailableForFlight(fareCardBtn);

			// select fare card
			Utilities.scrollToElementandClickElement(fareCardBtn);

			boolean subFareCardAvailable = checkSubFareCardAvailableForFlight(selectSubFareCard(subFareCard),
					subFareCard);

			@SuppressWarnings("unused")
			boolean flag = false;

			if (fareCardAvailable == true && subFareCardAvailable == true) {
				Set<String> farCardList = new LinkedHashSet<String>(Arrays.asList(LayoutHeader.fareCardList));
				Set<String> subFarCardList = new LinkedHashSet<String>(Arrays.asList(LayoutHeader.subFareCardList));

				if (farCardList.contains(fareCard)) {
					if (subFarCardList.contains(subFareCard)) {
						flag = true;
					} else
						throw new Exception(
								"Invalid subFare Card name in Testdata for Flight class. Please check Testdata!!!");
				} else
					throw new Exception(
							"Invalid Fare Card name in Testdata for Flight class. Please check Testdata!!!");

				// Select Subfare card
				if (flag = true) {
					Utilities.scrollToElementView(selectSubFareCardBTN(subFareCard));
					Utilities.jsCLick(selectSubFareCardBTN(subFareCard));
					// selectSubFareCardBTN(subFareCard).sendKeys(Keys.ENTER);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting Sub Farecard Flight Search");
		}
	}

	// Verify Flight route on Flight details page
	public static void verifyFlightRoute(int noOfBound, String origin1, String destination1) throws Exception {
		try {
			String flight1_TestData = origin1 + " to " + destination1;
			String flight2_TestData = destination1 + " to " + origin1;

			System.out.println("-----" + flight1_TestData + flight2_TestData);
			if (noOfBound == 1 && flight1_TestData
					.equalsIgnoreCase(Utilities.getAttributeValueOfElement(getFlightNameUI().get(0), "aria-label"))) {
				reports.logPass("Verify Flight route for OW is '" + flight1_TestData + "' in flight details page");
			} else if (noOfBound == 2
					&& flight1_TestData.equalsIgnoreCase(
							Utilities.getAttributeValueOfElement(getFlightNameUI().get(0), "aria-label"))
					&& flight2_TestData.equalsIgnoreCase(
							Utilities.getAttributeValueOfElement(getFlightNameUI().get(1), "aria-label"))) {
				reports.logPass("Verify Flight route for RT is '" + flight1_TestData + "' and '" + flight2_TestData
						+ "' in flight details page");
			} else {
				throw new Exception("Flight route is not correct in flight details page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Flight route is not correct in flight details page");
		}
	}

	/******* Payment page ********/

	// To enter debit/credit card details in payment page
	public static void enterCardDetails(String cardNumber, String cardExpiry, String cardCVV, String CardHolderName,
			String paymentMode) throws Exception {
		try {
			String month = cardExpiry.split("/")[0];
			String year = cardExpiry.split("/")[1];

			Utilities.scrollIntoView(cardNumInput);
			Utilities.isSelected(cardOptionRadioBTN);
			Utilities.moveToElementAndEnter(cardNumInput, cardNumber);
			Utilities.moveToElementAndClick(monthArrowBTN);
			Utilities.clickWebElement(monthInCard(month));
			Thread.sleep(1000);
			Utilities.moveToElementAndClick(yearArrowBTN);
			Utilities.clickWebElement(yearInCard(year));
			Thread.sleep(1000);
			Utilities.moveToElementAndEnter(cardHolderInput, CardHolderName);
			Utilities.moveToElementAndEnter(cvvInput, cardCVV);

			reports.logPass("Enter Card Details in Payments page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While entering Card Details in Payments page");
		}
	}

	// Get card details from Test data
	public static void getCardDetails() throws Exception {
		String cardType = GetTestData.PaymentMode.split("/")[1];

		System.out.println("Card type in testdata = " + cardType);
		if (cardType.equalsIgnoreCase(LayoutHeader.Amex_Card)) {
			cardNumber = GetTestData.Amex_CardNumber;
			cardExpiry = GetTestData.Amex_CardExpiry;
			cardCVV = GetTestData.Amex_CardCVV;
		} else if (cardType.equalsIgnoreCase(LayoutHeader.Visa_Card)) {
			cardNumber = GetTestData.Visa_CardNumber;
			cardExpiry = GetTestData.Visa_CardExpiry;
			cardCVV = GetTestData.Visa_CardCVV;
		} else if (cardType.equalsIgnoreCase(LayoutHeader.MasterCard_Card)) {
			cardNumber = GetTestData.MasterCard_CardNumber;
			cardExpiry = GetTestData.MasterCard_CardExpiry;
			cardCVV = GetTestData.MasterCard_CardCVV;
		} else if (cardType.equalsIgnoreCase(LayoutHeader.Mada_Card)) {
			cardNumber = GetTestData.Mada_CardNumber;
			cardExpiry = GetTestData.Mada_CardExpiry;
			cardCVV = GetTestData.Mada_CardCVV;
		} else {
			throw new Exception("Please check Payment Type in Testdata");
		}

		System.out.println("cardNumber : " + cardNumber + " = cardExpiry : " + cardExpiry + " = cardCVV : " + cardCVV);
	}

}
