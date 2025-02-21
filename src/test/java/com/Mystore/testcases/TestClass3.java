package com.Mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.pageobject.AccountCreation;
import com.Mystore.pageobject.RegisteredUserAccount;
import com.Mystore.pageobject.indexpage;
import com.Mystore.pageobject.myAccountpage;
//import com.Mystore.pageobject.Accountpage;
public class TestClass3 extends BaseClass{

	@Test(enabled=false)
	public void verifyLogin() {
		
		 indexpage ss=new indexpage(driver);
    	 ss.ClickonSingIn();
    	 logger.info("clickon signlink");
    	 myAccountpage st=new myAccountpage(driver); 
    	 
    	 st.enteremailid("sksatish2309@gmail.com");
    	 logger.info("Email address entered ");
    	 st.clickonbtn();
    	 logger.info("click on sign in button");
    	 
    	 AccountCreation at=new AccountCreation(driver) ;
    		 at.clickonMR();
    		 at.clickonFN("satish");
    		 at.clickonLN("kashid");
    		 at.enterEmailID("sksatish2309@gmail.com");
    		 at.enterpassword("Satish@234");
    		 at.selectDay(18);
    		 at.selectmonth("may");
    		 at.selectyear("2022");
    		 at.clickonregisterbt();
    		 
    		 RegisteredUserAccount dd=new RegisteredUserAccount(driver) ;
    			 String sss=dd.verifyuser();
    			 Assert.assertEquals("satish kashid",sss);
	}	 
    		@Test
    		public void verifyalreadyregistereduvser() throws InterruptedException, IOException {
    			logger.info("verifyalreadyregistereduvser test execution started");
    			 indexpage js=new indexpage(driver);
    	    	 js.ClickonSingIn();
    	    	 //logger .info("click on sign in link");
    	    	 logger.info("clickon signlink");
    	    	 myAccountpage st=new myAccountpage(driver); 
    		Thread.sleep(7000);
    				st.enteremailids("sksatish2309@gmail.com");
    				logger.info("email entered");
    				st.enterpasswd("Satish@234");
    				logger.info("password entered");
    				Thread.sleep(7000);
    				st.clickonsigninbtn();
    				logger.info("click on sign in btn");
    				 RegisteredUserAccount dd=new RegisteredUserAccount(driver) ;
        			 String sss=dd.verifyuser();
        			 logger. info ("verify user");
        			 if(sss.equals("satish- kashid")) {
        				// tekesScreenshot(driver,"verifyalreadyregistereduvser");
        			 logger .info("user verified");
        			 Assert.assertTrue(true);
        			 }
        			 else {
        				 tekesScreenshot(driver,"verifyalreadyregistereduvser");
        				 Assert.assertFalse(false);
        				 logger. info ("user verification fail");
        			 }
    		}
    			 
    		 }
    	 
		
	
	

