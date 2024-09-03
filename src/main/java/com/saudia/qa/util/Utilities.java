package com.saudia.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

//import com.github.dockerjava.api.model.Image;
import com.saudia.qa.config.Constants;
//
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utilities {
	static Robot robot = null;
	public static JavascriptExecutor js = null;
	public static WebDriver driver = null;
	public static Select sel = null;
	public static Alert alert = null;
	public static Wait<WebDriver> wait = null;
	public static HttpURLConnection huc = null;
	public int responceCode = 0;

	public static String ScreenshotFolderName;
	public static String alphanumricString = "ABCDEFGHIJKLMNOPQRSTWXYZ" + "0123456789" + "abcdefghijklmnopqrstwxyz";
	public static String totalAlphatic = "ABCDEFGHIJKLMNOPQRSTWXYZ" + "abcdefghijklmnopqrstwxyz";
	public static String numricString = "0123456789";

	@SuppressWarnings("static-access")
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	public static String captureScreenshots(WebDriver driver) {
		String filename = null;
		if (ScreenshotFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			System.out.println("Before formatting:" + myDateObj);
			DateTimeFormatter myformatobj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			ScreenshotFolderName = myDateObj.format(myformatobj);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/" + ScreenshotFolderName + "/" + filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return filename;
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		String sceenShotFilePath = null;
		sceenShotFilePath = Constants.SCREENSHOT_DIR + screenshotName + Utilities.timeStamp() + ".png";
		File destFilePath = new File(sceenShotFilePath);
		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(destFilePath, screenshotfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sceenShotFilePath;
	}

	public static String getScreenshot(WebDriver driver) {

		String sceenShotFilePath = null;
		sceenShotFilePath = Constants.SCREENSHOT_DIR + Utilities.timeStamp() + ".png";
		File destFilePath = new File(sceenShotFilePath);
		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(destFilePath, screenshotfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sceenShotFilePath;
	}

//    public static String captureFullPage (String screenshotFul1Page,WebDriver driver) {
//        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.5f), 1000)). takeScreenshot (driver);
//        String imagePath = System.getProperty("user.dir") +"/Screenshots/" +screenshotFul1Page+ System.currentTimeMillis ()+".png";
//        try {
//            ImageIO.write(screenshot.getImage (), "PNG", new File (imagePath));
//        } catch (Exception e) {
//        
//        System.out.println("Screenshot is not captured"+e.getMessage());
//        }
//        return imagePath;
//        }

	public static String timeStamp() {
		Instant instant = null;
		try {
			instant = Instant.now();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return instant.toString().replace("-", "_").replace(".", "_");
	}

	public static void RightClickMouse() throws AWTException {
		Log.info("RightClickMouse Click Action is Started...................");
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		} catch (Exception e) {
			Log.error("Class Utilities|Method RightClickMouse|Exception::desc::::" + e.getMessage());
		}

	}

	public static void LeftClickMouse() throws AWTException {
		Log.info("LeftClickMouse Click Action is Started...................");
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception e) {
			Log.error("Class Utilities|Method LeftClickMouse|Exception::desc::::" + e.getMessage());
		}

	}

	public static void MiddleClickMouse() throws AWTException {
		Log.info("MiddleClickMouse Click Action is Started...................");
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
		} catch (Exception e) {
			Log.error("Class Utilities|Method MiddleClickMouse|Exception::desc::::" + e.getMessage());
		}

	}

	public static void MouseMove(int xCordinates, int yxCordinates) throws AWTException {
		Log.info("MouseMove Click Action is Started...................");
		try {
			robot = new Robot();
			robot.mouseMove(xCordinates, yxCordinates);

		} catch (Exception e) {
			Log.error("Class Utilities|Method MouseMove|Exception::desc::::" + e.getMessage());
		}

	}

	public static void keyPressCTRL() {
		Log.info("keyPressCTRL Click Action is Started...................");
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(5000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			Log.error("Class Utilities|Method keyPressCTRL|AWTException::desc::::" + e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities|Method keyPressCTRL|Exception::desc::::" + e.getMessage());
		}

	}

	public static void keyPressV() {
		Log.info("keyPressV Click Action is Started...................");
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(5000);
			robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			Log.error("Class Utilities|Method keyPressV|AWTException::desc::::" + e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities|Method keyPressV|Exception::desc::::" + e.getMessage());
		}

	}

	public static void RobotUtillity(String events, int index) {
		Log.info("RobotUtillity Action is Started...................");
		String[] eventNames = events.split(",");
		List<String> key = new LinkedList<String>();
		for (String eventName : eventNames) {
			key.add(eventName);

		}
		try {
			switch (key.get(index)) {
			case "RightClickMouse":
				RightClickMouse();
				break;

			case "keyPressCTRL":
				keyPressCTRL();
				break;

			case "keyPressV":
				keyPressV();
				break;

			default:
				throw new RuntimeException("No Mathched case Found");

			}
		} catch (Exception e) {
			Log.error("Class Utilities|Method RobotUtillity|Exception::desc::::" + e.getMessage());
		}

	}

	/* ZoomIn Based on Level Using Js Executor */
	public static void zoom(int zoom) {
		Log.info("zoom Action is Started...................");

		try {
			js.executeScript("document.body.style.zoom=" + zoom + "%", "");
		} catch (Exception e) {
			Log.error("Class Utilities|Method zoom|Exception::desc::::" + e.getMessage());
		}

	}

	public static void selectVisibleText(WebElement element, String txt) {
		try {
			Log.info("selectVisibleText is Started...................");
			sel = new Select(element);
			sel.selectByVisibleText(txt);
			Log.info("selectVisibleText is:::::" + element + "....." + txt + "..............");
		} catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
			Log.error(
					"Class Utilities|Method selectVisibleText|NoSuchElementException|StaleElementReferenceException|ElementClickInterceptedException::desc::::"
							+ e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities|Method selectVisibleText|Exception::desc::::" + e.getMessage());
		}
	}

	public static void selectByIndex(WebElement element, int index) {
		try {
			Log.info("selectByIndex is Started...................");
			sel = new Select(element);
			sel.selectByIndex(index);
			Log.info("selectVisibleText is:::::" + element + "....." + index + "..............");
		} catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
			Log.error(
					"Class Utilities|Method selectByIndex|NoSuchElementException|StaleElementReferenceException|ElementClickInterceptedException::desc::::"
							+ e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities|Method selectByIndex|Exception::desc::::" + e.getMessage());
		}
	}

	public static String getFirstOption(WebElement element) {
		String firstOption = "";
		try {
			Log.info("getFirstOption is Started...................");
			sel = new Select(element);
			firstOption = sel.getFirstSelectedOption().getText();
			Log.info("selectVisibleText is:::::" + element + "...................");
		} catch (Exception e) {
			Log.error("Class Utilities|Method getFirstOption|Exception::desc::::" + e.getMessage());
		}
		return firstOption;
	}

	public static void selectByValue(WebElement element, String txt) {
		try {
			Log.info("selectByValue is Started...................");
			sel = new Select(element);
			sel.selectByValue(txt);
			Log.info("selectByValue is:::::" + element + "....." + txt + "..............");
		} catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
			Log.error(
					"Class Utilities|Method selectVisibleText|NoSuchElementException|StaleElementReferenceException|ElementClickInterceptedException::desc::::"
							+ e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities|Method selectVisibleText|Exception::desc::::" + e.getMessage());
		}
	}

	public static List<String> getAllDropdownOptions(WebElement element) {
		List<String> Listvalue = null;
		try {
			Log.info("getAllDropdownOptions is Started...................");
			sel = new Select(element);
			List<WebElement> elementList = sel.getOptions();
			Listvalue = new ArrayList<String>();
			for (WebElement ele : elementList) {
				Listvalue.add(ele.getText());

			}

		} catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
			Log.error("Class Utilities|Method getAllDropdownOptions|Exception::desc::::" + e.getMessage());
		}
		return Listvalue;
	}

	/* select the Dropdown value from the list::::: If we have have div tag */
	public static void SelectDropdowndiv(String xpath, String text) {
		try {
			Log.info("SelectDropdowndiv is Started...................");
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.click();
			Thread.sleep(5000);
			ele.findElement(By.xpath("//*[text()='" + text + "']")).click();
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			Log.error("Class Utilities|Method SelectDropdowndiv|Exception::desc::::" + e.getMessage());
		}

		catch (Exception e) {
			Log.error("Class Utilities|Method SelectDropdowndiv|Exception::desc::::" + e.getMessage());
		}

	}

	public static String gendricRandomString(int str_len) {
		Log.info("gendricRandomString is Started...................");
		StringBuilder sb = new StringBuilder();
		try {
			for (int index = 0; index < str_len; index++) {
				int char_index = (int) (totalAlphatic.length() * Math.random());
				sb.append(totalAlphatic.charAt(char_index));
			}
		} catch (Exception e) {
			Log.error("Class Utilities|Method gendricRandomString|Exception::desc::::" + e.getMessage());
		}
		return sb.toString();

	}

	public static String gendricRandomInteger(int str_len) {
		Log.info("gendricRandomString is Started...................");
		StringBuilder sb = new StringBuilder();
		try {
			for (int index = 0; index < str_len; index++) {
				int char_index = (int) (numricString.length() * Math.random());
				sb.append(numricString.charAt(char_index));
			}
		} catch (Exception e) {
			Log.error("Class Utilities|Method gendricRandomInteger|Exception::desc::::" + e.getMessage());
		}
		return sb.toString();

	}

	/* Alpha numaric gendration data */
	public static String genAlpha_Num_String(int str_len) {
		Log.info("genAlpha_Num_String is Started...................");
		StringBuilder sb = new StringBuilder();
		try {
			for (int index = 0; index < str_len; index++) {
				int char_index = (int) (alphanumricString.length() * Math.random());
				sb.append(alphanumricString.charAt(char_index));
			}
		} catch (Exception e) {
			Log.error("Class Utilities|Method genAlpha_Num_String|Exception::desc::::" + e.getMessage());
		}
		return alphanumricString.toString();

	}

	public void checkPageisReady() {
		js = (JavascriptExecutor) driver;
		try {

		} catch (Exception e) {

		}

	}

	/* wait for page to Load / Get Ready */
	public static boolean CheckPageIsReady(WebDriver driver) {
		Log.info("CheckPageIsReady Method Action is started...");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			String ready_state = js.executeScript("return document. ready_state", "").toString();
			if (ready_state.trim().equals("complete")) {
				return true;
			}
		} catch (Exception e) {
			Log.error("Class Utilities | Method CheckPageIsReady | Exception: :desc::::" + e.getMessage());

		}
		return false;
	}

	/* Handking the Alerts */
	public static Alert getAlert() {
		try {
			alert = driver.switchTo().alert();
		} catch (Exception e) {
			Log.error("Class Utilities | Method getAlert | Exception: :desc::::" + e.getMessage());
		}
		return alert;
	}

	public static void AcceptAlert() {
		Log.info("AcceptAlert Method Action is started..");
		try {
			getAlert().accept();
		} catch (Exception e) {
			Log.error("Class Utilities | Method AcceptAlert | Exception: :desc::::" + e.getMessage());
		}
	}

	public static void DismissAlert() {
		Log.info("DismissAlert Method Action is started....");
		try {
			getAlert().dismiss();
		} catch (Exception e) {
			Log.error("Class Utilities | Method DismissAlert | Exception: :desc::::" + e.getMessage());
		}
	}

	public static String getAlertText() {
		String alertText = null;
		try {
			alertText = getAlert().getText();
		} catch (Exception e) {
			Log.error("Class Utilities | Method GetTextFromAlert | Exception: :desc::::" + e.getMessage());
		}
		return alertText;
	}

	private static boolean isAlertPresent() {
		try {
			getAlert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void AcceptAlertPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
		Log.info("Alert is Accepted..");
	}

	public static void DismissAlertPresent() {
		if (!isAlertPresent())
			return;
		DismissAlert();
		Log.info("Alert is Dismissed....");
	}

	public static void AcceptPrompt(String text) {
		if (isAlertPresent())
			return;
		alert = getAlert();
		alert.sendKeys(text);
	}

	public static void DismissPrompt(String text) {
		Log.info("AcceptPrompt Method Action is started.");
		try {
			if (isAlertPresent())
				return;
			alert = getAlert();
			alert.sendKeys(text);
			alert.dismiss();
		} catch (Exception e) {
			Log.error("Class Utilities | Method AcceptPrompt | Exception: :desc::::" + e.getMessage());
		}
	}

	/* for sychronization of your pages we going to implement waits */
	public void setImplicitWait(long timeout, Duration unit) {
		Log.info("getResponseCodeUrl Method Action is started..");
		driver.manage().timeouts().implicitlyWait(unit == null ? Duration.ofSeconds(timeout) : unit);
	}

	public static Wait<WebDriver> getWait(int MaxtimeOutInSeconds, int PollingEveryInMillisec) {
		Log.debug("For sychronization of webPages We introducing FLuentWait.......");
		Log.info("getWait Method Action is started........");
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(MaxtimeOutInSeconds))
				.pollingEvery(Duration.ofMillis(PollingEveryInMillisec)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class).ignoring(StaleElementReferenceException.class);
		return wait;
	}

	public boolean getResponseCodeUrl(String chkurl) {
		boolean validResponse = false;

		try {
			huc = (HttpURLConnection) new URL(chkurl).openConnection();
			huc.setRequestMethod("HEAD");
			int responseCode = huc.getResponseCode();
			if (responseCode > 400) {
				validResponse = true;
			} else {
				validResponse = false;
			}
		} catch (MalformedURLException e) {
			Log.error(
					"Class Utilities | Method getResponseCodeUrl | MalformedURLException: :desc::::" + e.getMessage());
		} catch (IOException e) {
			Log.error("Class Utilities | Method getResponseCodeUr] | IOException::desc::::" + e.getMessage());
		} catch (Exception e) {
			Log.error("Class Utilities | Method getResponseCodeUr1 | Exception::desc::::" + e.getMessage());

		}
		return validResponse;
	}

	public static void waitForAllElementVisibilty(WebElement loc, int MaxtimeouitinSecond, int PollingEveryMillisec) {
		Log.info("waitForElementVisibilty for element methos is Started");
		Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
		wait.until(ExpectedConditions.visibilityOf(loc));

	}

	// waitForElementVisibilty for element method to check Element present on DOM or not
	public static WebElement waitForElementVisibiltyToCheckElementPresent(WebElement loc, int MaxtimeouitinSecond,
			int PollingEveryMillisec) {
		WebElement element = null;
		try {
			Log.info("waitForElementVisibilty for element methos is Started");
			Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
			element = wait.until(ExpectedConditions.visibilityOf(loc));
		} catch (Exception e) {
			Log.info("waitForElementVisibilty for element method - Element not present on DOM");
		}
		return element;
	}

	public static void elementToBeClickable(WebElement loc, int MaxtimeouitinSecond, int PollingEveryMillisec) {
		Log.info("waitForElementVisibilty for element methos is Started");
		Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
		wait.until(ExpectedConditions.elementToBeClickable(loc));

	}

	/* Javascriptinterface ..... Gendric Methods */
	public static void executeScript(String script, Object... args) {
		try {
			js = (JavascriptExecutor) driver;
		} catch (Exception e) {

		}
		js.executeScript(script, args);
	}

	/* ScrollToElement..... Gendric Methods */
	public static void scrollToElement(WebElement element) {
		try {
			Log.info("scrollToElement MEthod Action is Started ..........");
			executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
					element.getLocation().y);
		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollToElement | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollToElementView(WebElement element) {
		try {
			Log.info("scrollToElement MEthod Action is Started ..........");
			// js.executeScript("arguments[0].scrollIntoView();", element);
			executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollToElement | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollToElementandClickElement(WebElement element) {
		try {
			Log.info("scrollToElementandClickElement MEthod Action is Started ..........");
			scrollToElement(element);
			element.click();

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollToElementandClickElement | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollIntoView(WebElement element) {
		try {
			Log.info("scrollIntoView MEthod Action is Started ..........");
			executeScript("arguments[0].scrollIntoView", element);

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollIntoView | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollIntoViewandClick(WebElement element) {
		try {
			Log.info("scrollIntoViewandClick MEthod Action is Started ..........");
			scrollIntoView(element);
			element.click();

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollIntoViewandClick | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollDownVertically() {
		try {
			Log.info("scrollDownVertically MEthod Action is Started ..........");
			executeScript("window.scrollTo(0,document.body.scrollHeight)", "");

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollDownVertically | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollupVertically() {
		try {
			Log.info("scrollupVertically MEthod Action is Started ..........");
			executeScript("window.scrollTo(0.-document.body.scrollHeight)", "");

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollupVertically | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollDownByPixcels(int pixelValue) {
		try {
			Log.info("scrollDownByPixcels MEthod Action is Started ..........");
			executeScript("window.scrollTo(0," + pixelValue + ")", "");

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollDownByPixcels | Exception::desc::::" + e.getMessage());
		}
	}

	public static void scrollupByPixcels(int pixelValue) {
		try {
			Log.info("scrollupByPixcels MEthod Action is Started ..........");
			executeScript("window.scrollTo(0," + pixelValue + ")", "");

		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollupByPixcels | Exception::desc::::" + e.getMessage());
		}
	}

	/*
	 * Generate Random Number Generation 100, 1
	 */
	public static int generateRandomNumber(int max, int min) {
		Log.info("generateRandomNumber Method Action is started..");
		int randomNum = 0;
		try {
			randomNum = (int) Math.floor(Math.random() * (max - min) + min);
		} catch (Exception e) {
			Log.error("Class Utilities | Method scrollIntoView | Exception: :desc::::" + e.getMessage());
		}
		return randomNum;
	}

	/* verify element is present - returns true and false */
	public static synchronized boolean verifyElementPresent(WebElement element) throws Exception {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
			Log.info(element.getText() + "is Displayed.......");
		} catch (Exception e) {
			Log.error("Element not found:" + e.getMessage());
			Log.error("Class Utilities | Method verifyElementPresent | Exception: :desc::::" + e.getMessage());
		}
		return isDisplayed;
	}

	/* verify element is present - driver Fails method if any exception occurs */
	public static synchronized void verifyElementPresentEX(WebElement element) throws Exception {
		try {
			element.isDisplayed();
			Log.info(element.getText() + "is Displayed.......");
		} catch (Exception e) {
			Log.error("Element not found:" + e.getMessage());
			throw new Exception(e);
		}
	}

	/* verify element is not present - return true */
	public static synchronized boolean verifyElementNOTPresent(WebElement element) throws Exception {
		boolean isDisplayed = true;
		try {
			isDisplayed = element.isDisplayed();
			Log.info(element.getText() + "is NOT Displayed.......");
		} catch (Exception e) {
			Log.error("Element found in Page:" + e.getMessage());
			Log.error("Class Utilities | Method verifyElementPresent | Exception: :desc::::" + e.getMessage());
		}
		return isDisplayed;
	}

	public static synchronized boolean verifyTextEquals(WebElement element, String expectedText) throws Exception {
		boolean flag = false;
		Log.info("verifyTextEquals Method Action is started..");
		try {
			String actualText = element.getText().trim();

			if (actualText.equals(expectedText)) {
				Log.info("Actual text is::. " + actualText + "::" + "Expected Text is :::" + expectedText);
				flag = true;
			} else {
				Log.info("Actual text is::. " + actualText + "::" + "Expected Text is :::" + expectedText);
				throw new Exception("Actual text = " + actualText + " is not same as Expected text = " + expectedText);
			}
		} catch (Exception e) {
			Log.error("Text not found::.:" + e);
			Log.error("Class Utilities | Method verifyTextEquals | Exception: :desc::::" + e.getMessage());
			throw new Exception("Error while verifying text", e);
		}
		return flag;
	}

	public static String captureScreenshotss() {

		String screenshotBase64 = null;

		try {

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			byte[] bytes = Files.readAllBytes(Paths.get(screenshotFile.getAbsolutePath()));

			screenshotBase64 = Base64.encodeBase64String(bytes);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return screenshotBase64;

	}

	public static String getScreenshotsAs(WebDriver driver, String testName) {

		String screenshotFilePath = Constants.SCREENSHOT_DIR + testName + "_" + System.currentTimeMillis() + ".png";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			Files.copy(screenshotFile.toPath(), Paths.get(screenshotFilePath));

		} catch (IOException e) {

			e.printStackTrace();

		}

		return screenshotFilePath;

	}

	public static String getDeviceName() {
		try {
			InetAddress localMachine = InetAddress.getLocalHost();
			return localMachine.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "Unknown Device";
		}
	}

	public static void pressEnter(WebElement element) throws Exception {
		try {
			element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new Exception("Unable to press ENTER");
		}
	}

	// Move to element and Click
	public static void moveToElementAndClick(WebElement element) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			throw new Exception("No action performed on");
		}
	}

	// Move to element and Click
	public static void DoubleClick(WebElement element) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			throw new Exception("No action performed on");
		}
	}

	// Move to element and Click
	public static void setTextAndEnter(WebElement element, String value) throws Exception {
		try {
			Thread.sleep(1000);
			element.sendKeys(value);
			element.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			throw new Exception("No action performed on");
		}
	}

	public static void jsMouseOverNew(WebElement element) throws Exception {
		try {
			String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
			((JavascriptExecutor) driver).executeScript(code, element);

		} catch (Exception e) {
			throw new Exception("No action performed on");
		}

	}

	public static void setText(WebElement element, String value) throws Exception {
		try {
			Thread.sleep(1000);
			element.sendKeys(value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Value not entered into textbox ");
		}
	}

	public static void clickListValue(WebElement element, String string) throws Exception {

		try {

			List<WebElement> options = element.findElements(By.tagName("li"));
			for (WebElement option : options) {
				if (option.getText().trim().equals(string)) {
					System.out.println(string);
					option.click(); // click the desired option
					break;
				}
			}
		}

		catch (Exception e) {

			throw new Exception("General exception: Option not selected from dropdown");
		}

	}

	public static void clickDD(String xpath, String string) throws Exception {

		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));
			for (WebElement option : options) {
				System.out.println(option.getText().trim());
				if (option.getText().trim().contains(string)) {
					jsCLick(option);
					// option.click();
					break;
				}
			}
		}

		catch (Exception e) {

			throw new Exception("General exception: Option not selected from dropdown");
		}

	}

	public static void moveToElementAndEnter(WebElement element, String Value) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().sendKeys(Value).build().perform();
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No such Element present");
		}
	}

	public static void scrollDown() throws Exception {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

		} catch (Exception e) {
			throw new Exception("No such Element present");
		}
	}

	public static void jsCLick(WebElement element) throws Exception {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			throw new Exception("No such Element present");
		}
	}

	public static void waitForAllElementVisibiltyList(List<WebElement> listOfWebelements, int MaxtimeouitinSecond,
			int PollingEveryMillisec) {
		Log.info("waitForElementVisibilty for element method is Started");
		Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfWebelements));
	}

	public static void waitForInvisibilityOfElement(WebElement element, int MaxtimeouitinSecond,
			int PollingEveryMillisec) {
		Log.info("waitForInvisibilityOfElement for element method is Started");
		Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static boolean isDisplayed(WebElement element) throws Exception {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			throw new Exception("Error while checking element is dispalyed");
		}
	}
	
	public static boolean isSelected(WebElement element) throws Exception {
		try {
			return element.isSelected();
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Error while checking element is selected");
		}
	}
	
	public static void clickWebElement(WebElement element) throws Exception {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Error while Clicking element - " + element.getText());
		}
	}

	public static String getText(WebElement element) throws Exception {
		try {
			return element.getText();
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Error while fetching text from element");
		}
	}

	public static void enterBackspaceKey(WebElement element, int count) throws Exception {
		try {
			Actions action = new Actions(driver);
			for (int i = 0; i < count; i++) {
				action.sendKeys(element, Keys.BACK_SPACE).build().perform();
			}

		} catch (Exception e) {
			throw new Exception("Error while pressing backspace key");
		}
	}

	public static void keyPress(Keys key, int count) throws Exception {
		try {
			Actions action = new Actions(driver);
			for (int i = 1; i <= count; i++) {
				action.sendKeys(key).build().perform();
				Thread.sleep(500);
			}

		} catch (Exception e) {
			throw new Exception("Error while pressing backspace key");
		}
	}

	// Move to element
	public static void moveToElement(WebElement element) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			throw new Exception("Error in 'moveToElement'");
		}
	}

	public static void waitForTextToBePresentInElement(WebElement element, String text, int MaxtimeouitinSecond,
			int PollingEveryMillisec) {
		Log.info("waitForTextPresentInElement for element method is Started");
		Wait<WebDriver> wait = getWait(MaxtimeouitinSecond, PollingEveryMillisec);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static String getAttributeValueOfElement(WebElement element, String attribute) throws Exception {
		Log.info("getAttributeValueOfElement for element method is Started");
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			throw new Exception("Error while getting attribute value");
		}
	}
}