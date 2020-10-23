package com.Hotel.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.HotelApp.qa.pages.BookHotelPage;
import com.HotelApp.qa.pages.HotelHomePage;
import com.HotelApp.qa.pages.LoginPageHotel;
import com.HotelApp.qa.pages.SelectHotelPage;
import com.freecrm.qa.base.BaseTestHotel;

public class BookHotelTest extends BaseTestHotel {
	
	LoginPageHotel hotellogin;
	HotelHomePage hotHomPage;
	SelectHotelPage hotelPageDetails;
	BookHotelPage bookHotel;
    
	
	public BookHotelTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, ParseException {
		initialtion();
		hotellogin = new LoginPageHotel();
		hotHomPage = hotellogin.hotelLogin(prob.getProperty("hotelusername"), prob.getProperty("hotelpassword"));
		hotelPageDetails =hotHomPage.checkSelecetdHotelname("Brisbane", "Hotel Creek", "Double", "3 - Three","24/10/2020", "27/10/2020", "2 - Two", "4 - Four");
		 
		bookHotel=hotelPageDetails.verifyHotelSelection();
		 
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
	public void validateHotelName()
	{
		test = reports.createTest("validateHotelName");
		
		String hotelnameinbook=bookHotel.verifyHotalName();	
		System.out.println(hotelnameinbook);
		System.out.println(SelectHotelPage.HotelNameinSelectPage);
		Assert.assertEquals(hotelnameinbook,SelectHotelPage.HotelNameinSelectPage);
		
	}
	
	@Test(enabled=false)
	public void validateLocationInBookPage()
	{
		test = reports.createTest("validateLocationInBookPage");
		 String locationinBook=bookHotel.location();
		 System.out.println(locationinBook);
		 System.out.println(SelectHotelPage.locationNameInSelectPage);
		 
		Assert.assertEquals(SelectHotelPage.locationNameInSelectPage,locationinBook);
	}
	 
	@Test(enabled=false)
	public void validateRoomTypeInBookPage()
	{
		test = reports.createTest("validateRoomTypeInBookPage");
		String RoomType=bookHotel.verifyRoomType();
		System.out.println(RoomType);
		System.out.println(SelectHotelPage.RoomTypeInHotelSelectoinPage);
		Assert.assertEquals(SelectHotelPage.RoomTypeInHotelSelectoinPage,RoomType);
	}
	
	@Test(enabled=false)
	public void validateRoomcountinBookpage()
	{
		test = reports.createTest("validateRoomcountinBookpage");
		int RoomCount=bookHotel.verifyRoomCount();
		System.out.println(RoomCount);
		System.out.println(SelectHotelPage.CountRoomInSelectHotelPage);
		Assert.assertEquals(SelectHotelPage.CountRoomInSelectHotelPage,RoomCount);
	}
	@Test(enabled=false)
	public void validatePricePerNNight()
	{
		test = reports.createTest("validatePricePerNNight");
		String pricePerNight=bookHotel.verifyPricePerNight();
		System.out.println(pricePerNight);
		System.out.println(SelectHotelPage.PriceperNight);
		Assert.assertEquals(SelectHotelPage.PriceperNight,pricePerNight);
	}
	@Test(enabled=false)
	public void validateTotalPrice()
	{
		test = reports.createTest("validateTotalPrice");
		double  totPrice= Double.valueOf(bookHotel.verifyTotalPrice());
		System.out.println(totPrice);
		System.out.println(SelectHotelPage.expecetdtotalprice);
		Assert.assertEquals(SelectHotelPage.expecetdtotalprice,totPrice);
	}
	
	@Test(enabled=false)
	public void validdateGST()
	{
		test = reports.createTest("validdateGST");
		double  totPrice=bookHotel.verifyGST();
		System.out.println(totPrice);
		bookHotel.gstVsRoomtype();
		System.out.println(BookHotelPage.GSTinBookPage);
		Assert.assertEquals(BookHotelPage.GSTinBookPage,totPrice);
	}
	
	@Test
	public void validateFinalprice()
	{

		test = reports.createTest("validateFinalprice");
		double  finalPrice=bookHotel.verifyFinalPrice();
		System.out.println("in bookpage"+finalPrice);
		bookHotel.verifyFinalPriceCalculation();
		System.out.println(BookHotelPage.finalBilledProce);
		Assert.assertEquals(finalPrice,BookHotelPage.finalBilledProce);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		close(result);
	}
	
	
	
	
	
	
	
	
	
	
}
