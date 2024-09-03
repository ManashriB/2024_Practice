package com.saudia.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;
import com.saudia.qa.util.LayoutHeader;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class SeatsAndExtras extends TestBase {

	private static Logger Log = Logger.getLogger(SeatsAndExtras.class);
	private ReportLog reportLog;

	@FindBy(xpath = "//span[contains(text(),'Next Flight')]")
	public WebElement nextFlightBTN;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public WebElement confirmBTN;

	public List<WebElement> ancillaryList() {
		return driver.findElements(By.xpath("//span[@class='ancillary-name ng-star-inserted' or @class='service-name ng-star-inserted']"));
	}

	@FindBy(xpath = "//div[contains(@class,'fare_amount')]")
	public WebElement totalfareUI;
	
	/* Fast Track */
	@FindBy(xpath = "//*[text()='Add Fast Track']")
	public WebElement addFastTrackBTN;

	@FindBy(xpath = "//span[contains(text(),'Fast Track')]")
	public WebElement fastTrackAddedText;

	@FindBy(xpath = " //span[text()=' directions_run ']//..//..//div[@class = 'ancillary-content']/p")
	public WebElement totalAmoutFastTrack;

	@FindBy(xpath = "//button[@aria-label='Modify Fast Track']")
	public WebElement modifyFastTrackLink;

	/* Altanfeethi VIP Service */

	@FindBy(xpath = "//span[contains(text(),'Altanfeethi VIP Service')]")
	public WebElement altanfeethiVIPServiceText;

	@FindBy(xpath = "//*[text()='Add services']")
	public WebElement addALTVIPSrviceBTN;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement editALTVIPSelectBTN;

	@FindBy(xpath = "//*[contains(text(),'ALTANFEETHI VIP Service')]")
	public WebElement addALTVIPServiceTitle;

	@FindBy(xpath = "//*[contains(@aria-label,'Click here to select')]")
	public WebElement addALTVIPSelectBTN;

	@FindBy(xpath = "//*[contains(@aria-label,'Radio button 1 of 3 unselected. Departure service')]")
	public WebElement selectALTVIPDeptService;

	@FindBy(xpath = "//span[contains(text(),'Altanfeethi VIP Service')]/following-sibling::p")
	public WebElement altanfeethiTotalAmoutText;

	@FindBy(xpath = "//span[contains(text(),'Altanfeethi VIP Service')]//parent::div/following-sibling::div//span[text()='Modify']")
	public WebElement altanfeethiModifyVIPService;

	@FindBy(xpath = "//*[text()=' Proceed to payment']")
	public WebElement proceedToPaymentBTN;

	@FindBy(xpath = "//*[@aria-label='Skip to Payment']")
	public WebElement skipToPaymentBTN;

	/* Extra Baggage */
	@FindBy(xpath = "//*[text()='Add baggage']")
	public WebElement addBaggageBTN;

	@FindBy(xpath = "//*[contains(text(),'Extra baggage')]")
	public WebElement extraBaggageTitle;

	@FindBy(xpath = "//span[contains(text(),'Baggages added')]")
	public WebElement baggagedAddedText;

	@FindBy(xpath = "//span[contains(text(),'Baggages added')]/following-sibling::p")
	public WebElement totalAmoutText;

	@FindBy(xpath = "//button[@aria-label='Modify Extra Baggage']")
	public WebElement modifyExtraBaggage;

	@FindBy(xpath = "//span[text()='Seats & Extras']")
	public WebElement seatAndExtrasHeading;

	/* Seat Selection Service */

	@FindBy(xpath = "//span[@aria-label='Seat selection button']")
	public WebElement addSeatSelectBTN;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement editSeatSelectBTN;

	@FindBy(xpath = "//*[contains(text(),'Seat Selection')]")
	public WebElement addSeatSelectionTitle;

	@FindBy(xpath = "//span[contains(text(),'1 Seat selected')]")
	public WebElement seatSelectedText;

	/*
	 * @FindBy(xpath = "//*[contains(@aria-label,'Click here to select')]") public
	 * WebElement addALTVIPSelectBTN;
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(@aria-label,'Radio button 1 of 3 unselected. Departure service')]"
	 * ) public WebElement selectALTVIPDeptService;
	 */

	@FindBy(xpath = "//span[contains(text(),'Seat selected')]/following-sibling::p")
	public WebElement seatSelectionTotalAmoutText;

	@FindBy(xpath = "//span[contains(text(),'Seat selected')]//parent::div/following-sibling::div//span[text()='Modify']")
	public WebElement seatSelectionModifyService;

	/* eVisa */
	@FindBy(xpath = "//span[text()='Get E-Visa']")
	public WebElement getEvisaBTN;
	
	@FindBy(xpath = "//span[contains(text(),'Transit E-Visa')]")
	public WebElement eVisaAddedText;
	
	@FindBy(xpath = "//span[contains(text(),'Transit E-Visa')]/following-sibling::p")
	public WebElement eVisatotalAmountText;
	
	@FindBy(xpath = "//span[text() = 'Remove transit E-Visa']")
	public WebElement removeEvisaLink;
	
	@FindBy(xpath = "//h2[text()='Remove transit E-Visa']")
	public WebElement removeEvisaPopupHeading;
	
	@FindBy(xpath = "//button[@aria-label='Remove ']")
	public WebElement removeEvisaButton;
	
//	https://www.saudia.com/en-SA/booking/passengerDetails

	public SeatsAndExtras(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	/*
	 * public void addBaggage() throws Throwable { try {
	 * Utilities.moveToElementAndClick(addBaggageBTN);
	 * Utilities.waitForAllElementVisibilty(extraBaggageTitle, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addBaggageBTN);
	 * Utilities.moveToElementAndClick(nextFlightBTN);
	 * Utilities.waitForAllElementVisibilty(extraBaggageTitle, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addBaggageBTN);
	 * Utilities.moveToElementAndClick(confirmBTN);
	 * reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); reportLog.logFail("Error",
	 * "While clicking on Continue to Passengern"); throw new
	 * Exception("Error While clicking on Continue to Passenger"); } }
	 */
	/*
	 * public void addFastTrackOW() throws Throwable { try {
	 * Utilities.waitForAllElementVisibilty(addFastTrackBTN, Constants.maxTime,
	 * Constants.poolingTime); Utilities.scrollToElement(addFastTrackBTN);
	 * Utilities.jsCLick(addFastTrackBTN);
	 * Utilities.waitForAllElementVisibilty(fastTrackTitle, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addFastTrackPlusBTN);
	 * Utilities.moveToElementAndClick(confirmBTN);
	 * reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); reportLog.logFail("Error",
	 * "While clicking on Continue to Passengern"); throw new
	 * Exception("Error While clicking on Continue to Passenger"); } }
	 * 
	 * public void addFastTrack() throws Throwable { try {
	 * Utilities.waitForAllElementVisibilty(addFastTrackBTN, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addFastTrackBTN);
	 * Utilities.waitForAllElementVisibilty(fastTrackTitle, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addFastTrackPlusBTN);
	 * Utilities.moveToElementAndClick(nextFlightBTN);
	 * Utilities.waitForAllElementVisibilty(fastTrackTitle, Constants.maxTime,
	 * Constants.poolingTime); Utilities.moveToElementAndClick(addFastTrackPlusBTN);
	 * Utilities.moveToElementAndClick(confirmBTN);
	 * reportLog.logPass("Continue to Passenger", "has been selected sucessfully");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); reportLog.logFail("Error",
	 * "While clicking on Continue to Passengern"); throw new
	 * Exception("Error While clicking on Continue to Passenger"); } }
	 */
	public void addALTANFEETHIOW() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(addALTVIPSrviceBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(addALTVIPSrviceBTN);
			Utilities.jsCLick(addALTVIPSrviceBTN);
			Utilities.waitForAllElementVisibilty(addALTVIPServiceTitle, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(addALTVIPSelectBTN);
			Utilities.waitForAllElementVisibilty(selectALTVIPDeptService, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(selectALTVIPDeptService);
			Utilities.moveToElementAndClick(confirmBTN);
			reportLog.logPass("Continue to Passenger", "has been selected sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			reportLog.logFail("Error", "While clicking on Continue to Passengern");
			throw new Exception("Error While clicking on Continue to Passenger");
		}
	}

	// Click on 'proceed to payment' button
	public void proceedToPayment() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(proceedToPaymentBTN);
			reportLog.logPass("Click on Proceed to payment button");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on proceedToPaymentBTN");
		}
	}

	// Click on 'Skip to payment' button
	public void skipToPayment() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(skipToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(skipToPaymentBTN);
			reportLog.logPass("Click on Skip to payment button");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while clicking on Skip to Payment button ", e);
		}
	}

	// Click on Add baggage button for 'Extra Baggage' in 'Seats and Extras' page
	public void clickOnAddExtraBaggageBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(addBaggageBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(addBaggageBTN);
			Utilities.clickWebElement(addBaggageBTN);
			Utilities.waitForAllElementVisibilty(extraBaggageTitle, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Click on Extra Baggage Option in 'Seats and Extras' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Continue to Passenger");
		}
	}

	// Verify Extra bags are added or removed in 'Seats and Extras' page
	public void verifyExtraBagsAreAdded(int bagsToAdd, String totalAmount) throws Exception {
		try {
			// String perBagAmount = totalAmount.split(" ")[1];
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.verifyTextEquals(baggagedAddedText,
					bagsToAdd + " " + LayoutHeader.Anscillary_ExtraBaggages_Added);
			Utilities.verifyTextEquals(totalAmoutText, totalAmount);
			Utilities.verifyElementPresent(modifyExtraBaggage);
			reportLog.logPass("Verify Extra Baggages count and amount in 'Seats and Extras' Page. Total " + bagsToAdd
					+ " baggages are added for amount " + totalAmount);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying added bags per passenger", e);
		}
	}

	// Click on modify link for 'Extra Baggage' in 'Seats and Extras' page
	public double clickOnModifyExtraBaggageLink() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			double totalAmount = Double
					.parseDouble(Utilities.getText(totalAmoutText).split(" ")[1].replaceAll(",", ""));
			Utilities.clickWebElement(modifyExtraBaggage);
			reportLog.logPass("Click on Modify Baggage link in 'Seats And Extras page'");
			return totalAmount;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error clicking Modify link for extra baggage", e);
		}
	}

	// Click on Add baggage button for 'Extra Baggage' in 'Seats and Extras' page
	public void clickOnSelectSeatBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(addSeatSelectionTitle, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(addSeatSelectBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(addSeatSelectBTN);
			Utilities.clickWebElement(addSeatSelectBTN);
			reportLog.logPass("Click on Seat Selection Option in 'Seats and Extras' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Continue to Passenger");
		}
	}

	// Verify seat And Extras details page is opened or not
	public void verifySeatAndExtrasPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(seatAndExtrasHeading, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify 'Seat And Extras' details page is opened");
			Utilities.isDisplayed(seatAndExtrasHeading);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking seat And Extras details page is opened or not");
		}
	}

	// Verify 'Fast Track' option is available in 'Seats and Extras' Page
	public void checkFastTrackOptionIsPresent() throws Exception {
		try {
			List<WebElement> anscillary = ancillaryList();

			boolean anscillaryPresent = false;

			for (int i = 0; i < anscillary.size(); i++) {
				System.out.println("Anscillary options = " + anscillary.get(i).getText());
				if (anscillary.get(i).getText().equalsIgnoreCase(LayoutHeader.Anscillary_FastTrack_Heading)
						|| anscillary.get(i).getText().toLowerCase()
								.contains(LayoutHeader.Anscillary_FastTrack_Heading.toLowerCase())) {
					anscillaryPresent = true;
					break;
				} else {
					anscillary.get(i).click();
					Utilities.keyPress(Keys.ARROW_DOWN, 3);
				}
			}
			if (!anscillaryPresent) {
				throw new Exception("Fast Track option not available for this route. Please check the Route");
			}
			reportLog.logPass("Verify 'Fast Track' option is present in 'Seat and Extras' page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking Fast Track Option is present or not");
		}
	}

	// Click on Add Fast Track button for 'Extra Baggage' in 'Seats and Extras' page
	public void clickOnAddFastTrackBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(addFastTrackBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(addFastTrackBTN);
			reportLog.logPass("Click on 'Add Fast Track' Option in 'Seats and Extras' Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Add Fast Track Option");
		}
	}

	// Verify Extra bags are added in 'Seats and Extras' page
	public void verifyFastTrackAdded(String totalAmount, int noOfFastTrack) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);

			/*
			 * BUG - Utilities.verifyTextEquals(fastTrackAddedText, noOfFastTrack + " " +
			 * LayoutHeader.Anscillary_FastTrack_Added);
			 */

			Utilities.verifyTextEquals(totalAmoutFastTrack, totalAmount);
			Utilities.verifyElementPresentEX(modifyFastTrackLink);
			reportLog.logPass("Verify that " + noOfFastTrack + " 'Fast Track' is added and for amount " + totalAmount
					+ " in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying fast track added", e);
		}
	}

	// Click on Modify Fast Track button for 'Extra Baggage' in 'Seats and Extras'
	// page
	public void clickOnModifyFastTrackBTN() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(modifyFastTrackLink, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(modifyFastTrackLink);
			reportLog.logPass("Click on 'Modify' Fast Track link in 'Seats and Extras' Page");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Modify Fast Track Option");
		}
	}

	// Verify Fast Track removed in 'Seats and Extras' page
	public void verifyFastTrackremoved() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(skipToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			checkFastTrackOptionIsPresent();
			Utilities.verifyElementPresentEX(addFastTrackBTN);
			reportLog.logPass("Verify all 'Fast Track' anscillaries are removed 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying fast track removed", e);
		}
	}

	// Verify Altanfeethi VIP Services option is available in 'Seats and Extras'
	// Page
	public void checkAltanfeethiVIPServiceOptionIsPresent() throws Exception {
		try {
			List<WebElement> anscillary = ancillaryList();

			boolean anscillaryPresent = false;

			for (int i = 0; i < anscillary.size(); i++) {
				if (anscillary.get(i).getText().equalsIgnoreCase(LayoutHeader.Anscillary_Altanfeethi_Heading)
						|| anscillary.get(i).getText().contains(LayoutHeader.Anscillary_Altanfeethi_Heading)) {
					anscillaryPresent = true;
					System.out.println("Anscillary Present  = " + anscillary.get(i).getText());
					break;
				} else {
					anscillary.get(i).click();
					Utilities.keyPress(Keys.ARROW_DOWN, 3);
				}
			}
			if (!anscillaryPresent) {
				throw new Exception(
						" Altanfeethi VIP Service option not available for this route. Please check the Route");
			}
			reportLog.logPass("Verify 'Altanfeethi VIP Service' option is present in 'Seat and Extras' page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking Altanfeethi VIP Service Option is present or not");
		}
	}

	// Click on Altanfeethi VIP 'Add Service'on 'Seat and Extras' Page
	public void clickOnAddALTANFEETHIBTN() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(addALTVIPSrviceBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(addALTVIPSrviceBTN);
			Utilities.jsCLick(addALTVIPSrviceBTN);
			reportLog.logPass("Click on Altanfeethi VIP 'Add Service' option");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Altanfeethi VIP 'Add Service' on 'Seat and Extras Page'");
		}
	}

	// Verify Altanfeethi are added in 'Seats and Extras' page
	public void verifyAltanfeethiAdded(String totalAmount, int noOfALTBound) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);

			if (noOfALTBound == 1) {
				Utilities.verifyTextEquals(altanfeethiVIPServiceText,
						noOfALTBound + " " + LayoutHeader.Anscillary_Altanfeethi_Added_1);
			} else
				Utilities.verifyTextEquals(altanfeethiVIPServiceText,
						noOfALTBound + " " + LayoutHeader.Anscillary_Altanfeethi_Added_MoreThan_1);

			Utilities.verifyTextEquals(altanfeethiTotalAmoutText, totalAmount);
			Utilities.verifyElementPresentEX(altanfeethiModifyVIPService);
			reportLog.logPass("Verify " + noOfALTBound + " Altanfeethi added and for amount " + totalAmount
					+ "in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Altanfeethi added", e);
		}
	}

	// Verify Altanfeethi are added or removed in 'Seats and Extras' page
	public void verifyAltanfeethiModifiy(String totalAmount, int noOfALTBound) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(skipToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.verifyTextEquals(altanfeethiVIPServiceText, LayoutHeader.Anscillary_FastTrack_Added);
			Utilities.verifyElementPresent(altanfeethiVIPServiceText);
			reportLog.logPass("Verify " + noOfALTBound + " Altanfeethi VIP Service Modify in 'Seats and Extras' Page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Altanfeethi VIP Service Modified", e);
		}
	}

	// Click on Altanfeethi VIP Link 'Modify Service'on 'Seat and Extras' Page
	public void clickModifyALTANFEETHILink() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(altanfeethiModifyVIPService, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(altanfeethiModifyVIPService);
			Utilities.jsCLick(altanfeethiModifyVIPService);
			reportLog.logPass("Clicked on Altanfeethi VIP 'Modify Service' sucessfully on 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Altanfeethi VIP 'Modify Service' on 'Seat and Extras Page'");
		}
	}

	// Verify Altanfeethi VIP Service removed in 'Seats and Extras' page
	public void verifyAltanfeethiRemoved() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(skipToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			checkAltanfeethiVIPServiceOptionIsPresent();
			reportLog.logPass("Verify all 'Altanfeethi' anscillaries are removed in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Altanfeethi removed", e);
		}
	}

	// Verify Seat Select Services option is available in 'Seats and Extras'
	// Page
	public void checkSeatSelectionOptionIsPresent() throws Exception {
		try {
			List<WebElement> anscillary = ancillaryList();
			boolean anscillaryPresent = false;

			for (int i = 0; i < anscillary.size(); i++) {
				if (anscillary.get(i).getText().equalsIgnoreCase(LayoutHeader.Anscillary_SeatSelection_Heading)
						|| anscillary.get(i).getText().contains(LayoutHeader.Anscillary_SeatSelection_Heading)) {
					anscillaryPresent = true;
					System.out.println("Anscillary Present  = " + anscillary.get(i).getText());
					break;
				} else {
					anscillary.get(i).click();
					Utilities.keyPress(Keys.ARROW_DOWN, 3);
				}
			}
			if (!anscillaryPresent) {
				throw new Exception(" Seat Selection option not available for this route. Please check the Route");
			}
			reportLog.logPass("Verify 'Seat Selection' option is present in 'Seat and Extras' page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking Seat Selection Option is present or not");
		}
	}

	// Click on Seat Selected 'Add Service'on 'Seat and Extras' Page
	public void clickOnSeatSelectionBTN() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(addSeatSelectBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(addSeatSelectBTN);
			Utilities.jsCLick(addSeatSelectBTN);
			reportLog.logPass("Click on Seat Selection 'Add Service' option");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Seat Selection 'Add Service' on 'Seat and Extras Page'");
		}
	}

	// Verify Seat Selected in 'Seats and Extras' page
	public void verifySeatSelected(String totalAmount, int noOfALTBound) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);

			Utilities.verifyTextEquals(seatSelectedText,
					noOfALTBound + " " + LayoutHeader.Anscillary_SeatSelection_Added);

			Utilities.verifyTextEquals(seatSelectionTotalAmoutText, totalAmount);
			Utilities.verifyElementPresentEX(seatSelectionModifyService);
			reportLog.logPass("Verify " + noOfALTBound + " Seat Selected and for amount " + totalAmount
					+ "in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Altanfeethi added", e);
		}
	}

	// Click on Seat Selected 'Modify Service'on 'Seat and Extras' Page
	public void clickModifySeatSelecetedLink() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(seatSelectionModifyService, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(seatSelectionModifyService);
			Utilities.jsCLick(seatSelectionModifyService);
			reportLog.logPass("Clicked on Seat Selected 'Modify Service' sucessfully on 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on Seat Selected 'Modify Service' on 'Seat and Extras Page'");
		}
	}

	// Verify on Seat Selected 'Service removed'on 'Seat and Extras' Page
	public void verifySelecetdSeatRemoved() throws Exception {
		try {
			// Utilities.waitForAllElementVisibilty(skipToPaymentBTN, Constants.maxTime,
			// Constants.poolingTime);
			checkSeatSelectionOptionIsPresent();
			reportLog.logPass("Verify all 'Selected Seats' are removed in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Selected seat removed", e);
		}
	}

	// Verify Transit E-Visa option is available in 'Seats and Extras' Page
	public void checkEVisaOptionIsPresent() throws Exception {
		try {
			List<WebElement> anscillary = ancillaryList();

			boolean anscillaryPresent = false;

			for (int i = 0; i < anscillary.size(); i++) {
				if (anscillary.get(i).getText().equalsIgnoreCase(LayoutHeader.Anscillary_Transit_eVisa)
						|| anscillary.get(i).getText().contains(LayoutHeader.Anscillary_Transit_eVisa)) {
					anscillaryPresent = true;
					System.out.println("Anscillary Present  = " + anscillary.get(i).getText());
					break;
				} else {
					anscillary.get(i).click();
					Utilities.keyPress(Keys.ARROW_DOWN, 3);
				}
			}
			if (!anscillaryPresent) {
				throw new Exception(
						" 'Transit E-Visa' option not available for this route. Please check the Route");
			}
			reportLog.logPass("Verify 'Transit E-Visa' option is present in 'Seat and Extras' page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking 'Transit E-Visa' Option is present or not");
		}
	}

	// Click on Get E-Visa option on 'Seat and Extras' Page
	public void clickGetEvisaBTN() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(getEvisaBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(getEvisaBTN);
			Utilities.jsCLick(getEvisaBTN);
			reportLog.logPass("Click on 'Get E-Visa' button in 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While clicking on 'Get E-Visa' button in 'Seat and Extras Page'");
		}
	}

	// Click on modify E-Visa link on 'Seat and Extras' Page
	public void clickModifyEVisa() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(removeEvisaLink, Constants.maxTime, Constants.poolingTime);
			Utilities.scrollToElement(removeEvisaLink);
			Utilities.jsCLick(removeEvisaLink);
			reportLog.logPass("Click on 'Remove E-Visa' link in 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Click on 'Remove E-Visa' link in 'Seat and Extras Page' ");
		}
	}

	// Remove eVisa in 'Seat and Extras' Page
	public void removeEvisa() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(removeEvisaPopupHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.jsCLick(removeEvisaButton);
			Utilities.verifyElementPresentEX(getEvisaBTN);
			reportLog.logPass("Click on 'Remove' button to remove eVisa in 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Click on 'Remove' button to remove eVisa in 'Seat and Extras Page' ");
		}
	}

	// Verify eVisa is added in 'Seats and Extras' page
	public void verifyEVisaAdded(String totalAmount, int noOfeVisa) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(proceedToPaymentBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.verifyTextEquals(eVisaAddedText, noOfeVisa + " " + LayoutHeader.Anscillary_eVisa_Added);

			Utilities.verifyTextEquals(eVisatotalAmountText, totalAmount);
			Utilities.verifyElementPresentEX(removeEvisaLink);
			reportLog.logPass("Verify that " + noOfeVisa + " 'eVisa' is added and for amount " + totalAmount
					+ " in 'Seats and Extras' Page.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying eVisa added", e);
		}
	}

	//Verify eVisa is removed
	public void verifyEVisaRemoved() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(getEvisaBTN, Constants.maxTime, Constants.poolingTime);
			Utilities.verifyElementPresentEX(getEvisaBTN);
			reportLog.logPass("Verify eVisa is removed in 'Seat and Extras Page' ");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Verify eVisa is removed in 'Seat and Extras Page' ");
		}
	}
	
	// Get total fare amount from Seats and Extras page
		public double getTotalFareAmount() throws Exception {
			try {
				return Double.parseDouble(Utilities.getText(totalfareUI).replaceAll("[^0-9.]", ""));
			} catch (Exception e) {
				System.out.println(e);
				throw new Exception("Error while getting total fare in flight details page");
			}
		}

}
