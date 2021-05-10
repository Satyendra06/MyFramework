package com.LTM.testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.LTM.pages.LoginPage;
import com.LTM.utility.BaseClass;
import com.aventstack.extentreports.Status;

public class MyTestCase1 extends BaseClass {

	@Test
	public void Login() throws InterruptedException, IOException
	{
		logger=report.createTest("LoginVPN");
		
		logger.log(Status.INFO, "Application Started");
		
		// Created Page Object using Page Factory
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		logger.log(Status.INFO, "Enter Credentails");
		
		//login.loginToApp(excel.readExcelData("Credentials", 0, 0), excel.readExcelData("Credentials", 0, 1));
		//login.loginToApp(excel.readExcelData("Credentials", 1, 0), excel.readExcelData("Credentials", 1, 1));
		//logger.fail("Log in failed");
		
		//driver.navigate().refresh();
		
		//logger1=report.createTest("LoginWithValidUser");
		//logger1.log(Status.INFO, "Again Enter Credentails");
		//System.out.println("Line 5");
		login.loginToApp(excel.readExcelData("Credentials", 2, 0), excel.readExcelData("Credentials", 2, 1));
		//login.loginToApp(excel.readExcelData("Credentials", 3, 0), excel.readExcelData("Credentials", 3, 1));
		logger.log(Status.PASS, "Logged in successfully");
	}	
}
