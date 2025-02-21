package com.Mystore.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
public class ExtentListenerClass implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
	String timestamp=new SimpleDateFormat("yyyy.mm.dd hh:mm:ss").format (new Date());
	String reportName="myStoreTestReport-"+timestamp+",html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user. dir")+"//Reports//"+reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add System information / envirnment Info to reports
		reports.setSystemInfo("machine","testpc1");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("os", "windows");
		reports.setSystemInfo("user name", " prachi");


		// configuration to change look and feel of reports
		htmlReporter.config().setDocumentTitle("Extent listener Report Demo");
		htmlReporter.config().setReportName("My first Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	// onStart method is called when any test Start

	public void onStart(ITestContext Result) {
		configureReport();  

		System.out.println("on start method is invoked");
	}
	public void onFinish(ITestContext Result) {
		System.out.println("on Finished method invoked");
		reports.flush();
	}

	// when test case get failed , this method is called
	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of method failed"+ Result.getName());
		test =reports.createTest(Result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case"+Result.getName(),ExtentColor.RED)); 

		String screenshotpath=System.getProperty("user dir")+"\\screenshot\\"+Result.getName()+".png";

		File screenshotfile=new File(screenshotpath);
		if(screenshotfile.exists()) {
			test.fail("captured screenshot is below"+test.addScreenCaptureFromPath(screenshotpath));
		}


	}

	//when test case get skipped , this method is called
	public void ontestSkipped(ITestResult Result) {
		System.out.println("Name of Test method skipped"+Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("name of the skipped test case is "+Result.getName(),ExtentColor.YELLOW));


	}
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of the method started"+Result.getName());
	}

	public void ontestSuccess(ITestResult Result) {
		System.out.println("Name of Test method success"+Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status. PASS,MarkupHelper.createLabel("name of the passed  test case is "+Result.getName(),ExtentColor.GREEN));


	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {





	}

}
