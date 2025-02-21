package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreation {
	WebDriver ldriver;
	public AccountCreation (WebDriver rdriver){
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// we find webElement 


	@FindBy(xpath="//input[@name='id_gender']")
	WebElement Mr;

	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement FN;

	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement LN;

	@FindBy(xpath="//input[@id='email']")
	WebElement EmailID;

	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwds; 


	@FindBy(xpath="//select[@id='days']")
	WebElement day;

	@FindBy(name="months")
	WebElement month;

	@FindBy(name="years")
	WebElement year;

	@FindBy(xpath="//span[text()='Register']")
	WebElement registerbutton;

	// we perform some action on the page

	public void clickonMR() {
		Mr.click();
	}

	public void clickonFN(String name) {
		FN.clear();
		FN.sendKeys(name);

	}

	public void clickonLN(String names) {
		LN.clear();
		LN.sendKeys(names);

	}
	public void enterEmailID(String ns) {
		EmailID.clear();
		EmailID.sendKeys(ns);

	}



	public void enterpassword(String namtt) {
		passwds.clear();
		passwds.sendKeys(namtt);

	}
	public void selectDay(int name) {
		Select ss=new Select(day);
		ss.selectByIndex(name);

	}

	public void selectmonth(String name) {
		Select ss=new Select(month);
		ss.selectByValue(name);

	}
	public void selectyear(String name) {
		Select ss=new Select(year);
		ss.selectByValue(name);

	}
	public void clickonregisterbt() {
		registerbutton.click();
	}


}










