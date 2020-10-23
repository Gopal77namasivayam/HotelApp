package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.Base;

public class ContactPage extends Base {
	
	//Pagefactory -OR
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	//new contact
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
	
	//initialation
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public boolean verifyContactLabel()
	{
		 return contactlabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	

}
