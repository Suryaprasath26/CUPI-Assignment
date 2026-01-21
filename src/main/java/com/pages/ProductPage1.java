package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class ProductPage1 extends TestBase {

	// 1.Page Objects
	@FindBy(xpath = "(//div[@class='RG5Slk'])[1]")
	WebElement clickProduct;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//button[text()='NOTIFY ME']")
	WebElement notifymeBtn;

	@FindBy(className = "B1negq")
	WebElement outOfStockMsg;

	@FindBy(xpath = "//li[@class='Im3cwA col']")
	List<WebElement> offerList;

	@FindBy(xpath = "//div[@class='B1negq']")
	WebElement outOfStock;

	// 2.Constructor
	public ProductPage1() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions or Methods
	public void clickProduct() {
		clickProduct.click();
	}

	public void switchTab() {
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> tabs = new ArrayList<>(windowHandles);

		driver.switchTo().window(tabs.get(1));

		System.out.println("-------------------------------------------------------------------------");

	}

	public void handleUnavailableProduct() {
		boolean unavailable = false;

		try {

			if (cartBtn == null || !cartBtn.isDisplayed() || !cartBtn.isEnabled()) {
				unavailable = true;
			}

			if (outOfStock != null && outOfStock.isDisplayed()) {
				unavailable = true;
			}

		} catch (Exception e) {
			unavailable = true;
		}

		if (unavailable) {
			System.out.println("Product unavailable — could not be added to cart.");
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {

				FileUtils.copyFile(screenshot, new File("screenshots/result.png"));
				System.out.println("Screenshot captured: screenshots/result.png");
				System.out.println("-------------------------------------------------------------------------");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
