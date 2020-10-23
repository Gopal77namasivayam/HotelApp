package com.freecrm.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.freecrm.qa.base.Base;
import com.freecrm.qa.pages.ContactPage;
import com.freecrm.qa.pages.CreateNewContactPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.ReadDataTest;
import com.freecrm.qa.util.TestUtil;




public class CreateNewContactPageTest extends Base {
	LoginPage logpage;
	HomePage homepage;
	ContactPage contactPage;
	TestUtil testutil;
	CreateNewContactPage conatactcreatepage;
			
	public CreateNewContactPageTest()
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
		conatactcreatepage=homepage.clickOnNewContactLink();
		
		
	}
	
	
//	@Test
//	public void validateContactext() throws InterruptedException
//	{
//		
//		boolean boo =conatactcreatepage.verifyTextTest();
//		Assert.assertTrue( boo);
//	}
	
	@DataProvider
	public Iterator<Object[]> getTestdata()
	{
		ArrayList<Object[]> testData = ReadDataTest.getDataFromExcel();
		return testData.iterator();
	}
	
	
	
	
	
	@Test(dataProvider="getTestdata")
	public void validateConstactSave(String title,String Fname,String Lname,String Company)
	{
		conatactcreatepage.createNewContact(title, Fname, Lname, Company);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
