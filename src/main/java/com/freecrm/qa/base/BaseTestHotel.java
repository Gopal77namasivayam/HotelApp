package com.freecrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.freecrm.qa.util.TestUtil;
import com.freecrm.qa.util.WebEventListener;

public class BaseTestHotel {

	public static WebDriver driver;
	public static Properties prob;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentHtmlReporter htmlReporter;//look and feel of the report
	 public static ExtentReports reports;//to create the entries in reports
	 public static ExtentTest test;// update the testcase status

	public BaseTestHotel() {
		try {
			prob = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\GOPAL NAMASIVAYAM\\Desktop\\ecli\\freeCRM_maven\\src\\main\\java\\com\\freecrm\\qa\\config\\Config.Properties");
			prob.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialtion() {
		String browsername = prob.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\GOPAL NAMASIVAYAM\\Desktop\\webderivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\GOPAL NAMASIVAYAM\\Desktop\\webderivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.get(prob.getProperty("urlhotel"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
 		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Time_Out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public static void setExtendReport()
	{
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/HotelApp.html");

		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  htmlReporter.config().setTheme(Theme.STANDARD);
		  
		  reports = new ExtentReports();
		  reports.attachReporter(htmlReporter);
		  
		  // Passing General information
		  reports.setSystemInfo("Host name", "localhost");
		  reports.setSystemInfo("Environemnt", "QA");
		  reports.setSystemInfo("user", "Gopal");
	}
	
	public static void endExtendReport()
	{
		reports.flush();
	}
	
	public static void close(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			   String screenshotPath =  BaseTestHotel.getScreenshot(driver, result.getName());
			   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			  }
			  driver.quit();
			 }
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots_Hotel/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
