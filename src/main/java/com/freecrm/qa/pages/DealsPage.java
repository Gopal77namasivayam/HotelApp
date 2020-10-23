package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.Base;



public class DealsPage extends Base {
	
	//PageFactory -OR
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement DelasText;
	//@FindBy(xpath="//a[contains(text(),'Raja')]/parent::td//following-sibling::td[5]//a//i[@title='Edit' and @class='fa fa-edit']")
	//WebElement nameEdit;
	//Initiliation
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public boolean verifyDelasText()
	{
		 return DelasText.isDisplayed();
	}
	
	public DealsEditPage verifyEditName(String name)
	
	{
		 driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//following-sibling::td[5]//a//i[@title='Edit' and @class='fa fa-edit']")).click();
		 return new DealsEditPage();
	}
	

}
