package com.saudia.qa.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saudia.qa.base.TestBase;
import com.saudia.qa.config.Constants;

 

public class ReportLog extends TestBase {

 

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentSparkReporter spark;
    private ExtentTest test;

 

    public ReportLog(WebDriver driver, String timeStamp, String Report_Name, String Docu_Title, String Hostname) {

 

        this.driver = driver;
        this.extent = new ExtentReports();
        this.spark = new ExtentSparkReporter(new File(Constants.REPORT_DIR + "SaudiaAutomationReports" + timeStamp + ".html"));

 

        spark.config(
                ExtentSparkReporterConfig.builder().theme(Theme.STANDARD).documentTitle(Docu_Title)
                        .reportName(Report_Name).build());
        this.extent.setSystemInfo("Hostname", Hostname);
        this.extent.setSystemInfo("Enviroment", System.getProperty("YOUR_ENVIRONMENT_VARIABLE_NAME"));
        this.extent.setSystemInfo("Username", System.getProperty("user.name"));
        this.extent.attachReporter(spark);
    }

 

    public void startTest(String Testname, String Category, String creatNode) {
        String deviceName = Utilities.getDeviceName();
        test = extent.createTest(Testname);
        test.assignAuthor(System.getProperty("user.name"));
        test.assignCategory(Category);
        test.assignDevice(deviceName);
       // test.createNode(creatNode);
        test.log(Status.INFO, "Test '" + Testname + "' started.");
      //  test.addScreenCaptureFromBase64String(Utilities.captureScreenshotss());
    }

 

    public void endTest() {
         test.log(Status.INFO, "Test ended.");
    }

 

    public void endSuite() {
      //  test.log(Status.INFO, "End of the TestSuite");
        extent.flush();
        // Desktop.getDesktop().browse(new File("report.html").toURI());
    }

 

    public void logPass(String stepName, String CheckPointDetails) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.pass(stepName + ": " + CheckPointDetails,
                    MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
           // test.log(Status.PASS,stepName + ": " + CheckPointDetails);
        }
    }

 
    public void logPass(String message) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.pass(message,MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
        }
    }

    public void logFail(String stepName, String string) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.fail(stepName + ": " + string,
                    MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
           // test.log(Status.FAIL,stepName + ": " + string);
        }
    }

    public void logFail(String stepName, Throwable t) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.fail(t, MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
           //test.fail(t);
        }
    }

 

    public void logInfo(String stepName, String CheckPointDetails) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.info("Step - " + stepName + ": " + CheckPointDetails,
                    MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
           // test.log(Status.INFO, "Step - " + stepName + ": " + CheckPointDetails);
        }
    }


    public void logWarn(String stepName, String CheckPointDetails) {
        if (test != null) {
            String screenShootFilePath = Utilities.getScreenshotsAs(driver, test.getModel().getName());
            test.warning("Step - " + stepName + ": " + CheckPointDetails,
                    MediaEntityBuilder.createScreenCaptureFromPath("."+screenShootFilePath).build());
          //  test.log(Status.WARNING, "Step - " + stepName + ": " + CheckPointDetails);
        }
    }

 

    public void logSkip(String stepName, String CheckPointDetails) {
        if (test != null) {
            test.skip("Step - " + stepName + ": " + CheckPointDetails);
         //   test.log(Status.SKIP, "Step - " + stepName + ": " + CheckPointDetails);
        }
    }
    
	public void AssertTrue(boolean condition, String StepDesc) throws Exception {
		try {
			Assert.assertTrue(condition);
		} catch (Throwable t) {
			throw new Exception(StepDesc, t);
		}

	}
	 
}