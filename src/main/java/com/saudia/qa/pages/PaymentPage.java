package com.saudia.qa.pages;

import java.util.ArrayList;
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
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.LayoutHeader;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class PaymentPage extends TestBase {

	private static Logger Log = Logger.getLogger(PaymentPage.class);
	private ReportLog reportLog;

	@FindBy(xpath = "//span[text()='Payment']")
	public WebElement paymentPageHeading;

	/* Header */
	@FindBy(xpath = "//div[@class='flight-booking-summary']//h1")
	public WebElement FlightNamesHeader;

	@FindBy(xpath = "//div[@class='flight-booking-summary']//div")
	public WebElement FlightDateHeader;

	/* Passengers Section */

	@FindBy(xpath = "//section[contains(@class,'passengers-summary-detail')]//h2")
	public WebElement passengerSectionHeading;

	@FindBy(xpath = "//span[@class='ph-number']")
	public WebElement contactNo;

	@FindBy(xpath = "(//span[@class='email-address ltr'])[1]")
	public WebElement emailAddress;

	@FindBy(xpath = "//div[@class='passenger-name']/h3")
	public WebElement paxName;

	/* Payment Method Section */
	@FindBy(xpath = "//h2[text() = 'Payment Method']")
	public WebElement paymentMethodSectionHeading;

	@FindBy(xpath = "//span[@aria-label='Credit/Debit card']")
	public WebElement cardOptionTitle;

	@FindBy(xpath = "//*[@formcontrolname='paymentMethod']//input[@id='SADAD-input']")
	public WebElement sadadRadioBTN;

	@FindBy(xpath = "//div[@class='promo-code-detail']")
	public WebElement promoCodeHeading;

	@FindBy(xpath = "//h3[@class='tot-fare-title']")
	public WebElement totalFareSectionHeading;

	@FindBy(xpath = "//div[@class='fare-detail']//div[@class='title-wallet']/div")
	public WebElement totalFareAmount;

	@FindBy(xpath = "//h5[text()='Extras']")
	public WebElement extrasInTotalDare;
	
	@FindBy(xpath = "//section[contains(@class, 'fare-terms')]//mat-checkbox//span")
	public WebElement consentCheckbox;
	
	@FindBy(xpath = "//app-jss-total-fare-details//button[contains(@class,'pay-button')]")
	public WebElement payButton;
	
	@FindBy(xpath = "//div[@class='custom-dialog payment-loader-dialog']")
	public WebElement paymentLoader;


	/* Seats and Extras Section */

	@FindBy(xpath = "//div[@class='seat-summary']//h2")
	public WebElement seatsSectionHeading;

	// div[@class='seat-summary']//div[@class='summary-card ng-star-inserted']//a
	public List<WebElement> ancillaryTitleList() {
		return Utilities.driver.findElements(
				By.xpath("//div[@class='seat-summary']//div[@class='summary-card ng-star-inserted']//h3"));
	}

	public WebElement ancillaryCountList(int index) {
		return Utilities.driver.findElement(By.xpath("(//div[@class='seats-info']//div[2])[" + index + "]"));
	}

	public List<WebElement> ancillaryCountListNew() {
		return Utilities.driver.findElements(By.xpath("//div[@class='seats-info']//div[2]"));
	}

	/* Payment completion page*/
	
	@FindBy(xpath = "(//p[@class='pnr-info'])[1]")
	public WebElement bookingReferencePNR;
	
	@FindBy(xpath = "(//p[@class='pnr-info'])[2]")
	public WebElement numericBookingReference;
	
	@FindBy(xpath = "(//p[@class='pnr-info'])[3]")
	public WebElement bookingDate;
	
	@FindBy(xpath = "(//p[@class='pnr-title ng-star-inserted'])[1]")
	public WebElement bookingReferencePNRHeading;
	
	@FindBy(xpath = "(//p[@class='pnr-title ng-star-inserted'])[2]")
	public WebElement numericBookingReferenceHeading;
	
	@FindBy(xpath = "(//p[@class='pnr-title ng-star-inserted'])[3]")
	public WebElement bookingDateHeading;
	
	@FindBy(xpath = "//p[@class='pnr-info green ng-star-inserted']")
	public WebElement bookingStatus;
	
	@FindBy(xpath = "(//p[@class='pnr-title ng-star-inserted'])[4]")
	public WebElement bookingStatusHeading;
	
	
//	https://www.saudia.com/en-SA/booking/passengerDetails

	public PaymentPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");

	}

	// Verify Payment details page is opened or not
	public void verifyPaymentPageIsOpened() throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(paymentPageHeading, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Payment details page is opened");
			Utilities.isDisplayed(paymentPageHeading);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while checking Payment details page is opened or not");
		}
	}

	// Verify Seats and Extras Section in payments page
	public void verifyAncillariesInSection(List<String> ancillary, Integer[] count) throws Exception {
		try {
			Utilities.waitForAllElementVisibilty(paymentPageHeading, Constants.maxTime, Constants.poolingTime);
			verifyAncillaryHeading(ancillary, count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(
					"Error while checking anscillary is Present in 'Seats and Extras' section in 'Payment Page'");
		}
	}

	// Verify Ancillary count in 'Seat and extras' page in Payments page
	private void verifyAncillaryCount(Integer count, String countUI, String ancillary) throws Exception {

		try {
			if (countUI.startsWith(String.valueOf(count))) {
				reportLog.logPass(ancillary + " : " + countUI);
			} else {
				throw new Exception("Number of ancillaries added are wrong for " + ancillary);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying count of ancillaries added in 'Payment Page'");
		}
	}

	// Verify Ancillary heading in 'Seat and extras' page in Payments page
	public void verifyAncillaryHeading(List<String> ancillary, Integer[] count) throws Exception {
		try {
			Utilities.scrollToElementView(seatsSectionHeading);
			List<String> anscillarySectionUI = new ArrayList<String>();
			List<String> anscillaryCountSectionUI = new ArrayList<String>();
			int i;

			System.out.println("Ancillary list on UI ->" + ancillaryTitleList() + " :  Ancillary List from TestData ->"
					+ ancillary);

			if (ancillary.size() == 0 && ancillaryTitleList().size() == 0) {
				reportLog.logPass(
						"No Anscillaries selected in 'Seats and Extras' page. So no Ancillaries are shown in payment page ");
			} else {

				if (ancillary.size() != ancillaryTitleList().size() && ancillary.size() != 0) {
					throw new Exception("No All Anscillaries shown in Payment page");
				}

				for (WebElement str : ancillaryTitleList()) {
					// anscillarySectionUI.add(str.getAttribute("aria-label"));
					if (str.getText().equalsIgnoreCase(LayoutHeader.PaymentPage_SeatsAndExtras_SeatSelection_Heading)) {
						anscillarySectionUI.add(LayoutHeader.Anscillary_SeatSelection_Heading);
					} else {
						anscillarySectionUI.add(str.getText().trim());
					}
				}

				for (WebElement str : ancillaryCountListNew()) {
					anscillaryCountSectionUI.add(str.getText());
				}

				int j = 0;
				for (String uiName : anscillarySectionUI) {
					for (i = 0; i < ancillary.size(); i++) {
						String ancillaryTestdata = ancillary.get(i).toLowerCase();
						if (uiName.toLowerCase().contains(ancillaryTestdata)) {
							reportLog.logPass(ancillary.get(i)
									+ " : Anscillary is Present in 'Seats and Extras' section in 'Payment Page'");
							verifyAncillaryCount(count[i], anscillaryCountSectionUI.get(j), ancillary.get(i));
						}
					}
					j++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying ancillary heading in 'Payment Page'");
		}
	}

	// Verify header in Payments page for OW and RT
	public void verifyHeader(int noOfBound, String origin1, String destination1, String departingDate,
			String departingMonth, String returnDate, String retunMonth) throws Exception {
		try {

			String flights = Utilities.getText(FlightNamesHeader).replaceAll("\n", " ");
			String date = Utilities.getText(FlightDateHeader).trim();

			if (noOfBound == 1) {
				flights = flights.replace(LayoutHeader.PaymentPage_Header_arrow_Forward, "to");
			} else {
				flights = flights.replace(LayoutHeader.PaymentPage_Header_arrow_Compare, "to");
			}

			String flightNameTestData = origin1 + " to " + destination1;

			switch (noOfBound) {
			case 1:
				String flightDateTestDataOW = departingDate + " " + retunMonth;

				if (flights.equalsIgnoreCase(flightNameTestData) && date.contains(flightDateTestDataOW)) {
					reportLog.logPass("Verify flight route with Flight date on Payment page for OW");
				} else {
					throw new Exception("Error while verifying flight route with Flight date on Payment page for OW");
				}
				break;
			case 2:

				String datesRT[] = date.split("to");
				String fromDate = datesRT[0].split(",")[1];
				String toDate = datesRT[1].split(",")[1];

				String dateTestData_1 = departingDate + " " + retunMonth;
				String dateTestData_N = returnDate + " " + retunMonth;

				if (flights.equalsIgnoreCase(flightNameTestData) && fromDate.contains(dateTestData_1)
						&& toDate.contains(dateTestData_N)) {
					reportLog.logPass("Verify flight route with Flight date on Payment page for RT");
				} else {
					throw new Exception("Error while verifying flight route with Flight date on Payment page for RT");
				}
				break;
			default:
				// code block
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Header in 'Payment Page'");
		}
	}

	// Verify header in Payments page for MC
	public void verifyHeaderMC(int noOfBound) throws Exception {
		try {
			String flights = Utilities.getText(FlightNamesHeader).replaceAll("\n", " ");
			String date = Utilities.getText(FlightDateHeader).trim();

			String datesMC[] = date.split("to");
			String fromDate = datesMC[0].split(",")[1];
			String toDate = datesMC[1].split(",")[1];

			String dateTestData_1 = GetTestData.departingDateDataMC.get(0) + " "
					+ GetTestData.departingMonthDataMC.get(0);
			String dateTestData_N = GetTestData.departingDateDataMC.get(noOfBound - 1) + " "
					+ GetTestData.departingMonthDataMC.get(noOfBound - 1);

			if (flights.equalsIgnoreCase(LayoutHeader.PaymentPage_Header_Multicity) && fromDate.contains(dateTestData_1)
					&& toDate.contains(dateTestData_N)) {
				reportLog.logPass("Verify flight Payment page header for MC");
			} else {
				throw new Exception("Error while verifying flight Payment page header for MC");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying flight Payment page header for MC");
		}
	}

	// Verify passengers section in Payments page
	public void verifyPassengersSection(String countryCode, String phoneNumber, String email, String title,
			String firstName, String lastName) throws Exception {
		try {

			String paxName = title + firstName + lastName;
			VerifyPassengersSectionisPresent();
			VerifyPrimaryContactDetails(phoneNumber, email, paxName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Passengers section");
		}
	}

	// Verify passengers section in Payments page
	private void VerifyPassengersSectionisPresent() throws Exception {
		try {
			Utilities.scrollToElementView(passengerSectionHeading);
			Utilities.verifyTextEquals(passengerSectionHeading, "Passengers");
			reportLog.logPass("Verify Passengers Section is present in payments page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while verifying Primary contact details in Passengers section");
		}

	}

	// Verify primary contact details in passengers section in Payments page
	private void VerifyPrimaryContactDetails(String contact, String email, String paxNameTestData) throws Exception {
		try {
			if (Utilities.getText(paxName).replaceAll("[.\\s]", "").equalsIgnoreCase(paxNameTestData)
					&& Utilities.getText(contactNo).contains(contact)
					&& Utilities.verifyTextEquals(emailAddress, email) == true) {
				reportLog.logPass("Verify Primary contact details in payment page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying Primary contact details in payment page");
		}
	}

	// Verify payment method section in Payments page
	public void verifyPaymentMethodSection(double totalFareCardAmount, double anscillaryAmount) throws Throwable {
		try {
			verifyPaymentMethodSectionIsVisible();
			verifyTotalFare(totalFareCardAmount, anscillaryAmount);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying Payment Method Section in payment page");
		}
	}

	// Verify payment method section in Payments page
	public void verifyPaymentMethodSectionIsVisible() throws Exception {
		try {
			Utilities.scrollToElementView(paymentMethodSectionHeading);
			Utilities.waitForAllElementVisibilty(paymentMethodSectionHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(promoCodeHeading, Constants.maxTime, Constants.poolingTime);
			Utilities.waitForAllElementVisibilty(totalFareSectionHeading, Constants.maxTime, Constants.poolingTime);
			reportLog.logPass("Verify Payment Method Section is visible in payment page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying Payment Method Section in payment page");
		}
	}

	// Verify total fare = with and without ancillary in Payments page
	public void verifyTotalFare(double totalFareCardAmount, double anscillaryAmount) throws Exception {
		try {
			Utilities.scrollToElement(totalFareAmount);
			String totalUI = Utilities.getText(totalFareAmount).replaceAll("[^0-9.]", "");
			boolean extras = Utilities.verifyElementPresent(extrasInTotalDare);

			int flag;
			if (extras == true) {
				flag = 1;
			} else {
				flag = 0;
			}
			System.out.println("Total fare in payment page= " + totalUI + " totalfarecard amount = " + totalFareCardAmount
					+ " anscillaryAmount" + anscillaryAmount);

			switch (flag) {
			case 1:
				if (totalUI.equalsIgnoreCase( String.format("%.2f", totalFareCardAmount + anscillaryAmount))) {
					reportLog.logPass("Verify total fare (including ancillary) in payment page ");
				} else {
					throw new Exception("Total fare in payment page is not matching");
				}
				break;

			case 0:
				if (totalUI.equalsIgnoreCase(String.format("%.2f", totalFareCardAmount))) {
					reportLog.logPass("Verify total fare (not including ancillary) in payment page");
				} else {
					throw new Exception("Total fare in payment page is not matching with flight details page");
				}
				break;
			default:
				throw new Exception("Total fare in payment page is not matching in Payment page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying total fare in payment page");
		}
	}
	
	// Pay Amount for trip
	public void bookingPayment(String CardHolderName, String PaymentMode) throws Throwable {
		try {
			CommonPageMethodUtil.getCardDetails();
			CommonPageMethodUtil.enterCardDetails(CommonPageMethodUtil.cardNumber, CommonPageMethodUtil.cardExpiry, CommonPageMethodUtil.cardCVV, CardHolderName, PaymentMode);
			//CommonPageMethodUtil.enterCardDetails(CommonPageMethodUtil.cardNumber, CommonPageMethodUtil.cardExpiry,CommonPageMethodUtil.cardCVV, CardHolderName, PaymentMode);
			Utilities.clickWebElement(consentCheckbox);
			Utilities.clickWebElement(payButton);
			// Utilities.waitForInvisibilityOfElement(paymentLoader, Constants.maxTime,
			// Constants.poolingTime);
			reportLog.logPass("Complete booking payment for selected flight");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while completing payment for flight");
		}
	}

	// Verify booking payment is completed for selected route
	public void verifyPaymentIsCompleted() throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(bookingReferencePNR, Constants.highLoadTime, Constants.poolingTime);
			// Utilities.waitForInvisibilityOfElement(paymentLoader, Constants.maxTime,
			// Constants.poolingTime);
			Utilities.verifyTextEquals(bookingReferencePNRHeading, LayoutHeader.Booking_Reference);
			Utilities.verifyTextEquals(numericBookingReferenceHeading, LayoutHeader.Numeric_Booking_Reference);
			Utilities.verifyTextEquals(bookingDateHeading, LayoutHeader.Booked_On);
			Utilities.verifyTextEquals(bookingStatusHeading, LayoutHeader.Booking_Status);

			String bookingStatusUI = Utilities.getText(bookingStatus).replaceAll("\n", "");
			boolean bookedToday = CommonMethodUtil.getCurrentDate().trim().contains(bookingDate.getText());
			
			System.out.println(bookingStatusUI + bookedToday);
			
			if (bookingStatusUI.contains(LayoutHeader.Booking_Status_Confirmed) && bookedToday == true) {
				reportLog.logPass("Verify payment is completed for selected route");
			} else {
				throw new Exception("Payment is not completed for selected flight");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while Verifying payment is completed for selected route");
		}
	}

	// Save booking reference, numeric reference value in excel
	public void saveBookingReferences(int noOfBound) throws Throwable {
		try {
			Utilities.waitForAllElementVisibilty(bookingReferencePNR, Constants.highLoadTime, Constants.poolingTime);

			if(noOfBound == 1)
			{
				CommonMethodUtil.bookingReferenceOW = Utilities.getText(bookingReferencePNR);
				CommonMethodUtil.numericBookingReference = Utilities.getText(numericBookingReference);
				CommonMethodUtil.bookingDate = Utilities.getText(bookingDate);

				System.out.println(
						"**** Booking Reference = " + CommonMethodUtil.bookingReferenceOW + "- Numeric Booking Reference = "
								+ CommonMethodUtil.numericBookingReference + " - Booking Date = " + CommonMethodUtil.bookingDate);

				reportLog.logPass("Booking reference(PNR) is " + CommonMethodUtil.bookingReferenceOW);
				
			}else if(noOfBound == 2)
			{
				CommonMethodUtil.bookingReferenceRT = Utilities.getText(bookingReferencePNR);
				CommonMethodUtil.numericBookingReference = Utilities.getText(numericBookingReference);
				CommonMethodUtil.bookingDate = Utilities.getText(bookingDate);

				System.out.println(
						"**** Booking Reference = " + CommonMethodUtil.bookingReferenceRT + "- Numeric Booking Reference = "
								+ CommonMethodUtil.numericBookingReference + " - Booking Date = " + CommonMethodUtil.bookingDate);

				reportLog.logPass("Booking reference(PNR) is " + CommonMethodUtil.bookingReferenceRT);
			}
			else if(noOfBound > 2)
			{
				CommonMethodUtil.bookingReferenceMC = Utilities.getText(bookingReferencePNR);
				CommonMethodUtil.numericBookingReference = Utilities.getText(numericBookingReference);
				CommonMethodUtil.bookingDate = Utilities.getText(bookingDate);

				System.out.println(
						"**** Booking Reference = " + CommonMethodUtil.bookingReferenceMC + "- Numeric Booking Reference = "
								+ CommonMethodUtil.numericBookingReference + " - Booking Date = " + CommonMethodUtil.bookingDate);

				reportLog.logPass("Booking reference(PNR) is " + CommonMethodUtil.bookingReferenceMC);
			}
			else
			{
				throw new Exception("Error while Saving PNR for booked flight");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while saving PNR booked flight");
		}
	}
}
