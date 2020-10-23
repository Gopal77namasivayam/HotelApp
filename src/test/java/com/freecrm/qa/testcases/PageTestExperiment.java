package com.freecrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.qa.base.BaseTestHotel;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class PageTestExperiment extends BaseTestHotel  {

	LoginPage logpage;
	HomePage homepage;
	TestUtil testutil;
 
	

	public PageTestExperiment() throws IOException {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		initialtion();

		logpage = new LoginPage();

	}

	@BeforeTest
	public void setExtent() {
	 
		setExtendReport();
		 
	}

	@AfterTest
	public void endReport() {
		endExtendReport();
			}

	@Test
	public void loginPageTitleTest() {
		 test=reports.createTest("loginPageTitleTest");
		 String title = logpage.validatateLoginPageTitle();
		 test.createNode("For verifying valid data");
		Assert.assertEquals(title,
		"CRMPRO - CRM software for customer relationship management, sales, and support.");
		test.createNode("For verifying Invalid data");
		Assert.assertEquals(title,
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test
	public void imgExistsTest() {
		test=reports.createTest("imgExistsTest");
		boolean flag = logpage.validateLogo();
		test.createNode("For verifying valid data");
		Assert.assertTrue(flag);
		test.createNode("For verifying Ivalid data");
		Assert.assertTrue(flag);
	}

	@Test
	public void loginTest() throws IOException {
		test=reports.createTest("loginTest");
		homepage = logpage.login(prob.getProperty("username"), prob.getProperty("password"));

	}

	@AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
		
		close(result);
	}
	 

}

