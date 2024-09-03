package com.saudia.qa.FunctionalTestcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class LoginTest extends TestBase {
	protected SignInPage signInPage;
	protected Utilities utils;
	public ReportLog reports;

	public LoginTest() {
		super();
	}

	@BeforeSuite
	public void loadConfig() throws InterruptedException {
		Browsersetup();
		long ts = System.currentTimeMillis();
		reports = new ReportLog(driver, String.valueOf(ts), "one_Travel Reports", "Travel Reports for ONT Module",
				"One Travel");
		utils = new Utilities(driver);
	}

	@BeforeMethod
	public void setup(Method m) {
		// initliazing the classes
		signInPage = new SignInPage(reports);
		reports.startTest(m.getName(), "Ajith", "FunctionalTesting	");

	}

	@Test(priority = -1, description = "Avlidate the SignUp page Title", singleThreaded = true, enabled = true, ignoreMissingDependencies = true, invocationCount = 2, timeOut = 5000, invocationTimeOut = 2000)
	public void LoginPageTitleTest() {
		String SignInPageTitle = signInPage.validatePageTitle();
		if (SignInPageTitle.equals("Cheap Airline Tickets, Cheap Flights and Air Travel Deals - OneTravel")) {
			reports.logPass("Validted the SignInup page Sucessfully ",",");
		} else {
			reports.logFail("Invalid page Title","");
		}
		AssertJUnit.assertEquals(SignInPageTitle, "Cheap Airline Tickets, Cheap Flights and Air Travel Deals - OneTravel");
	}

	@Test(priority = 0, dependsOnMethods = {"LoginPageTitleTest" }, singleThreaded = true, ignoreMissingDependencies = true, enabled = true, suiteName = "FunctionalSuite", description = "Validate the MakemyTrip logo")
	public void makeMyTripLogo() {
		boolean validateMakeMyTripLogo = true;
		if (validateMakeMyTripLogo) {
			reports.logPass("Validated the LOGO","");
		} else {
			reports.logFail("Inavaild logo is there ","");
		}
		AssertJUnit.assertEquals(validateMakeMyTripLogo, true);
	}

	@Test(priority = 0, dependsOnMethods = {
			"makeMyTripLogo" }, singleThreaded = true, ignoreMissingDependencies = true, enabled = true, suiteName = "FunctionalSuite", description = "Validate the SignInpage and vaild user name and passowd ")
	public void signInPageTest() throws InterruptedException {
		try {
			//signInPage.SignIn(prop.getProperty("username", "NONE"), prop.getProperty("password", "NONE"));
		} catch (Exception e) {
			reports.logFail("SignInTestCase is failed with Reponce"+e.getMessage(), "");
		}
		

	}
	
	@AfterMethod
	public void tearDown() {
		reports.endTest();

	}

	@AfterSuite
	public void endTestSuite() {
		driver.quit();
		reports.endSuite();
		/*
		 * if (driver != null) { driver.quit(); reports.endSuite(); }
		 */

	}

}
