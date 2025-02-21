package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexpage {

	
	WebDriver driver;
	public indexpage(WebDriver driver) {
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	
	
	public void ClickonSingIn() {
		signIn.click();
	}
	
}
