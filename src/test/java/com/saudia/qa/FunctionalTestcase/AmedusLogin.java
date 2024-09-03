package com.saudia.qa.FunctionalTestcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

public class AmedusLogin extends TestBase {
	protected SignInPage signInPage;
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null; 

	public AmedusLogin() {
		super();
	}


	
	@BeforeMethod
	public void setup(Method m) throws IOException {
		// initliazing the classes
		String filePath ="";
		signInPage = new SignInPage(reports);
		excel = new ExcelUtill(filePath, 1);
		reports.startTest(m.getName(), "BanumathiS", "FunctionalTesting");
	//	signInPage.agentModeLogin(); 
	//	signInPage.personalDataAlert();
	}


	@Test(priority= 0 , description = "Login Amadeus")
	public void signIN() {
		
		signInPage = new SignInPage(reports);
		reports.logPass("Sign IN", "Sign has been launched Sucessfully");
		signInPage.agentModeLogin(); 
		signInPage.personalDataAlert();
	}
	
	@Test(priority= 1 , description = "Validate the PNR creation", invocationCount = 3 )
	public void pnrCreation() {
		
		
		try {
			  signInPage.cmdPromptMethod("SN15AUGRUHJED");
			  signInPage.cmdPromptMethod("SS1Y02");
			  signInPage.cmdPromptMethod("NM1TEST/Divyaes MS");
			  signInPage.cmdPromptMethod("AP +918072158274-m");
			  signInPage.cmdPromptMethod("APE-BANUMATHIS@HEXAWARE.COM");
			  signInPage.cmdPromptMethod("SRDOCSSVHK1-I-SA-1234567890-SA-22JAN80-M-22JAN25-TEST-Divyaes");
			  signInPage.cmdPromptMethod("SRDOCSSVHK1-I-SA-1234567890-SA-22JAN80-M-22JAN25-TEST-TARIOQ/P1");
			  signInPage.cmdPromptMethod("TKOK"); 
			  signInPage.cmdPromptMethod("FXP");
			  signInPage.cmdPromptMethod("RT");
			  signInPage.cmdPromptMethod("FPCCVI4508750015741019/0925*cv123");
			  signInPage.cmdPromptMethod("RFP"); 
			  signInPage.cmdPromptMethod("TTP/RT");
			  signInPage.validateTicket(); 
			  signInPage.cmdPromptMethod("RT");
			  pnr = signInPage.getPNR();
			  reports.logPass("PNR: ","'"+pnr+"' created Sucessfully ");
			  values.add(pnr);
			 
		} catch (Exception e) {
			reports.logPass("PNR", "Error while creating PNR");
			reports.logFail(e.getMessage(), "Unable to Retrive PNR...");
		}
	}
		
		@AfterMethod
	public void tearDown() {
			reports.endTest();

	}

		@AfterClass
	public void excelWrite() {
			
			System.out.println(values);
			excel.writeDataFirstRow(values);

	}
		

	

}
