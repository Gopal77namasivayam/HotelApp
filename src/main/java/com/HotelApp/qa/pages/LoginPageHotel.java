package com.HotelApp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.BaseTestHotel;

public class LoginPageHotel extends BaseTestHotel {
	
	
	//Pagefactory -OR for loginPage
	@FindBy(xpath="//input[@id='username']")
	WebElement LoginUsername;
	@FindBy(xpath="//input[@id='password']")
	WebElement LoginPwd;
	@FindBy(xpath="//input[@id='login']")
	WebElement  LoginButton;
	@FindBy(xpath="//a[contains(text(),'Click here to login again')]")
	WebElement LogoutText;
	
	

	// Initalizing
	public LoginPageHotel()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLogouttext()
	{
		 return LogoutText.getText();
	}
		
	//Actions
	
	public HotelHomePage hotelLogin(String Un,String pwd)
	{
		LoginUsername.sendKeys(Un);
		LoginPwd.sendKeys(pwd );
		LoginButton.click();
		return  new HotelHomePage();
	}

}
