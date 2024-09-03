package com.saudia.qa.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.saudia.qa.config.Constants;
import com.saudia.qa.listeners.WebEventListner;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static Properties prop = null;
	public static WebDriver driver = null;
	public static WebDriverWait wd;
	public static ReportLog reports = null;
	protected Utilities utils;
	protected SignInPage signInPage;
	public static String excelSheetColumnBooking, sheetNameBooking, excelSheetColumnMMB, sheetNameMMB;
	public static ExcelUtill excel;
	
	
	public static void Browsersetup() throws InterruptedException {
		// String browserName="CHROME";
		String browserName = prop.getProperty("browser");
		// browserName.toUpperCase().equalsIgnoreCase("CHROME");

		TestBase.selectBrowser(browserName);
		WebDriverListener evenListener = new WebEventListner();
		WebDriver decorder = new EventFiringDecorator<WebDriver>(evenListener).decorate(driver);
		driver = decorder;
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("SaudiaUAT_URL"));
		
		Log.info("BROWSER SUCESSFULLY LAUNCHED");
	}

	public static void selectBrowser(String browserName) {
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("start-maximized"); //
			// options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("ingnore-certificate-errors");
			options.addArguments("disable-popup-blocking");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);

		} else if (browserName.toUpperCase().equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.toUpperCase().equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			String downloadFilepath = "C:\\path\\to\\MozillaFirefoxDownload";
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", downloadFilepath);
			FirefoxOptions options = new FirefoxOptions();
			// options.setHeadless(true);
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
		} else {
			Log.error("RUN TIME EXCEPTION is  OCCURED..........");
			throw new RuntimeException("invalid BrowserName");

		}
	}
	public static void loadTestData() throws IOException
	{
		sheetNameBooking = Constants.BOOKING_TESTDATA_EXCELSHEET;
		excelSheetColumnBooking = Constants.BOOKING_TESTDATA_COLUMN1;
		sheetNameMMB = Constants.MMB_TESTDATA_EXCELSHEET;
		excelSheetColumnMMB = Constants.MMB_TESTDATA_COLUMN1;
		
		excel = new ExcelUtill(Constants.TESTDATA_FILE_PATH, 1);
		GetTestData.getBookingTestData(excel, sheetNameBooking, excelSheetColumnBooking);
		GetTestData.getMMBTestData(excel, sheetNameMMB, excelSheetColumnMMB);
	}
	
	public static void loadProperties()
	{
		try {
			prop = new Properties();

			FileInputStream fip = new FileInputStream(new File(Constants.WORKING_DIR + File.separator
					+ "src\\main\\java\\com\\saudia\\qa\\config\\config.properties"));

			BufferedInputStream bufferedInputStream = new BufferedInputStream(fip);
			prop.load(bufferedInputStream);
		} catch (IOException e) {
			Log.error("IOException THROWN WHILE LOADING THE CONFIG FILE" + e.getMessage());

		} catch (Exception e) {
			Log.error("GENERIC THROWN WHILE LOADING THE CONFIG FILE" + e.getMessage());
		}

	}
	
	@BeforeSuite
	public void loadConfig() throws Throwable {
		loadProperties();
		Browsersetup();
		long ts = System.currentTimeMillis();
		reports = new ReportLog(driver, String.valueOf(ts), "Saudia Airelines", "Report", "TestAutomation");
		utils = new Utilities(driver);
		loadTestData();
		HomePage homePage = new HomePage(reports);
		homePage.acceptPrivacyCookies();
		homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		System.out.println("BeforeSuite");
	}

	@AfterSuite
	public void endTestSuite() {
		if (driver != null) {
		//	reports.logInfo("Test", "Test has been launched Sucessfully");
			driver.quit();
			reports.endSuite();
		}

	}

	/*
	 * @BeforeClass public void beforeClassMethod() { try {
	 * System.out.println("BeforeClass 1 "); loadProperties(); Browsersetup(); long
	 * ts = System.currentTimeMillis(); reports = new ReportLog(driver,
	 * String.valueOf(ts), "Automation Reports", "Amadeus", "Banumathi"); utils =
	 * new Utilities(driver); System.out.println("BeforeClass 2 "); } catch
	 * (InterruptedException e) { e.printStackTrace(); } }
	 * 
	 * @AfterClass public void afterClassMethod() { if (driver != null) {
	 * reports.logInfo("Test", "class"); driver.quit(); reports.endSuite(); } }
	 */
	 
}
