package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.ProductPage1;

public class ProductPageTest1 extends TestBase {

	HomePage homePage;
	ProductPage1 productPage1;

	public ProductPageTest1() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		homePage = new HomePage();
		productPage1 = new ProductPage1();
	}

	@Test(priority = 1)
	public void navigateToProductPage() {
		homePage.search1("iphone 13");
	}

	@Test(priority = 2)
	public void selectBrand() {
		productPage1.clickProduct();
	}
	
	@Test(priority = 3,description = "SCENARIO 2: Product is NOT Available")
	public void validateCart()
	{
		productPage1.switchTab();
		productPage1.handleUnavailableProduct();
	}

	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
