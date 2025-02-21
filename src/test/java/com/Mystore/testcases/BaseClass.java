package com.Mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.Mystore.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static  Logger logger;

Readconfig config= new Readconfig();
String url=config.getBaseUrl();
String browser=config.getbrowser();
@BeforeClass
public void setUp() {
	 String browser="chrome";
	 switch (browser) {
	 case "chrome":
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 break;
		 
	 case "firefox":
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 break;
		 
	 case "edge":
		 WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		 break;
		 default:
			 driver=null;
			 break;
	 }

//implicitly wait
//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging


		logger =LogManager.getLogger("MyStoreV1");
		
		driver.get(url);
			
		}

@AfterClass
public void tearDown() {
	driver.close();
	driver.quit();
}
public void tekesScreenshot(WebDriver driver, String urls) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
File src=ts.getScreenshotAs(OutputType.FILE);

File destination=new File(System.getProperty("user dir")+"\\Screenshots\\"+urls+".png");
FileUtils.copyFile(src, destination);
}
}



