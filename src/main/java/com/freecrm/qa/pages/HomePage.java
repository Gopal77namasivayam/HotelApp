package com.freecrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.Base;

public class HomePage extends Base {

	// Pagefactory-OR
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement UsernameLabel;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLinks;
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;

	// Initalizing
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);// this means current class web elements initalized by Pagefacory
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserNameTest()
	{
		 return UsernameLabel.isDisplayed();
	}

	public ContactPage clickOnContactLink()// clicks on contats page constactspage
	{
		
		ContactsLinks.click();
		return new ContactPage();
	}

	public DealsPage clickOnDealsLink()// clicks on deals page dealspage
	{
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public CreateNewContactPage clickOnNewContactLink()
	{
		Actions action =new Actions(driver);
		action.moveToElement(ContactsLinks).build().perform();
		 newContact.click();
		 return new CreateNewContactPage();

	}

}
