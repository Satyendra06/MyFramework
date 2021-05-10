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
	public static ExtentHtmlReporter html;
	public static ExtentReports report;
	public static ExtentTest logger;
	public ITestResult result;
	
	@Parameters({"browser", "URL"})
	@BeforeClass
	public void setupBrowser(String browserName, String testURL)
	//public void setupBrowser()
	{
		// This will launch the specific browser and URL
		Reporter.log("Trying to initiate browser and loding URL", true);
		//driver=BrowserFactory.startBrowser("chrome", "https://203.123.47.114:10443/remote/login?lang=en");
		
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
		
		Reporter.log("Configuration setup is OK", true);
		
		// To generate HTML reports
		System.out.println("Line 1");
		Reporter.log("Configuration is ready to generate HTML reports", true);
	
		System.out.println("Line 2");
		String ReportPath=System.getProperty("user.dir") + "./Reports/VPN-"+ Helper.getCurrentDateTime() +".html";
		html=new ExtentHtmlReporter(new File(ReportPath));
		System.out.println("Line 3");
		
		report=new ExtentReports();
		System.out.println("Line 4");
		report.attachReporter(html);
		//FileHandler.copy(new File (report), new File (ReportPath));
				
		System.out.println("Line 5");
		Reporter.log("HTML Report generated successfully", true);
	}
	
	@AfterMethod
	public void attachScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			Reporter.log("Trying to capture screenshot on fail", true);
			logger.fail("Test Case failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
			Reporter.log("Screenshot captured on fail", true);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Helper.captureScreenshot(driver);
			Reporter.log("Trying to capture screenshot on pass", true);
			logger.pass("Test Case passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
			Reporter.log("Screenshot captureed on pass", true);
		}
		report.flush();
	}
}

	
	
	
