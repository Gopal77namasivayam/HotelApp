package com.freecrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.Base;
import com.freecrm.qa.pages.ContactPage;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends Base {
	LoginPage logpage;
	HomePage homepage;
	ContactPage contactPage;
	DealsPage dealspage;
	TestUtil testutil;

	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		initialtion();
		logpage = new LoginPage();
		testutil = new TestUtil();// used to switch to frame
		homepage = logpage.login(prob.getProperty("username"), prob.getProperty("password"));

	}

	@Test
	public void homePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title is not matched");
	}

	@Test
	public void verifyUserNameTest() {
		testutil.SwitchToFrame();
		boolean usname = homepage.verifyUserNameTest();
		Assert.assertTrue(usname);
	}

	@Test
	public void clickOnContactTest() {
		testutil.SwitchToFrame();
		contactPage=homepage.clickOnContactLink();
		
	}

	@Test
	public void clickOnDealsTest() {
		testutil.SwitchToFrame();
		dealspage=homepage.clickOnDealsLink();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
