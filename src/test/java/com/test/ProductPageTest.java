package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.ProductPage;

public class ProductPageTest extends TestBase {

	HomePage homePage;
	ProductPage productPage;

	public ProductPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		homePage = new HomePage();
		productPage = new ProductPage();
	}

	@Test(priority = 1)
	public void navigateToProductPage() {
		homePage.search("Bluetooth Speakers");
	}
	
	@Test(priority = 2)
	public void selectBrand()
	{
		productPage.brand();
	}
	
	@Test(priority = 3)
	public void selectRating()
	{
		try {
			productPage.rating();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void printPrice()
	{
		productPage.printProductsSortedByPrice();
	}
	
	
	@Test(priority = 5)
	public void clickFirstProduct() {
		productPage.clickProduct();
	}

	@Test(priority = 6)
	public void switchNewTab() {
		productPage.switchTab();
	}

	@Test(priority = 7)
	public void printOfferLists() throws InterruptedException {
		productPage.printOffers();
	}

	@Test(priority = 8,description = "SCENARIO 1: Product is Available")
	public void clickCart() throws InterruptedException {
		productPage.clickCartBtn();
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
