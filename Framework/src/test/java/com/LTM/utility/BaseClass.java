package com.LTM.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config_property;
	public ExtentReports report;
	public ExtentTest logger;
	public ITestResult result;
	
	@Parameters({"browser", "URL"})
	@BeforeClass
	public void setupBrowser(String browserName, String testURL)
	{
		// This will launch the specific browser and URL
		Reporter.log("Trying to initiate browser and loding URL", true);
		//driver=BrowserFactory.startBrowser(config_property.browserName(), config_property.testURL());
		
		driver=BrowserFactory.startBrowser(browserName, testURL);
		
		Reporter.log("Browser and URL is up and running", true);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@BeforeSuite
	public void dataProvider() throws IOException
	{
		Reporter.log("Configuration is ready from Excel file", true);
		
		excel=new ExcelDataProvider();
		config_property=new ConfigDataProvider();
		
		// To generate HTML reports
		Reporter.log("Configuration is ready to generate HTML reports", true);
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File ("./Reports/VPN-"+ Helper.getCurrentDateTime() +".html"));
		report=new ExtentReports();
		report.attachReporter(html);
		
		Reporter.log("Configuration setup is OK", true);
	}

	@AfterMethod
	public void screenshotOnFail(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			Reporter.log("Trying to capture screenshot on fail", true);
			logger.fail("Test Case failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
			Reporter.log("Reports generated on pass", true);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Helper.captureScreenshot(driver);
			Reporter.log("Trying to capture screenshot on pass", true);
			logger.pass("Test Case passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
			Reporter.log("Reports generated on pass", true);
		}
		
		report.flush();
	}
}
	
	
	
