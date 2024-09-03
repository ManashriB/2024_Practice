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

public class SignInPage extends TestBase{
	
	private static Logger Log= Logger.getLogger(SignInPage.class);
	private ReportLog reportLog;
	
	
		
	@FindBy(xpath ="//*[@id='loginType']//*[@value='Username']")
	public WebElement modeBtn;
	
	@FindBy(xpath = "//*[contains(@ng-selected,'AgentSign')]")
	public WebElement agentSignDD;
	
	@FindBy(xpath = "//*[@id='agentSignInput']")
	public WebElement agentSignInput;
	
	@FindBy(id="officeIdInput")
	public WebElement officeIDInput;
	
	@FindBy(xpath ="//*[@id='dutyCode']/*[@id='dutyCodeInput']")
	public WebElement dutyCodeInput;
	
	@FindBy(xpath ="//*[@id='dutyCode']//div[@class='customSelectBox']//li[7]")
	public WebElement dutyCodeDD;
	
	@FindBy(id="id_confirmButton")
	public WebElement IDnextBtn;
	
	@FindBy(id="passwordInput")
	public WebElement pwdInput;
	
	@FindBy(id="logi_confirmButton")
	public WebElement pwdNextBtn;
	
	@FindBy(xpath ="//*[@class='popup privateData']//button[@id='fosi_forceSignInButton']")
	public WebElement personalDataPopupNxtBtn;
	
	@FindBy(xpath ="//*[@class='popup privateData']//div[1]/span[1]")
	public WebElement privateDataTitle;
	
	@FindBy(xpath ="//*[@class='cmdPromptInput']")
	public WebElement cmdPropmptInput;
	
	@FindBy(xpath ="(//*[@id='responseCommand']//code)[13]")
	public WebElement responseCommandTXT;
	
	
	@FindBy(xpath ="//*[@class='cmdResponse']")
	public WebElement responseCommandTXTOne;
	
	@FindBy(xpath ="(//*[@class='cmdResponse'])[3]")
	public WebElement responseCommandTXTThree;
	
	@FindBy(xpath ="(//*[@class='cmdResponse'])[5]")
	public WebElement responseCommandTXTFive;
	

	@FindBy(xpath ="(//*[@class='cmdResponse'])[8]")
	public WebElement responseCommandTXTEight;
	
	@FindBy(xpath ="(//*[@id='responseCommand']//code)[12]")
	public WebElement responseCommandTXT1;
	
	@FindBy(xpath ="(//*[@id='responseCommand']//code)[14]")
	public WebElement responseCommandTXT2;
	
	@FindBy(xpath ="//*[@class='speedModePanel']")
	public WebElement pnrResponseTXT;
	
	@FindBy(xpath ="//*[@aria-label='Create New Cryptic Session']")
	public WebElement newSession;
	
	private String PNRnumber;
	
	
	
	public SignInPage(ReportLog reportLog) {
		PropertyConfigurator.configure(Constants.LOG4J_DIR);
		this.reportLog = reportLog;
		PageFactory.initElements(driver, this);
		Log.info("Intialize the Webelements in the driver");
	 
	}
	
	
	public String validatePageTitle() {
		 Log.info("VAlidate the Login PAge Title");
		return driver.getTitle();

	}
	
	public void agentModeLogin() {
		try {
			reportLog.logPass("User Credentials", "Trying to enter user credentials");
			Thread.sleep(5000);
			Utilities.moveToElementAndClick(modeBtn);
			Utilities.moveToElementAndClick(agentSignDD);
			Utilities.setText(agentSignInput, "6758TT");
			Utilities.setText(officeIDInput, "JEDSV08AA");
			Thread.sleep(5000);
			Utilities.moveToElementAndClick(dutyCodeInput);
			Utilities.moveToElementAndClick(dutyCodeDD);
			reportLog.logPass("User Login Details", "User Login Details has beem enetered Successfully");
			Utilities.moveToElementAndClick(IDnextBtn);
			Thread.sleep(3000);
			Utilities.setText(pwdInput, "Dec@2023");
			Utilities.moveToElementAndClick(pwdNextBtn);
			reportLog.logPass("Password Detail", "Passwords has beem enetered Successfully and clicked on Next Button");
			} catch (Exception e) {
				reportLog.logFail("User Credentials", "Failed while entering User Credentials");
			Log.info("Exception Has raised "+e.getMessage());
		}
		
	}
		

	public void personalDataAlert(){
		
		try {
			Utilities.waitForAllElementVisibilty(privateDataTitle,Constants.maxTime, Constants.poolingTime);
			String privateDataText = privateDataTitle.getText(); 
			if
			  (
			privateDataText.trim().equals("PERSONAL DATA PROTECTION NOTICE"))
			{
				Utilities.moveToElementAndClick(personalDataPopupNxtBtn); 
			} 
			
			else { 
			throw new Exception();
			}
			Thread.sleep(5000);
			reportLog.logPass("Personal Data Protection Popup", "Personal Data Protection Popup has been closed Successfully");

		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void cmdPromptMethod(String command){
		
		try {
			Thread.sleep(3000);
			Utilities.waitForAllElementVisibilty(cmdPropmptInput,Constants.maxTime, Constants.poolingTime);
			Utilities.moveToElementAndClick(cmdPropmptInput);
			Utilities.setTextAndEnter(cmdPropmptInput, command);
			reportLog.logPass("Command: ", "Screen shot after entering the command '"+command+"'");
		} catch (Exception e) {
			reportLog.logPass("Command: ", "Error while entering the command '"+command+"'");
			e.printStackTrace();
		}
	}
	
	public void validateTicket(){
		
		try {
			Thread.sleep(10000);
			Utilities.waitForAllElementVisibilty(responseCommandTXT,Constants.maxTime, Constants.poolingTime);
			String reponseTXT = responseCommandTXT.getText().trim();
			 if (reponseTXT.equals("OK ETICKET WELL ISSUED")) {
			  reportLog.logPass("Command Response: ",reponseTXT+" has been created successfully"); } 
			 else {
			  reportLog.logFail("Command Response: ",reponseTXT+ "has not been created successfully"); }
			 
			
		} catch (Exception e) {
			reportLog.logFail("e-ticket: ", "e-ticket has not been created successfully");
			e.printStackTrace();
		}
	}
	
public String getCommandResponse(){
	String cmd = null;
		try {
			Thread.sleep(3000);
			Utilities.waitForAllElementVisibilty(responseCommandTXTOne,Constants.maxTime, Constants.poolingTime);
			String reponseTXT = responseCommandTXTOne.getText().trim();
			System.out.println(reponseTXT);
			
			int stInd = reponseTXT.indexOf("7 APN");
			int edInd = reponseTXT.indexOf("8 APN");
			System.out.println(stInd);
			System.out.println(edInd);
			cmd = reponseTXT.substring(stInd+1, edInd).trim();
						
		
		} catch (Exception e) {
			reportLog.logFail("e-ticket: ", "e-ticket has not been created successfully");
			e.printStackTrace();
		}
		return cmd;
		
	}

public String getPhoneCommandResponse(){
	String cmd = null;
		try {
			Thread.sleep(2000);
			Utilities.waitForAllElementVisibilty(responseCommandTXTThree,Constants.maxTime, Constants.poolingTime);
			String reponseTXT = responseCommandTXTThree.getText().trim();
			System.out.println(reponseTXT);
			
			int stInd = reponseTXT.indexOf("7 APN");
			int edInd = reponseTXT.indexOf("8 APN");
			System.out.println(stInd);
			System.out.println(edInd);
			cmd = reponseTXT.substring(stInd+1, edInd).trim();
						
		
		} catch (Exception e) {
			reportLog.logFail("e-ticket: ", "e-ticket has not been created successfully");
			e.printStackTrace();
		}
		return cmd;
		
	}
	
public String addChangeCountry(String reponseTXT, String lang, String candidate){
	String emailRes = null;
		try {
			String cmd = reponseTXT.replace("APN SV", "APN-SV");
			emailRes = cmd.substring(0, cmd.length() - 2)+lang+"/"+candidate ;
			
		
		} catch (Exception e) {
			reportLog.logFail("e-ticket: ", "e-ticket has not been created successfully");
			e.printStackTrace();
		}
		return emailRes;
		
	}

public String clearCTCEM(){
	String CTCM = null;
		try {
			Thread.sleep(10000);
			Utilities.waitForAllElementVisibilty(responseCommandTXTFive,Constants.maxTime, Constants.poolingTime);
			String reponseTXT = responseCommandTXTFive.getText().trim();
			System.out.println(reponseTXT);
			
			/*
			 * int stIndce1 = reponseTXT.indexOf("SSR CTCM"); System.out.println(stIndce1);
			 * 
			 * 
			 * String CTCM1= reponseTXT.substring(stIndce1-3 , stIndce1).trim();
			 * System.out.println(CTCM1);
			 */

			int stIndce = reponseTXT.indexOf("CTCM");
			System.out.println(stIndce);
			
			 CTCM= reponseTXT.substring(stIndce-8 , stIndce-5).trim();
			System.out.println(CTCM);
			
		
		} catch (Exception e) {
			reportLog.logFail("e-ticket: ", "e-ticket has not been created successfully");
			e.printStackTrace();
		}
		return CTCM;
		
	}


public void validateWarningError(){
	
	try {
		Thread.sleep(10000);
		Utilities.waitForAllElementVisibilty(responseCommandTXTEight,Constants.maxTime, Constants.poolingTime);
		String reponseTXT = responseCommandTXTEight.getText().trim();
		 if (reponseTXT.equals("WARNING : CHECK ITINERARY STATUS")) {
			 cmdPromptMethod("ER");
		  reportLog.logPass("Language"," has been Changed successfully"); } 
		
		
	} catch (Exception e) {
		reportLog.logFail("Language: ", "Language has not been Changed ");
		e.printStackTrace();
	}
}

	public String getPNR() {
		try {
			Thread.sleep(10000);
			Utilities.waitForAllElementVisibilty(pnrResponseTXT,Constants.maxTime, Constants.poolingTime);
			System.out.println(pnrResponseTXT.getText());
			
			 StringBuilder pnr = new StringBuilder(pnrResponseTXT.getText());
			 StringBuilder pnrTXT =  pnr.delete(85, pnr.length());
			 PNRnumber = pnrTXT.substring(pnrTXT.length () - 8, pnrTXT.length ());
			 System.out.println("PNR num: "+PNRnumber);
			 Utilities.waitForAllElementVisibilty(newSession,Constants.maxTime, Constants.poolingTime);
			 Utilities.moveToElementAndClick(newSession);
			 
		} catch (Exception e) {
			reportLog.logFail("PNR: ", "PNR has not been created successfully");
			e.printStackTrace();
		}
		return PNRnumber;

	}
}
