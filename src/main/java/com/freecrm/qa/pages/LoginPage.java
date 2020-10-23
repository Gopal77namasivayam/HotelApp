package com.freecrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.Base;
import com.freecrm.qa.base.BaseTestHotel;

public class LoginPage extends Base {
	
	//Pagefactory -OR for loginPage
	
		@FindBy(name="username")//attribute is name and its value is username
		WebElement UserName;
		
		@FindBy(name="password")
		WebElement PassWord;
		
		@FindBy(xpath="//input[@type='submit' and @value='Login']")
		WebElement LoginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement SignUpBtn;
		
		@FindBy(xpath="//img[@class='img-responsive123']")
		WebElement crmLogo;
		// Initalizing 
		public LoginPage() throws IOException
		{
			PageFactory.initElements(driver, this);//this means current class web elements initalized by Pagefacory
		}	
		//Actions
		public String validatateLoginPageTitle()
		{
			return driver.getTitle();
			
		}
		
		public boolean validateLogo()
		{
			 return crmLogo.isDisplayed();
			
		}
		
		public HomePage login(String un,String pw) throws IOException
		{
			UserName.sendKeys(un);
			PassWord.sendKeys(pw);
			LoginBtn.click();
			return new HomePage();
		}
		

}
