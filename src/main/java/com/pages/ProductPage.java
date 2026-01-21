package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class ProductPage extends TestBase {
	WebDriverWait wait;

	// 1.Page Objects
	@FindBy(xpath = "//div[text()='Brand']")
	WebElement brand;

	@FindBy(xpath = "(//div[@class='ybaCDx'])[1]")
	WebElement boat;

	@FindBy(css = "div[title='4★ & above'] div[class='ybaCDx']")
	WebElement rating;

	@FindBy(xpath = "//a[@class='pIpigb']")
	List<WebElement> productNames;

	@FindBy(xpath = "//div[@class='hZ3P6w']")
	List<WebElement> productPrices;

	@FindBy(xpath = "(//a[@class='pIpigb'])[1]")
	WebElement clickProduct;

	@FindBy(className = "pJPLqn")
	WebElement clickViewMore;

	@FindBy(xpath = "//li[@class='Im3cwA col']")
	List<WebElement> offerList;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//div[@class='B1negq']")
	WebElement outOfStock;

	// 2.Constructor
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions or Methods
	public void brand() {
		brand.click();
		boat.click();
	}

	public void rating() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rating);
		Thread.sleep(3000);
		rating.click();
	}

	public Map<String, Integer> getProductsWithPrices() {
		Map<String, Integer> productPriceMap = new HashMap<>();

		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			String priceText = productPrices.get(i).getText().replaceAll("[^0-9]", "");
			int price = Integer.parseInt(priceText);
			productPriceMap.put(productName, price);
		}
		return productPriceMap;
	}

	public void printProductsSortedByPrice() {
		getProductsWithPrices().entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(entry -> System.out.println(entry.getKey() + " --> ₹" + entry.getValue()));
		System.out.println("-------------------------------------------------------------------------");
	}

	public void clickProduct() {
		clickProduct.click();
	}

	public void switchTab() {
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> tabs = new ArrayList<>(windowHandles);

		driver.switchTo().window(tabs.get(1));

		System.out.println("Title of new tab: " + driver.getTitle());
		System.out.println("-------------------------------------------------------------------------");

	}

	public void printOffers() {
		clickViewMore.click();
		for (int i = 0; i < offerList.size(); i++) {
			String offers = offerList.get(i).getText();
			System.out.println(offers);
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------------------------");
	}

	public void clickCartBtn() throws InterruptedException {
		cartBtn.click();
		Thread.sleep(3000);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			
			FileUtils.copyFile(screenshot, new File("screenshots/cart_result.png"));
			System.out.println("Screenshot captured: screenshots/cart_result.png");
			System.out.println("-------------------------------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
