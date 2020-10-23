package com.Hotel.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.HotelApp.qa.pages.BookHotelPage;
import com.HotelApp.qa.pages.BookingConfirmationPage;
import com.HotelApp.qa.pages.HotelHomePage;
import com.HotelApp.qa.pages.LoginPageHotel;
import com.HotelApp.qa.pages.MyItineraryPage;
import com.HotelApp.qa.pages.SelectHotelPage;
import com.freecrm.qa.base.BaseTestHotel;

public class MyItineraryPageTest extends BaseTestHotel {
	LoginPageHotel hotellogin;
	HotelHomePage hotHomPage;
	SelectHotelPage hotelPageDetails;
	BookHotelPage bookHotel;
	BookingConfirmationPage confirmpage;
	MyItineraryPage ItineraryPage;
	
	
	public MyItineraryPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, ParseException {
		initialtion();
		hotellogin = new LoginPageHotel();
		hotHomPage = hotellogin.hotelLogin(prob.getProperty("hotelusername"), prob.getProperty("hotelpassword"));
		hotelPageDetails =hotHomPage.checkSelecetdHotelname("Brisbane", "Hotel Creek", "Double", "3 - Three","24/10/2020", "27/10/2020", "2 - Two", "4 - Four");
		 
		bookHotel=hotelPageDetails.verifyHotelSelection();
		confirmpage=bookHotel.verifyBooknowclick("Gopal","Namasivayam","AnnaNagar,Chennai","7645764576457645","VISA","March","2022","2345");
		ItineraryPage=confirmpage.verifyMyitinery();
	}
	
	@BeforeTest
	public void setExtent() {

		setExtendReport();

	}

	@AfterTest
	public void endReport() {
		endExtendReport();
	}
	
	@Test
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		close(result);
	
	
	}
	
}
