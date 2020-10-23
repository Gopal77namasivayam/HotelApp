package com.Hotel.qa.testcases;

import static org.testng.Assert.assertEquals;

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

public class SelectedHotelPageTest extends BaseTestHotel {

	LoginPageHotel hotellogin;
	HotelHomePage hotHomPage;
	SelectHotelPage hotelPageDetails;
	BookHotelPage bookHotel;

	public SelectedHotelPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, ParseException {
		initialtion();
		hotellogin = new LoginPageHotel();
		hotHomPage = hotellogin.hotelLogin(prob.getProperty("hotelusername"), prob.getProperty("hotelpassword"));
		hotelPageDetails = hotHomPage.checkSelecetdHotelname("Brisbane", "Hotel Creek", "Super Deluxe", "3 - Three",
				"24/10/2020", "28/10/2020", "2 - Two", "4 - Four");
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
	@Test(enabled = false)
	public void validateGivenRoomType() {
		test = reports.createTest("validateGivenRoomType");
		String roomsty = hotelPageDetails.verifyRoomType();
		System.out.println(" Selecetd Room number :" + HotelHomePage.rootpe);
		System.out.println("Rooms count that displayed in hotel details page is  :" + roomsty);

		Assert.assertEquals(roomsty, HotelHomePage.rootpe);
	}
	@Test(enabled = false)
	public void validateGivenRoomNumber() {
		test = reports.createTest("validateGivenRoomNumber");
		char rooms = hotelPageDetails.verifyGivenRoomNumber();
		System.out.println(" Selecetd Room number :" + HotelHomePage.Roomscount);
		System.out.println("Rooms count that displayed in hotel details page is  :" + rooms);

		Assert.assertEquals(rooms, HotelHomePage.Roomscount);
	}

	@Test(enabled = false)
	public void validateSelecetdHotelName() {
		test = reports.createTest("validateSelecetdHotelName");
		String honame = hotelPageDetails.verifySelecetdHotelName();
		System.out.println("selecetd hotel name is :" + HotelHomePage.selecetdHotel);
		System.out.println("hotel name that displayed in hotel details page is  :" + honame);

		Assert.assertEquals(honame, HotelHomePage.selecetdHotel);
	}

	@Test(enabled = false)
	public void validateGivenChkinDate() {
		test = reports.createTest("validateGivenChkinDate");
		String arrivaldate = hotelPageDetails.verifyGivenchkindate();
		System.out.println("given chkin date is :" + HotelHomePage.chkindate);
		System.out.println("chk in date that displayed in hotel details page is  :" + arrivaldate);

		Assert.assertEquals(arrivaldate, HotelHomePage.chkindate);
	}

	@Test(enabled = false)
	public void validateGivenChkoutDate() {
		test = reports.createTest("validateGivenChkoutDate");
		String depardate = hotelPageDetails.verifyGivenchkoutdate();
		System.out.println(" given chkout date is :" + HotelHomePage.chkoutDate);
		System.out.println("chk out date that displayed in hotel details page is  :" + depardate);

		Assert.assertEquals(depardate, HotelHomePage.chkoutDate);
	}

	@Test(enabled = false)
	public void validaateWelcomeTextTest() {
		test = reports.createTest("validateWelcomeTextTest");
		boolean text = hotelPageDetails.verifyWelcomeText();
		Assert.assertTrue(text);
	}
	
	@Test(enabled = false)
	public void validateLogout()
	{
		test = reports.createTest("validateLogout");
		hotelPageDetails.verifylogout();
		String loouttext=hotellogin.verifyLogouttext();
		Assert.assertEquals(loouttext, "Click here to login again");
	}
	
	@Test(enabled = false)
	public void validateSerachAndHotelData()
	{	
		test = reports.createTest("validateSerachAndHotelData");
		boolean hoteldata =  hotelPageDetails.verifyHotelPagedata();
		Assert.assertTrue(hoteldata);
	}
	
	@Test(enabled = false)
	public void validateTotalPrice()
	{
		test = reports.createTest("validateTotalPrice");
		System.out.println(SelectHotelPage.expecetdtotalprice);
		System.out.println(SelectHotelPage.Todaldays);
		System.out.println(SelectHotelPage.RoomPrice);
		int TP=hotelPageDetails.verifyTotalPrice();
		Assert.assertEquals(TP, SelectHotelPage.expecetdtotalprice);
	}
	
	@Test(enabled = false)
	public void validateHOtelName()
	{
		test = reports.createTest("validateHOtelName");
		String hotelname=hotelPageDetails.verifyhotelNameinselecthote();
		System.out.println(hotelname);
		System.out.println(HotelHomePage.hotelname);
		Assert.assertEquals(hotelname, HotelHomePage.hotelname);
	}
	@Test
	public void validateDaysDifferenceBwnCkinAndchkout() throws ParseException
	
	{
		test = reports.createTest("validateDaysDifferenceBwnCkinAndchkout");
		System.out.println(SelectHotelPage.Todaldays);
		//hotelPageDetails.calculatedaysDifference();
		System.out.println(SelectHotelPage.diffbetweenChkinAndchkOut);
		Assert.assertEquals(SelectHotelPage.Todaldays, SelectHotelPage.diffbetweenChkinAndchkOut);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		close(result);
	}

}
