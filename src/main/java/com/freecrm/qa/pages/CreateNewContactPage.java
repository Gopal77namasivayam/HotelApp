package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.Base;

public class CreateNewContactPage extends Base {
	//Pagefactory -OR
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement context;
	@FindBy(name="title")
	WebElement Title;
	@FindBy(id="first_name")
	WebElement FirstName;
	@FindBy(id="surname")
	WebElement LastName;
	@FindBy(name="client_lookup")
	WebElement companyName;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveConatact;
	
	//Initilation
	
	public CreateNewContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void createNewContact(String title,String Fname,String Lname,String Company )
	{
		Select select =new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		companyName.sendKeys(Company);
		saveConatact.click();
		
	}
	
	public boolean verifyTextTest()
	
	{
		return context.isDisplayed();
	}

}
