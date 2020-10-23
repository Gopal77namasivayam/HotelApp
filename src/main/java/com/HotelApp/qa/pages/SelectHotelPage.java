package com.HotelApp.qa.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.BaseTestHotel;

public class SelectHotelPage extends BaseTestHotel {
	public static double expecetdtotalprice;
	public static int RoomPrice;
	public static int Todaldays;
	public static String locationNameInSelectPage;
	public static String HotelNameinSelectPage;
	public static String RoomTypeInHotelSelectoinPage;
	public static int CountRoomInSelectHotelPage;
	public static String PriceperNight;
	public static String chkin ;
	public static String chkout ;
	public static int diffbetweenChkinAndchkOut;

	// public static Object hotel;
	// Pagefactory
	@FindBy(xpath = "//td[contains(text(),'Select Hotel')]")
	WebElement Welcometext;
	@FindBy(xpath = "//input[@id='location_0']")
	WebElement SelecetdHotelname;// it is location not hotel name

	@FindBy(xpath = "//input[@id='hotel_name_0' and @name='hotel_name_0']")
	WebElement Hotelname;

	@FindBy(xpath = "//input[@id='arr_date_0']")
	WebElement GivenChkindate;
	@FindBy(xpath = "//input[@id='dep_date_0']")
	WebElement GivenChkoutdate;
	@FindBy(xpath = "//input[@id='rooms_0']")
	WebElement NoOfRooms;
	@FindBy(xpath = "//input[@id='room_type_0']")
	WebElement roomTy;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement Logout;
	@FindBy(xpath = "//input[@id='location_0']")
	WebElement Hotellocation;
	@FindBy(xpath = "//input[@id='no_days_0']")
	WebElement NoOfDays;
	@FindBy(xpath = "//input[@id='price_night_0']")
	WebElement PricePerNight;
	@FindBy(xpath = "//input[@id='total_price_0']")
	WebElement TotalPrice;
	@FindBy(xpath = "//input[contains(@id,'hotel_name_0')]//parent::td//preceding-sibling::td//input[@name='radiobutton_0']")
	WebElement SelectHotel;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement ContiniueInHotel;

	// Initalizing
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifySelecetdHotelName() {

		return SelecetdHotelname.getAttribute("value");
	}

	public String verifyGivenchkindate() {

		return GivenChkindate.getAttribute("value");
	}

	public String verifyGivenchkoutdate() {

		return GivenChkoutdate.getAttribute("value");
	}

	public char verifyGivenRoomNumber() {

		return NoOfRooms.getAttribute("value").charAt(0);
	}

	public String verifyRoomType() {

		return roomTy.getAttribute("value");
	}

	public LoginPageHotel verifylogout() {
		Logout.click();
		return new LoginPageHotel();

	}

	public boolean verifyHotelPagedata() {
		ArrayList<Object> hotel = new ArrayList<Object>();
		hotel.add(Hotellocation.getAttribute("value"));
		hotel.add(SelecetdHotelname.getAttribute("value"));
		hotel.add(roomTy.getAttribute("value"));
		hotel.add(NoOfRooms.getAttribute("value").charAt(0));
		hotel.add(GivenChkindate.getAttribute("value"));
		hotel.add(GivenChkoutdate.getAttribute("value"));
		return hotel.equals(HotelHomePage.searchhotel);
	}

	public int verifyTotalPrice() {
		Todaldays = Integer.parseInt(String.valueOf(NoOfDays.getAttribute("value").charAt(0)));
		RoomPrice = Integer.parseInt(PricePerNight.getAttribute("value").substring(6));
		expecetdtotalprice = Todaldays * RoomPrice + 10;
		return Integer.parseInt(TotalPrice.getAttribute("value").substring(6));
	}

	public BookHotelPage verifyHotelSelection() throws ParseException {

		locationNameInSelectPage = SelecetdHotelname.getAttribute("value");
		HotelNameinSelectPage = Hotelname.getAttribute("value");
		RoomTypeInHotelSelectoinPage=roomTy.getAttribute("value");
		CountRoomInSelectHotelPage=Integer.parseInt(String.valueOf(NoOfRooms.getAttribute("value").charAt(0)));
		PriceperNight=PricePerNight.getAttribute("value");
		Todaldays = Integer.parseInt(String.valueOf(NoOfDays.getAttribute("value").charAt(0)));
		RoomPrice = Integer.parseInt(PricePerNight.getAttribute("value").substring(6));
		expecetdtotalprice = Todaldays * RoomPrice + 10;
		chkin=GivenChkindate.getAttribute("value");
	    chkout=GivenChkoutdate.getAttribute("value");
	    
	    Date ArrivalDate=new SimpleDateFormat("dd/MM/yyyy").parse(chkin);
		Date DepartureDate=new SimpleDateFormat("dd/MM/yyyy").parse(chkout);
		long difference = DepartureDate.getTime() - ArrivalDate.getTime();        
	    float daysBetween = (difference / (1000*60*60*24));
	    diffbetweenChkinAndchkOut=(int)daysBetween;
	     
		
		
		SelectHotel.click();
		ContiniueInHotel.click();
		return new BookHotelPage();
	}

	public String verifyhotelNameinselecthote() {
		return Hotelname.getAttribute("value");
	}

	public boolean verifyWelcomeText() {
		return Welcometext.isDisplayed();
	}
	
//	public int calculatedaysDifference() throws ParseException
//	{
//		Date ArrivalDate=new SimpleDateFormat("dd/MM/yyyy").parse(chkin);
//		Date DepartureDate=new SimpleDateFormat("dd/MM/yyyy").parse(chkout);
//		long difference = DepartureDate.getTime() - ArrivalDate.getTime();        
//	    float daysBetween = (difference / (1000*60*60*24));
//	    int diffbetweenChkinAndchkOut=(int)daysBetween;
//	    return diffbetweenChkinAndchkOut;
//	}
	
	 

}
