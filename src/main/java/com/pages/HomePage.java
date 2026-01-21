package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase{
	
	//1.Page Objects
	@FindBy(xpath = "//span[@role='button']")
	WebElement loginPopUp;
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBox;
	
	
	//2.Constructor
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3.Actions or Methods
	public ProductPage search(String searchProduct) {
		try 
		{
			loginPopUp.click();
		} 
		catch (Exception e) 
		{
			System.out.println("Login PopUp not appeared....!");
		}
		searchBox.sendKeys(searchProduct+Keys.ENTER);
		return new ProductPage();
	}
	
	public ProductPage1 search1(String searchProduct) {
		try 
		{
			loginPopUp.click();
		} 
		catch (Exception e) 
		{
			System.out.println("Login PopUp not appeared....!");
		}
		searchBox.sendKeys(searchProduct+Keys.ENTER);
		return new ProductPage1();
	}

}
