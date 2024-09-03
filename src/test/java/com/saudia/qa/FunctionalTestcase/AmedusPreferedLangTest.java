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

public class AmedusPreferedLangTest extends TestBase {
	protected SignInPage signInPage;
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = "S3BIEE"; 

	public AmedusPreferedLangTest() {
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


	@Test(priority= 0 , description = "Change Language")
	public void signIN() {
		
		signInPage = new SignInPage(reports);
		reports.logPass("Sign IN", "Sign has been launched Sucessfully");
		signInPage.agentModeLogin(); 
		signInPage.personalDataAlert();
	}
	
	@Test(priority= 1 , description = "Change Language PNR Test", invocationCount = 1 )
	public void pnrCreation() {
		
		
		try {
			signInPage.cmdPromptMethod("RT "+pnr+"");
			 String commandResponse = signInPage.getCommandResponse();
			 System.out.println(commandResponse);
			 String emailRes = signInPage.addChangeCountry(commandResponse, "AR", "P1");
			 signInPage.cmdPromptMethod("XE7");
			 signInPage.cmdPromptMethod(emailRes);
			 String phoneNumRes = signInPage.getPhoneCommandResponse();
			 String phoneRes = signInPage.addChangeCountry(phoneNumRes, "AR", "P1");
			 System.out.println(phoneRes);
			 signInPage.cmdPromptMethod("XE7");
			 signInPage.cmdPromptMethod(phoneRes);
			 reports.logPass("Change Lang", "Language has been changed to both Email and phone num line");
			 String clearCTCEMid = signInPage.clearCTCEM();
			 System.out.println("XE"+clearCTCEMid+"-"+(Integer.parseInt(clearCTCEMid)+1));
			 signInPage.cmdPromptMethod("XE"+clearCTCEMid+"-"+(Integer.parseInt(clearCTCEMid)+1));
			 signInPage.cmdPromptMethod("RF Banumathi");
			 signInPage.cmdPromptMethod("ER");
			 signInPage.validateWarningError();
					 
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
