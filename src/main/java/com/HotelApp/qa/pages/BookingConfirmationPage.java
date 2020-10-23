package com.HotelApp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.BaseTestHotel;

public class BookingConfirmationPage extends BaseTestHotel {
	// Page Factory -OR

	@FindBy(xpath = "//input[@id='hotel_name']")
	WebElement HNameInBookConfirPage;

	@FindBy(xpath = "//input[@id='location']")
	WebElement HLocationInBookConfirPage;

	@FindBy(xpath = "//input[@id='room_type']")
	WebElement RTypeInBookConfirPage;

	@FindBy(xpath = "//input[@id='arrival_date']")
	WebElement ArrDateInBookConfirPage;

	@FindBy(xpath = "//input[@id='departure_text']")
	WebElement DepDateInBookConfirPage;

	@FindBy(xpath = "//input[@id='total_rooms']")
	WebElement TotRoomsInBookConfirPage;
	
	@FindBy(xpath="//input[@id='total_days_dis']")
	WebElement Totaldays;

	@FindBy(xpath = "//input[@id='adults_room']")
	WebElement AdultPerRoomInBookConfirPage;

	@FindBy(xpath = "//input[@id='children_room']")
	WebElement ChildRoomInBookConfirPage;

	@FindBy(xpath = "//input[@id='price_night']")
	WebElement PricePerNightInBookConfirPage;

	@FindBy(xpath = "//input[@id='total_price']")
	WebElement TotPriceInBookConfirPage;

	@FindBy(xpath = "//input[@id='gst']")
	WebElement GstInBookConfirPage;

	@FindBy(xpath = "//input[@id='final_price']")
	WebElement FinalBilledPriceInBookConfirPage;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement FirstNameInBookConfirPage;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement LastNameInBookConfirPage;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement AddressInBookConfirPage;

	@FindBy(xpath = "//input[@id='order_no']")
	WebElement OrderNoInBookConfirPage;

	@FindBy(xpath = " //input[@id='search_hotel']")
	WebElement SearchHotInBookConfirPage;

	@FindBy(xpath = "//input[@id='my_itinerary']")
	WebElement ItineryInBookConfirPage;

	@FindBy(xpath = "//input[@id='logout']")
	WebElement logoutInBookConfirPage;

	// Initializing by creating constructor
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyHotelNameInBookCoinfimPage()

	{
		return HNameInBookConfirPage.getAttribute("value");
	}

	public String verifyHotelLocationInBookCoinfimPage()

	{
		return HLocationInBookConfirPage.getAttribute("value");
	}

	public String verifyHotelroomTypeInBookCoinfimPage()

	{
		return RTypeInBookConfirPage.getAttribute("value");
	}

	public String verifyHotelChkinDateInBookCoinfimPage()

	{
		return ArrDateInBookConfirPage.getAttribute("value");
	}

	public String verifyHotelChkOutDateInBookCoinfimPage()

	{
		return DepDateInBookConfirPage.getAttribute("value");
	}

	public int verifyNoOfRoomsInBookCoinfimPage()

	{
		return Integer.parseInt(String.valueOf(TotRoomsInBookConfirPage.getAttribute("value").charAt(0)));
	}

	public int verifyTodaldaysInBookCoinfimPage()

	{
		return Integer.parseInt(String.valueOf(Totaldays.getAttribute("value").charAt(0)));
	}
	
	public int verifyAdultCountBookCoinfimPage()

	{
		return Integer.parseInt(String.valueOf(AdultPerRoomInBookConfirPage.getAttribute("value").charAt(0)));
	}
	
	public int verifyChildCountBookCoinfimPage()

	{
		return Integer.parseInt(String.valueOf(ChildRoomInBookConfirPage.getAttribute("value").charAt(0)));
	}
	public int verifyPricePerNightCoinfimPage()

	{
		return Integer.parseInt(PricePerNightInBookConfirPage.getAttribute("value").substring(6));
	}
	
	public int verifyTotalPriceCoinfimPage()

	{
		return Integer.parseInt(TotPriceInBookConfirPage.getAttribute("value").substring(6));
	}
	
	public double verifyFinalPriceCoinfimPage()

	{
		return Double.parseDouble(FinalBilledPriceInBookConfirPage.getAttribute("value").substring(6));
	}
	
	
	
	public boolean vefrifyOrderNumber()
	{
		 return OrderNoInBookConfirPage.getAttribute("value").isEmpty();
	}
	
	
	public MyItineraryPage verifyMyitinery()
	{
		ItineryInBookConfirPage.click();
		return  new MyItineraryPage();
	}
	
	
}
