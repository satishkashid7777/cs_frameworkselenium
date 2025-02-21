package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {

	WebDriver driver;
	public RegisteredUserAccount(WebDriver driver) {
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement username;

	@FindBy(xpath="//a[text()='Sign out']")
	WebElement logout;
	
	public void clickonlogout() {
		logout.click();
	}
	public String verifyuser() {
		String ss=username.getText();
		return ss;



	}
}
