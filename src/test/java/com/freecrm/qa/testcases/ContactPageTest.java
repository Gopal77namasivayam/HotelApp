package com.freecrm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.Base;
import com.freecrm.qa.pages.ContactPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactPageTest extends Base {
	LoginPage logpage;
	HomePage homepage;
	ContactPage contactPage;
	TestUtil testutil;
	Logger log = Logger.getLogger(ContactPageTest.class);// this is used to create custom logs
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
			
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialtion();
		testutil = new TestUtil();
		logpage =new LoginPage();
		homepage = logpage.login(prob.getProperty("username"), prob.getProperty("password"));
		testutil.SwitchToFrame();
		contactPage=homepage.clickOnContactLink();
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		
	}
	
	@Test
	public void verifyConstactTextTest()
	{
		log.info("****************************** starting test case by gopalji *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		boolean cp=contactPage.verifyContactLabel();
		Assert.assertTrue(cp);
		log.info("****************************** ending test case *****************************************");
	}
	@Test
	public void verifySelectContactChkBox()
	{
		contactPage.selectContactByName("Aanuj D");
	}
	
	@Test
	public void verifySelectAnotherContactChkBox()
	{
		contactPage.selectContactByName("abhi gowda");
	}
	
		
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
