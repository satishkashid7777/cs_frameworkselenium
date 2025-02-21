package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountpage {
WebDriver driver;

public myAccountpage( WebDriver rdriver) {
	driver=rdriver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(id="email_create")
WebElement Emailbox;

@FindBy(id="SubmitCreate")
WebElement createanaccountbtn;
@FindBy(id="email")
WebElement emails;
@FindBy(id="passwd")
WebElement passwds;

@FindBy(id="SubmitLogin")
WebElement submitbtn;

public void enteremailid(String Email) {
	Emailbox.sendKeys(Email);
}

public void clickonbtn() {
	createanaccountbtn.click();
}
public void enteremailids(String email) {
	emails.sendKeys(email);
}public void enterpasswd(String passwdss) {
	passwds.sendKeys(passwdss);
}
public void clickonsigninbtn() {
	submitbtn.click();
}


}

