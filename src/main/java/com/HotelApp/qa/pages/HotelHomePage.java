package com.HotelApp.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.BaseTestHotel;

public class HotelHomePage extends BaseTestHotel {
    public static String selecetdHotel;
    
    public static String hotelname;
    
    public static  String chkindate;
    
    public static String chkoutDate;
    
    public static char Roomscount;
    
    public static String rootpe;
    
    public static int Adults1;
    
    public static int Children1;
    
    public static  Object searchhotel;
    
    
    
    
    
	// Pagefactory -OR for loginPage
	@FindBy(xpath = "//td[contains(text(),'Welcome to Adactin Group of Hotels')]")
	WebElement WelcomeText;

	@FindBy(xpath = "//select[@id='location']")
	WebElement HotelLoacation;

	@FindBy(xpath = "//select[@id='hotels']")
	WebElement HotelName;

	@FindBy(xpath = "//select[@id='room_type']")
	WebElement Hotel_RoomType;

	@FindBy(xpath = "//select[@id='room_nos']")
	WebElement NoOfRooms;

	@FindBy(xpath = "//input[@id='datepick_in']")
	WebElement CheckIn;

	@FindBy(xpath = "//input[@id='datepick_out']")
	WebElement CheckOut;

	@FindBy(xpath = "//select[@id='adult_room']")
	WebElement NoOfAdult;

	@FindBy(xpath = "//select[@id='child_room']")
	WebElement NoOfChildren;

	@FindBy(xpath = "//input[@id='Submit']")
	WebElement SearchHotel;

	@FindBy(xpath = "//input[@id='Reset']")
	WebElement Reset;
	
	//Select Hotel page
	@FindBy(xpath="//input[@value='Sydney']")
	WebElement SelecetdHotelname;

	// Error messgae

	@FindBy(xpath = "//span[@id='checkin_span']")
	WebElement CheckInError;

	@FindBy(xpath = "//span[@id='checkout_span']")
	WebElement CheckoutError;

	// Initalizing
	public HotelHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifyWelcomeText() {
		return WelcomeText.isDisplayed();

	}

	public String checkInDateError(String location, String hotelName, String roomType, String roomsReq,
			String chkinDate, String chkOutDate, String Adu, String child) {

		Select loc = new Select(HotelLoacation);
		loc.selectByVisibleText(location);

		Select hot = new Select(HotelName);
		hot.selectByVisibleText(hotelName);

		Select rt = new Select(Hotel_RoomType);
		rt.selectByVisibleText(roomType);

		Select rooms = new Select(NoOfRooms);
		rooms.selectByVisibleText(roomsReq);
		CheckIn.clear();
		CheckIn.sendKeys(chkinDate);
		CheckOut.clear();
		CheckOut.sendKeys(chkOutDate);

		Select Adults = new Select(NoOfAdult);
		Adults.selectByVisibleText(Adu);

		Select Children = new Select(NoOfChildren);
		Children.selectByVisibleText(child);
		
		

		SearchHotel.click();

		return CheckInError.getText();

	}

	public String checkOutDateError(String location, String hotelName, String roomType, String roomsReq,
			String chkinDate, String chkOutDate, String Adu, String child) {

		Select loc = new Select(HotelLoacation);
		loc.selectByVisibleText(location);

		Select hot = new Select(HotelName);
		hot.selectByVisibleText(hotelName);

		Select rt = new Select(Hotel_RoomType);
		rt.selectByVisibleText(roomType);

		Select rooms = new Select(NoOfRooms);
		rooms.selectByVisibleText(roomsReq);
		CheckIn.clear();
		CheckIn.sendKeys(chkinDate);
		CheckOut.clear();
		CheckOut.sendKeys(chkOutDate);

		Select Adults = new Select(NoOfAdult);
		Adults.selectByVisibleText(Adu);

		Select Children = new Select(NoOfChildren);
		Children.selectByVisibleText(child);

		SearchHotel.click();

		return CheckoutError.getText();

	}
	public String checkInPastDateError(String location, String hotelName, String roomType, String roomsReq,
			String chkinDate, String chkOutDate, String Adu, String child) {

		Select loc = new Select(HotelLoacation);
		loc.selectByVisibleText(location);

		Select hot = new Select(HotelName);
		hot.selectByVisibleText(hotelName);

		Select rt = new Select(Hotel_RoomType);
		rt.selectByVisibleText(roomType);

		Select rooms = new Select(NoOfRooms);
		rooms.selectByVisibleText(roomsReq);
		CheckIn.clear();
		CheckIn.sendKeys(chkinDate);
		CheckOut.clear();
		CheckOut.sendKeys(chkOutDate);

		Select Adults = new Select(NoOfAdult);
		Adults.selectByVisibleText(Adu);

		Select Children = new Select(NoOfChildren);
		Children.selectByVisibleText(child);

		SearchHotel.click();

		return CheckInError.getText();

	}
	public SelectHotelPage checkSelecetdHotelname(String location, String hotelName, String roomType, String roomsReq,
			String chkinDate, String chkOutDate, String Adu, String child) {

		Select loc = new Select(HotelLoacation);
		loc.selectByVisibleText(location);
		selecetdHotel= loc.getFirstSelectedOption().getText();
		
		Select hot = new Select(HotelName);
		hot.selectByVisibleText(hotelName);
		hotelname=hot.getFirstSelectedOption().getText();

		Select rt = new Select(Hotel_RoomType);
		rt.selectByVisibleText(roomType);
		rootpe=rt.getFirstSelectedOption().getText();

		Select rooms = new Select(NoOfRooms);
		rooms.selectByVisibleText(roomsReq);
		String Roo=rooms.getFirstSelectedOption().getText().trim();
		Roomscount=Roo.charAt(0);
		
		CheckIn.clear();
		CheckIn.sendKeys(chkinDate);
		chkindate=CheckIn.getAttribute("value");
		
		
		CheckOut.clear();
		CheckOut.sendKeys(chkOutDate);
		chkoutDate=CheckOut.getAttribute("value");
		
		Select Adults = new Select(NoOfAdult);
		Adults.selectByVisibleText(Adu);
		Adults1=Integer.parseInt(String.valueOf(Adults.getFirstSelectedOption().getText().charAt(0)));

		Select Children = new Select(NoOfChildren);
		Children.selectByVisibleText(child);
		Children1=Integer.parseInt(String.valueOf(Children.getFirstSelectedOption().getText().charAt(0)));;
		SearchHotel.click();

		return new SelectHotelPage();

	}
	
	public void searchhoteldata()
	{
	ArrayList<Object> searchhotel=new ArrayList<Object>();
	searchhotel.add(selecetdHotel );
	searchhotel.add(hotelname);
	searchhotel.add(rootpe);
	searchhotel.add(Roomscount);
	searchhotel.add(chkindate);
	searchhotel.add(chkoutDate);
	}
	
	
	
	
	
}
