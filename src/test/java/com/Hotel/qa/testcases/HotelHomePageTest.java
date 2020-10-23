package com.Hotel.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.HotelApp.qa.pages.HotelHomePage;
import com.HotelApp.qa.pages.LoginPageHotel;
import com.freecrm.qa.base.BaseTestHotel;

public class HotelHomePageTest extends BaseTestHotel {
	
	LoginPageHotel hotellogin;
	HotelHomePage hotHomPage;

	public HotelHomePageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		initialtion();
		hotellogin= new LoginPageHotel();
		hotHomPage=hotellogin.hotelLogin(prob.getProperty("hotelusername"), prob.getProperty("hotelpassword"));

	}

	@BeforeTest
	public void setExtent() {

		setExtendReport();
		

	}

	@AfterTest
	public void endReport() {
		endExtendReport();
	}
	
	@Test(enabled=false)
	public void validdateHomeWelcomeText()
	{
		test=reports.createTest("validdateHomeWelcomeText");
		boolean welcometext=hotHomPage.verifyWelcomeText();
		Assert.assertTrue(welcometext , "Welcome text is not displayed");
				 
	}
	//@Test(enabled=false)
	
	@Test(enabled=false)
	public void validateCheckIndate()
	{
		test=reports.createTest("validateCheckIndate");
		String chkinError=hotHomPage.checkInDateError("Sydney", "Hotel Creek", "Double", "3 - Three", "24/10/2020", "22/10/2020", "2 - Two", "4 - Four");
		Assert.assertEquals(chkinError, "Check-In Date shall be before than Check-Out Date","error msg is not displayed properly");
		
	}

	@Test(enabled=false)
	public void validateCheckOutdate()
	{
		test=reports.createTest("validateCheckOutdate");
		String chkoutError=hotHomPage.checkOutDateError("Sydney", "Hotel Creek", "Double", "3 - Three", "24/10/2020", "22/10/2020", "2 - Two", "4 - Four");
		Assert.assertEquals(chkoutError, "Check-Out Date shall be after than Check-In Date","error msg is not displayed properly");
		
	}
	
	@Test(enabled=false)
	public void validatePastCheckIndate()//date less than current date
	{
		test=reports.createTest("validatePastCheckIndate");
		String chkinError=hotHomPage.checkInDateError("Sydney", "Hotel Creek", "Double", "3 - Three", "20/10/2020", "15/10/2020", "2 - Two", "4 - Four");
		Assert.assertEquals(chkinError, "Check-In Date shall be before than Check-Out Date","error msg is not displayed properly");
		
	}
	
	 
	
	@AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
		
		close(result);
	}

}
