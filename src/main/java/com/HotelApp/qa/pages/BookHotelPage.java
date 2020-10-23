package com.HotelApp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.BaseTestHotel;

public class BookHotelPage extends BaseTestHotel {
	
	SelectHotelPage hotelPageDetails;
	public static double GSTinBookPage;
	public static double finalBilledProce;
	public static String HotelnameInBookPage1;
	public static String HotelocationInBookPage1;
	public static String HotelTypeInBookPage1;
	public static int NoOfRoomsInBookPage1;
	public static int TodalDaysInBookPage1;
	public static String PriceperNight1;
	public static int RoomPrice1;
	public static int TotalPrice1;
	public static double TotPrice2;//pls use in other classs
	public static double GstinBookPage1;
	public static double finalBilledProceinBookpage1;//pleaseuse this
	public static String FirstnameInBookPage1;
	public static String LastnameInBookPage1;
	public static String AddressInBookPage1;
	public static String CCNumberInBookPage1;
	public static String cType;
	public static String EMonth;
	public static String EYear;
	public static String CCVInBookPage1;

	//PageFactory-OR
	@FindBy(xpath="//input[@id='hotel_name_dis']")
	WebElement HotelnameInBookPage;
	
	
	@FindBy(xpath="//input[@id='location_dis']")
	WebElement locationInBookPage;
	
	@FindBy(xpath="//input[@id='room_type_dis']")
	WebElement RoomtypeInBookPage;
	
	@FindBy(xpath="//input[@id='room_num_dis']")
	WebElement NoOfRoomsInBookPage;
	
	@FindBy(xpath="//input[@id='total_days_dis']")
	WebElement TodalDaysInBookPage;
	
	@FindBy(xpath="//input[@id='price_night_dis']")
	WebElement PricePerNigtInBookPage;
	
	@FindBy(xpath="//input[@id='total_price_dis']")
	WebElement TotalPriceInBookPage;
	
	@FindBy(xpath="//input[@id='gst_dis']")
	WebElement GstInBookPage;
	
	@FindBy(xpath="//input[@id='final_price_dis']")
	WebElement FinalPriceinBookPage;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstNameInBooPage;
	
	@FindBy(xpath="//input[@id='book_now']")
	WebElement BookNow;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement LastNameInBooPage;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement AddressInBooPage;
	
	@FindBy(xpath="//input[@id='cc_num']")
	WebElement CreditcardNumberInBooPage;
	
	@FindBy(xpath="//select[@id='cc_type']")
	WebElement CCTypeInBooPage;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	WebElement ExpiryMonthInBooPage;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	WebElement ExpiryYearInBooPage;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	WebElement CCVInBooPage;
	
	@FindBy(xpath="//input[@id='cancel']")
	WebElement CancelInBooPage;
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Initalization
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	//Action
	
	public String verifyHotalName()
	{
		 return HotelnameInBookPage.getAttribute("value");
	}
	
	public String location()
	{
			 
		return locationInBookPage.getAttribute("value");
	}
	
	public String verifyRoomType()
	{
		 return RoomtypeInBookPage.getAttribute("value");
	}
	
	public int verifyRoomCount()
	{
		 return Integer.parseInt(String.valueOf(NoOfRoomsInBookPage.getAttribute("value").charAt(0)));
	}
	
	public String verifyPricePerNight()
	{
		//String pernightprice=PricePerNigtInBookPage.getAttribute("value").substring(6);
		return PricePerNigtInBookPage.getAttribute("value");
	}
	
	public int verifyTotalPrice()
	{
		return Integer.parseInt(TotalPriceInBookPage.getAttribute("value").substring(6));
	}
	
	public double verifyGST()
	{
		 return Double.parseDouble(GstInBookPage.getAttribute("value").substring(6));
	}
	
	public double gstVsRoomtype()
	{
		if(RoomtypeInBookPage.getAttribute("value").equals("Super Deluxe"))
				{
					GSTinBookPage=43.5;
				}else if(RoomtypeInBookPage.getAttribute("value").equals("Deluxe"))
				{
					GSTinBookPage=33.5;
				}else if(RoomtypeInBookPage.getAttribute("value").equals("Double"))
				{
					GSTinBookPage=23.5;
				}
				else if(RoomtypeInBookPage.getAttribute("value").equals("Standard"))
				{
					GSTinBookPage=13.5;
				}
		
		return GSTinBookPage;
	}
	
	public Double verifyFinalPrice()
	{
		return Double.parseDouble(FinalPriceinBookPage.getAttribute("value").substring(6));
	}
	public void verifyFinalPriceCalculation()
	{
		finalBilledProce=  (SelectHotelPage.expecetdtotalprice*10/100)+(SelectHotelPage.expecetdtotalprice);
	}
	
	
	public BookingConfirmationPage verifyBooknowclick(String Fname,String Lname, String Address,String CCNumber,String CCType,String ExpiryMonth,String ExpiryYear,String CCV)
	{
		FirstNameInBooPage.sendKeys(Fname);
		LastNameInBooPage.sendKeys(Lname);
		AddressInBooPage.sendKeys(Address);
		CreditcardNumberInBooPage.sendKeys(CCNumber);		
		Select ccType=new Select(CCTypeInBooPage);
		ccType.selectByVisibleText(CCType);	
		Select ExMonth=new Select(ExpiryMonthInBooPage);
		ExMonth.selectByVisibleText(ExpiryMonth);
		Select ExYear=new Select(ExpiryYearInBooPage );
		ExYear.selectByVisibleText(ExpiryYear);
		EYear=ccType.getFirstSelectedOption().getText();		
		CCVInBooPage.sendKeys(CCV);		
		BookNow.click();
		
		
		HotelnameInBookPage1=HotelnameInBookPage.getAttribute("value");
		HotelocationInBookPage1= locationInBookPage.getAttribute("value");
		HotelTypeInBookPage1= RoomtypeInBookPage.getAttribute("value");
		NoOfRoomsInBookPage1=Integer.parseInt(String.valueOf(NoOfRoomsInBookPage.getAttribute("value").charAt(0)));
		TodalDaysInBookPage1=Integer.parseInt(String.valueOf(TodalDaysInBookPage.getAttribute("value").charAt(0)));
		PriceperNight1=PricePerNigtInBookPage.getAttribute("value");
		RoomPrice1 = Integer.parseInt(PricePerNigtInBookPage.getAttribute("value").substring(6));
		TotalPrice1 = TodalDaysInBookPage1 * RoomPrice1 + 10;
		TotPrice2=TotalPrice1;
		GstinBookPage1=Double.parseDouble(GstInBookPage.getAttribute("value").substring(6));
		finalBilledProceinBookpage1= (TotPrice2*10/100)+(TotPrice2);
		FirstnameInBookPage1=FirstNameInBooPage.getAttribute("value");
		LastnameInBookPage1=LastNameInBooPage.getAttribute("value");
		AddressInBookPage1=AddressInBooPage.getAttribute("value");
		CCNumberInBookPage1=CreditcardNumberInBooPage.getAttribute("value");
		cType=ccType.getFirstSelectedOption().getText();
		EMonth=ccType.getFirstSelectedOption().getText();
		CCVInBookPage1=CCVInBooPage.getAttribute("value");
		 
		
		
		return  new BookingConfirmationPage();
	}
 
	
	 
	
	
	
	
	
	
	
	
}
