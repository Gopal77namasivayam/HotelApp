package com.freecrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.Base;
import com.freecrm.qa.pages.DealsEditPage;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class DealsPageTest extends Base {
	//create constructor
	LoginPage logpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealspage;
	DealsEditPage dealseditpage;
	
	public DealsPageTest()
	{
		super();
	}
	//Setup
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialtion();
		 LoginPage logpage =new LoginPage();
		 homepage =logpage.login(prob.getProperty("username"), prob.getProperty("password"));
		 testutil = new TestUtil();
		 testutil.SwitchToFrame();
		 dealspage=homepage.clickOnDealsLink();
	}
	
	@Test
	public void verifyDealsTextTest()
	{
		boolean deals=dealspage.verifyDelasText();
		Assert.assertTrue(deals,"Deals Text is not present");
	}
	
	@Test
	public void dealsEditPageTest()
	{
		dealseditpage=dealspage.verifyEditName("Raja");
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
