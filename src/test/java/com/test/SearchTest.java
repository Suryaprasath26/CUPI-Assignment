package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;

public class SearchTest extends TestBase{
	
	HomePage homePage;
	public SearchTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
	}
	
	
	@Test(priority = 1)
	public void searchTest()
	{
		homePage.search("Bluetooth Speakers");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
