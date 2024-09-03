package com.saudia.qa.pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.CommonMethodUtil;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class FlightPage extends TestBase {

	private static Logger Log = Logger.getLogger(FlightPage.class);
	private ReportLog reportLog;

	@CacheLookup
	@FindBy(id = "onewayTrip")
	public WebElement oneWayTrip;

	@CacheLookup
	@FindBy(id = "roundTrip")
	public WebElement roundTrip;

	@CacheLookup
	@FindBy(id = "multiTrip")
	public WebElement multicityTrip;

	@CacheLookup
	@FindBy(css = "div.widget__input.is-active>a>svg")
	public WebElement suggestionbox__clear_icon;

	@CacheLookup
	@FindBy(id = "from0")
	public WebElement FromWhere;

	@CacheLookup
	@FindBy(id = "to0")
	public WebElement ToWhere;

	@CacheLookup
	@FindBy(id = "cal0")
	public WebElement DepatureDate;

	@CacheLookup
	@FindBy(id = "searchNow")
	public WebElement SerachFlight;

	@CacheLookup
	@FindBy(xpath = "//label[text()='One Way']")
	public WebElement verifyTriplabel;
	@FindBy(xpath = "//span[text() = 'Select trip']")
	public WebElement selectTripButton;

	@FindBy(xpath = "//div[@class='pregress-stepper']//div[contains(@class,'active')]//span[text()='Flights']")
	public WebElement flightsTab;

	@CacheLookup
	@FindBy(xpath = "//div[text() = 'Select a preferred flight to get the best combinations. ']")
	public WebElement guideBlockPreferredFlightMC;

	@CacheLookup
	@FindBy(xpath = "//div[@class='tour-buttons']")
	public WebElement guideBlockPreferredFlightCloseMC;

	@CacheLookup
	@FindBy(xpath = "//div[@class='journey-fare']//h2[text()='Total Fare ']")
	public WebElement totalFarePopup;

	@FindBy(xpath = "//div[@class='fare-bottom-text']//span[1]")
	public WebElement totalSeatFare;

	@CacheLookup
	@FindBy(xpath = "//span[text()='Confirm & proceed']")
	public WebElement ConfirmButtonTotalFare;

	@FindBy(xpath = "(//div[@class='muticity-flight-price']/..//div[contains(@class,'cabin-cards mat-card')])[1]")
	public WebElement firstFlightBundleClass;

	@FindBy(xpath = "//div[@class='fare_amount']")
	public WebElement totalfareUI;

	/* fareCard selection */

	@FindBy(xpath = "//button[text()='Edit search ']")
	public WebElement editSearchBTN;

	@FindBy(xpath = "//div[@class = 'flightList ng-star-inserted']//app-jss-flight-record[1]")
	public WebElement flightCard;

	@FindBy(xpath = "//*[@class='mat-card-title title']/span")
	public WebElement selectedFareCardOW;

	@FindBy(xpath = "//*[text()='Guest Basic']")
	public WebElement selectedFareCard;

	@FindBy(xpath = "//span[text() = 'Select trip'][1]")
	public WebElement flightAvailable;

	@FindBy(xpath = "//div[@class='fare_summary_container']//div")
	public WebElement fareCardAmount;

	@FindBy(xpath = "//div[@class='muticity-flight-price-wrapper']")
	public WebElement fareCardAmountMC;

	public String selectedFareCardXpath;
	

	public static List<WebElement> fareCardList() {
		return driver.findElements(By.xpath("//mat-card-title[@class='mat-card-title title']"));
	}

	public static WebElement selectSubFareCard(String subFareCard) {
		return driver.findElement(By.xpath("//*[@aria-label='Select " + subFareCard + " Flight']"));
	}

	/* E-Visa */

	@FindBy(xpath = "//h3[text()='Visit Saudi Arabia']")
	public WebElement EvisaHeading;

	@FindBy(xpath = "//button[@aria-label='Click here for the visit Saudi Arabia promo']")
	public WebElement visitSaudiaBTN;

	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	public WebElement stopOverCityRadioBTN;

	@FindBy(xpath = "(//span[@class='mat-radio-label-content'])[2]//span[2]")
	public WebElement stopOverCityName;

	@FindBy(xpath = "//mat-select[@formcontrolname='stayDuration']")
	public WebElement stayDurationDRP;

	@FindBy(xpath = "(//mat-option/span)[2]")
	public WebElement TwoDaysOption;

	@FindBy(xpath = "//mat-select[@formcontrolname='stayDuration']//div/div/span/span")
	public WebElement stayDurationText;

	@FindBy(xpath = "//button[@id='showFlight']")
	public WebElement viewFlightsBTN;

	@FindBy(xpath = "//div[@class='flight-details-duration-badges']/span[2]")
	public WebElement stopOverText;

	@FindBy(xpath = "(//div[@class='flightcard-record'])[1]")
	public WebElement flighCard;

	@FindBy(xpath = "(//span[@class='mat-radio-container'])[1]")
	public WebElement selectFlight;

	public WebElement selectedFareCard(String subFareCard) {
		return driver.findElement(By.xpath("//*[text()='" + subFareCard + "']"));
	}

	
	public List<WebElement> selectTripButton() {
		// return driver.findElements(By.xpath("//div[@class='flightDetails-title']"));
		return driver.findElements(By.xpath("//div[@class='multicity-flight-view-button']"));
	}

	public List<WebElement> getFlightNameUI() {
		// return driver.findElements(By.xpath("//span[text() = 'Select trip']"));
		return driver.findElements(By.xpath("//div[@class='flightDetails-title']"));
	}

	public List<WebElement> getFlightNameUIMC() {
		return driver.findElements(By.xpath("//div[@class='multicity-flight-details-location']/span[1]"));
	}

	public List<WebElement> getFlightDateUI() {
		//return driver.findElements(By.xpath("//span[@class='journey-date']"));
		return driver.findElements(By.xpath("//span[contains(@class,'journey-date')]"));
	}

	public int AllFlightBundleClass() {
		return driver
				.findElements(By.xpath(
						"//div[@class='muticity-flight-price']/..//div[@class='cabin-cards mat-card business_card']"))
				.size();
	}

	public FlightPage(ReportLog reportLog) throws IOException {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("FlightPage - Intialize the Webelements in the driver");
	}

	public boolean verifyoneTripLabel() {
		return verifyTriplabel.isDisplayed();

	}

	public List<WebElement> pageNavigation() {
		return driver.findElements(By.xpath("//ul[@class='navlinks']/li/a"));
	}

	public List<WebElement> getsubFareCardList() {
		return driver.findElements(By.xpath("//div[@class='multicity-flight-bundle-right']/div[1]/div"));
	}

	public WebElement selectTripButtonMC(String selectedFareCardXpath, String subFareCardName) {
		String element = selectedFareCardXpath + "/div[text()=' " + subFareCardName
				+ " ']//parent::div/following-sibling::div//span[text()='Select trip']";
		return driver.findElement(By.xpath(element));
	}

	public WebElement tripFareButtonMC(String selectedFareCardXpath, String subFareCardName) {
		String element = selectedFareCardXpath + "/div[text()=' " + subFareCardName
				+ " ']//parent::div/following-sibling::div/div[1]";
		return driver.findElement(By.xpath(element));
	}

	public List<WebElement> getSelectedFareCardList() {
		//return driver.findElements(By.xpath("//div[@class='content-left-show']"));
		return driver.findElements(By.xpath("//span[@class='currency-value']"));
	}

	public WebElement pageNavigationBtn(int index) {
		return driver.findElement(By.xpath("//ul[@class='navlinks']//a[text()=" + index + "]"));
	}

	public void SelectonewayTripOprtion() {
		oneWayTrip.click();

	}

	public void enterDepatureCity() {
		try {
			suggestionbox__clear_icon.click();
			FromWhere.sendKeys(prop.getProperty("From", "NONE"), Keys.ENTER);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// Verify flight details page is opened or not
	public boolean verifyFlightDetailsPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(flightsTab, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Flight details page is opened");
			return Utilities.isDisplayed(flightsTab);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking flight details page is opened or not");
		}
	}

	// Close Tour guide block for preferred flight selection for MultiCity
	public void verifyTourGuideBlockForPreferredFlightsMC() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(guideBlockPreferredFlightMC, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Tour guide block for selecting preferred flights is opened");
			Utilities.MouseMove(200, 700);
			Utilities.LeftClickMouse();
			Utilities.waitForInvisibilityOfElement(guideBlockPreferredFlightMC, Constants.maxTime,
					Constants.poolingTime);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while handling guide tour block for selecting preferred flights in Multicity");
		}
	}

	// click on 'Select trip' button for first bundle in MultiCity
	public void selectFirstFlightBundleMC() throws Exception {
		try {
			Utilities.waitForAllElementVisibiltyList(selectTripButton(), Constants.maxTime, Constants.poolingTime);
			if (selectTripButton().size() > 0) {
				Utilities.clickWebElement(selectTripButton().get(0));
				reportLog.logPass("Select First flight search bundle for Multicity");
			} else {
				throw new Exception("There are no flights available for the selected route. Change the search");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while selecting first bundle for Multicity", e);
		}
	}

	// Click confirm and proceed in Total fare pop-up in MultiCity
	public String handleTotalFarePopupMC() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(totalFarePopup, Constants.maxTime, Constants.poolingTime);
			String fareAmount = Utilities.getText(totalSeatFare);
			reportLog.logPass("Verify 'Total Fare' pop-up is opened and click on Confirm button");
			Utilities.clickWebElement(ConfirmButtonTotalFare);
			return fareAmount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while clicking confirm button in Total Fares pop-up", e);
		}
	}

	// Verify flight class name is same as Test data for first bundle in MultiCity
	public void verifyClassForFirstBundleInMC(String flightClass) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(firstFlightBundleClass, Constants.maxTime, Constants.poolingTime);
			String text = Utilities.getText(firstFlightBundleClass);
			if (text.contains(flightClass)) {
				reportLog.logPass("Verify Flight class for bundle is " + flightClass);
			} else {
				throw new Exception("Verify Flight class for bundle is not " + flightClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking class for Flight bundle", e);
		}
	}

	// FrareCard and SubFareCard selection for Round Trip on Flight Page
	public void selectFareCardRT(String depFareCard, String depSubFareCard, String retFareCard, String retSubFareCard)
			throws Exception {
		
		CommonPageMethodUtil.selectFareCardRT(depFareCard, depSubFareCard, retFareCard, retSubFareCard);
	}

	// FrareCard and SubFareCard selection for One Way Trip on Flight Page
	public void selectFareCardOW(String depFareCard, String depSubFareCard) throws Exception {

		CommonPageMethodUtil.selectFareCardOW(depFareCard, depSubFareCard);
	}

	// verify flights are available on flight Page
	public void verifyFlightsAvailability() throws Exception {
		try {
			flightAvailable.isDisplayed();
			reportLog.logPass("Flights are available for the selected route in Flight Details page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("There are no flights available for the selected route. Change the search");
		}
	}

	// Get SubFareCard list and return Expected Sub-Farecard for Multicity
	public WebElement getsubFareCardList(String subFareCardName) throws Exception {
		try {
			try {
				WebElement fareCard = null;
				boolean flag = false;
				for (int page = 1; page <= pageNavigation().size(); page++) {
					if (page <= pageNavigation().size() && flag == false) {
						List<WebElement> list = getsubFareCardList();
						for (WebElement card : list) {
							if (card.getText().equalsIgnoreCase(subFareCardName)) {
								selectedFareCardXpath = card.toString().substring(91, 143);
								fareCard = selectTripButtonMC(selectedFareCardXpath, subFareCardName);
								flag = true;
								break;
							}
						}
					}
					if (flag) {
						break;
					} else {
						Utilities.clickWebElement(pageNavigationBtn(page + 1));
					}
				}
				return fareCard;
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(subFareCardName + " List is not available for selected flight");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While getting sub-Farecard list for Flight Search");
		}
	}

	// Dynamic selection Sub-Farecard for Multicity route
	public String selectSubFareCardMC(String flightClass, String depSubFareCard) throws Exception {
		try {
			Utilities.waitForAllElementVisibiltyList(selectTripButton(), Constants.maxTime, Constants.poolingTime);
			if (selectTripButton().size() > 0) {
				WebElement subFareCardBtn = getsubFareCardList(depSubFareCard);
				boolean subFareCardAvailable = CommonPageMethodUtil.checkSubFareCardAvailableForFlight(subFareCardBtn, depSubFareCard);

				if (subFareCardAvailable == false) {
					System.out.println("'" + depSubFareCard + "'  FareCard is NOT avaialble for this flight");
				}
				// String seatFare = Utilities.getText();
				String subTotalAmount = tripFareButtonMC(selectedFareCardXpath, depSubFareCard).getText();
				Utilities.clickWebElement(subFareCardBtn);
				reportLog.logPass("Select '" + depSubFareCard + "' SubFare card in Flight details page");
				return subTotalAmount;
			} else {
				throw new Exception(depSubFareCard + " is not available for selected flight. Please change the search");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while selecting subfare card for for Multicity", e);
		}
	}

	// Transit E-Visa section on Home page
	public void visitSaudiEVisa() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(EvisaHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElementView(visitSaudiaBTN);
			Utilities.clickWebElement(visitSaudiaBTN);
			Utilities.clickWebElement(stopOverCityRadioBTN);
			reportLog.logPass("Select city for stopover flight");
			Utilities.moveToElementAndClick(selectFlight);

			String selectedCity = Utilities.getText(stopOverCityName);
			System.out.println("Selected City is : " + selectedCity);
			Utilities.clickWebElement(stayDurationDRP);
			Utilities.clickWebElement(TwoDaysOption);
			Utilities.verifyTextEquals(stayDurationText, GetTestData.eVisa_Duration);

			reportLog.logPass("Select " + GetTestData.eVisa_Duration + "for stay for eVisa");

			Utilities.clickWebElement(viewFlightsBTN);
			reportLog.logPass("Click on View Flights Button");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While selecting farecard on Home page");
		}
	}

	// Verify Selected fare card amount in flight details page for OW and RT
	public double verifySelectedFareCardAmount() throws Exception {

		double subTotalAmount = 0;
		List<WebElement> fareAmount = getSelectedFareCardList();
		System.out.println(fareAmount);
		for (WebElement amount : fareAmount) {
			double selectedfareCardAmount = CommonMethodUtil.getDoubleValueFromString(amount.getText().trim());
			subTotalAmount = subTotalAmount + selectedfareCardAmount;
		}
		Thread.sleep(2500);

		String fareCardAmt = "SAR " + String.format("%,.2f", subTotalAmount);
		System.out.println("Addition of fare Card Amount on UI =>" + fareCardAmt);

		boolean flag = false;
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2500);
			String totalfareCardAmount = fareCardAmount.getText().trim();
			System.out.println("Total fareCard Amount on UI ==>" + totalfareCardAmount);

			if (totalfareCardAmount.equalsIgnoreCase(fareCardAmt)) {
				reportLog.logPass("Verify 'Total Amount' for selected fare card");
				flag = true;
				break;
			}
		}

		if (flag != true) {
			throw new Exception("Error while Verifying FareCard selected total amount");
		}
		return subTotalAmount;
	}

	// Verify Selected fare card amount in flight details page for MC
	public double verifySelectedFareCardAmountMC(String seatFare, String fareAmount) throws Exception {

		Thread.sleep(2500);

		if (seatFare.equalsIgnoreCase(fareAmount)) {
			reportLog.logPass("Verify FareCard selected total amount");
		} else {
			throw new Exception("Error while Verifying FareCard selected total amount");
		}

		double subTotalAmount = CommonMethodUtil.getDoubleValueFromString(fareAmount.split(" ")[1]);
		return subTotalAmount;
	}

	// Verify Flight route on Flight details page
	public void verifyFlightRoute(int noOfBound, String origin1, String destination1) throws Exception {
		CommonPageMethodUtil.verifyFlightRoute(noOfBound, origin1, destination1);
	}

	// Verify Flight Dates on Flight details page

	public void verifyFlightDates(int noOfBound, String departingDate, String departingMonth, String returnDate,
			String retunMonth) throws Exception {
		try {

			String flight1_TestData = departingDate + " " + departingMonth;
			String flight2_TestData = returnDate + " " + retunMonth;

			if (noOfBound == 1 && Utilities.getText(getFlightDateUI().get(0)).contains(flight1_TestData)) {
				Log.info("Date of departure flight = "+ flight1_TestData );
				reportLog.logPass(
						"Verify Flight route Date for OW is '" + flight1_TestData + "' in flight details page");

			} else if (noOfBound == 2 && Utilities.getText(getFlightDateUI().get(0)).contains(flight1_TestData)
					&& Utilities.getText(getFlightDateUI().get(1)).contains(flight2_TestData)) {
				Log.info("Date of departure flight = "+ flight1_TestData + " | return Date = "+ flight2_TestData);
				reportLog.logPass("Verify Flight Date for RT is '" + flight1_TestData + "' and '" + flight2_TestData
						+ "' in flight details page");
			} else {
				throw new Exception("Flight Date is not correct in flight details page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Flight route Date is not correct in flight details page");
		}
	}

	// Verify Flight route and dates for MC on Flight details page
	public void verifyFlightRouteAndDateMC(int noOfBound, String[] route, List<String> departingMonthDataMC,
			List<String> departingDateDataMC) throws Exception {
		try {

			for (int i = 0; i < noOfBound; i++) {
				String flight_TestData = route[i] + "-" + departingMonthDataMC.get(i).substring(0, 3)
						+ departingDateDataMC.get(i);

				flight_TestData = flight_TestData.replaceAll("\\s", "");
				if (noOfBound > 2 && flight_TestData
						.equalsIgnoreCase(Utilities.getText(getFlightNameUIMC().get(i)).replaceAll("\\s", ""))) {
					reportLog.logPass("Verify Flight route and Date on Flight details page");
				} else {
					throw new Exception("Flight route is not correct in flight details page");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Flight route is not correct in flight details page");
		}
	}

	// Get total fare amount from Flight details page
	public String getTotalFareAmount() throws Exception {
		try {
			return Utilities.getText(totalfareUI);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Error while getting total fare in flight details page");
		}
	}

}
