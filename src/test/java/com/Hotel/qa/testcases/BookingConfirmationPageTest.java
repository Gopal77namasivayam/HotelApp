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
import com.HotelApp.qa.pages.BookingConfirmationPage;
import com.HotelApp.qa.pages.HotelHomePage;
import com.HotelApp.qa.pages.LoginPageHotel;
import com.HotelApp.qa.pages.SelectHotelPage;
import com.freecrm.qa.base.BaseTestHotel;

public class BookingConfirmationPageTest extends BaseTestHotel {
	LoginPageHotel hotellogin;
	HotelHomePage hotHomPage;
	SelectHotelPage hotelPageDetails;
	BookHotelPage bookHotel;
	BookingConfirmationPage confirmpage;
	
		
	public BookingConfirmationPageTest()
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
	public void validateHotelNameinBConfirmationPage()
	{

		test = reports.createTest("validateHotelNameinBConfirmationPage");
		String   Hotelnameinconfirmationpage=confirmpage.verifyHotelNameInBookCoinfimPage();
		System.out.println("HotelName in confirmation page: "+Hotelnameinconfirmationpage);
		 
		System.out.println("HotelName in booking page :"+BookHotelPage.HotelnameInBookPage1);
		Assert.assertEquals(Hotelnameinconfirmationpage,BookHotelPage.HotelnameInBookPage1 );
	}
	@Test(enabled=false)
	public void validateHotellocaiontinBConfirmationPage()
	{

		test = reports.createTest("validateHotellocaiontinBConfirmationPage");
		String   Hotellocaiontinconfirmationpage=confirmpage.verifyHotelLocationInBookCoinfimPage();
		System.out.println("location in confirmation page: "+Hotellocaiontinconfirmationpage);
		 
		System.out.println("location in booking page :"+BookHotelPage.HotelocationInBookPage1);
		Assert.assertEquals(Hotellocaiontinconfirmationpage,BookHotelPage.HotelocationInBookPage1 );
	}
	
	@Test(enabled=false)//system has bug as it always shown delux so this tc will fail
	public void validateHotelRoomTypeBConfirmationPage()
	{

		test = reports.createTest("validateHotelRoomTypeBConfirmationPage");
		String   HotelRoomTypeconfirmationpage=confirmpage.verifyHotelroomTypeInBookCoinfimPage();
		System.out.println("RoomType in confirmation page: "+HotelRoomTypeconfirmationpage);
		 
		System.out.println("RoomType in booking page :"+BookHotelPage.HotelTypeInBookPage1);
		Assert.assertEquals(HotelRoomTypeconfirmationpage,BookHotelPage.HotelTypeInBookPage1 );
	}
	
	@Test(enabled=false)
	public void validatechkinDateBConfirmationPage()
	{

		test = reports.createTest("validatechkinDateBConfirmationPage");
		String   Hotelchkinconfirmationpage=confirmpage.verifyHotelChkinDateInBookCoinfimPage();
		System.out.println("chkIn date in confirmation page: "+Hotelchkinconfirmationpage);
		 
		System.out.println("chkIn dat in booking page :"+HotelHomePage.chkindate);
		Assert.assertEquals(Hotelchkinconfirmationpage,HotelHomePage.chkindate );
	}
	
	@Test(enabled=false)
	public void validatechkOutDateBConfirmationPage()
	{

		test = reports.createTest("validatechkOutDateBConfirmationPage");
		String   HotelchkOutconfirmationpage=confirmpage.verifyHotelChkOutDateInBookCoinfimPage();
		System.out.println("chkout date in confirmation page: "+HotelchkOutconfirmationpage);
		 
		System.out.println("chkout date in booking page :"+HotelHomePage.chkoutDate);
		Assert.assertEquals(HotelchkOutconfirmationpage,HotelHomePage.chkoutDate );
	}
	
	
	
	@Test(enabled=false)
	public void validateTotalRoomsConfirmationPage()
	{

		test = reports.createTest("validateTotalRoomsConfirmationPage");
		int   HotelTotalRoomsConfirmationpage=confirmpage.verifyNoOfRoomsInBookCoinfimPage();
		System.out.println("NumberOfrooms in confirmation page: "+HotelTotalRoomsConfirmationpage);
		 
		System.out.println("NumberOfrooms in booking page :"+BookHotelPage.NoOfRoomsInBookPage1);
		Assert.assertEquals(HotelTotalRoomsConfirmationpage,BookHotelPage.NoOfRoomsInBookPage1 );
	}
	@Test(enabled=false)
	public void validateTotalDaysConfirmationPage()
	{

		test = reports.createTest("validateTotalDaysConfirmationPage");
		int   HotelTotalDaysConfirmationpage=confirmpage.verifyNoOfRoomsInBookCoinfimPage();
		System.out.println("Totaldays in confirmation page: "+HotelTotalDaysConfirmationpage);
		 
		System.out.println("Totaldays in booking page :"+BookHotelPage.TodalDaysInBookPage1);
		Assert.assertEquals(HotelTotalDaysConfirmationpage,BookHotelPage.TodalDaysInBookPage1 );
	}
	
	@Test(enabled=false)
	public void validateTotalAdultsConfirmationPage()
	{

		test = reports.createTest("validateTotalAdultsConfirmationPage");
		int   HotelTotalAdultsConfirmationpage=confirmpage.verifyAdultCountBookCoinfimPage();
		System.out.println("Adults in confirmation page: "+HotelTotalAdultsConfirmationpage);
		 
		System.out.println("Adults in booking page :"+HotelHomePage.Adults1);
		Assert.assertEquals(HotelTotalAdultsConfirmationpage,HotelHomePage.Adults1 );
	}
	
	@Test(enabled=false)
	public void validateTotalChildrenConfirmationPage()
	{

		test = reports.createTest("validateTotalChildrenConfirmationPage");
		int   HotelTotalChildConfirmationpage=confirmpage.verifyChildCountBookCoinfimPage();
		System.out.println("Adults in confirmation page: "+HotelTotalChildConfirmationpage);
		 
		System.out.println("Adults in booking page :"+ HotelHomePage.Children1);
		Assert.assertEquals(HotelTotalChildConfirmationpage,HotelHomePage.Children1 );
	}
	@Test(enabled=false)
	public void validatePricepernightConfirmationPage()
	{

		test = reports.createTest("validatePricepernightConfirmationPage");
		int   RoomPricepernightConfirmationpage=confirmpage.verifyPricePerNightCoinfimPage();
		System.out.println("pricepernight in confirmation page: "+RoomPricepernightConfirmationpage);
		 
		System.out.println("pricepernight in booking page :"+ BookHotelPage.RoomPrice1 );
		Assert.assertEquals(RoomPricepernightConfirmationpage,BookHotelPage.RoomPrice1); 
	}
	
	
	@Test(enabled=false)
	public void validateTotalPriceConfirmationPage()
	{

		test = reports.createTest("validateTotalPriceConfirmationPage");
		int   TotalPriceConfirmationpage=confirmpage.verifyTotalPriceCoinfimPage();
		System.out.println("total price in confirmation page: "+TotalPriceConfirmationpage);
		 
		System.out.println("total price  in booking page :"+ BookHotelPage.TotalPrice1 );
		Assert.assertEquals(TotalPriceConfirmationpage,BookHotelPage.TotalPrice1); 
	}
	
	@Test(enabled=false)
	public void validateFinalPriceConfirmationPage()
	{

		test = reports.createTest("validateFinalPriceConfirmationPage");
		double FinalPriceConfirmationpage=confirmpage.verifyFinalPriceCoinfimPage();
		System.out.println("total price in confirmation page: "+FinalPriceConfirmationpage);
		 
		System.out.println("total price  in booking page :"+ BookHotelPage.finalBilledProceinBookpage1  );
		Assert.assertEquals(FinalPriceConfirmationpage,BookHotelPage.finalBilledProceinBookpage1 ); 
	}
	
	@Test
	public void validateOrderNoConfirmationPage()
	{

		test = reports.createTest("validateOrderNoConfirmationPage");
		boolean OrdernoConfirmationpage=confirmpage.vefrifyOrderNumber();
		System.out.println("total price in confirmation page: "+OrdernoConfirmationpage);
		Assert.assertFalse(OrdernoConfirmationpage); 
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		close(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
