package com.LTM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

	static WebDriver driver;
	
	// Method 1 to specify WebElement
	@FindBy(id="username") 
	@CacheLookup
	WebElement username;
	
	// Method 2 to specify WebElement
	@FindBy(how=How.ID,using="credential") 
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='login_button']") 
	@CacheLookup
	WebElement login_btn;
	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'SSL-VPN Portal')]") 
	@CacheLookup
	WebElement login_header;
	
	//This constructor will initiate the driver	
	public LoginPage(WebDriver ldriver)
		{
			driver=ldriver;
		}
		
		public void loginToApp(String uname,String pwd) throws InterruptedException
		{
			username.sendKeys(uname);
			password.sendKeys(pwd);
			login_btn.click();
			
			//Thread.sleep(10000);
			//WebElement login_header=driver.findElement(By.xpath("//h1[contains(text(),'SSL-VPN Portal')]"));
			//String Expected_header="SSL-VPN Portal";
			//Assert.assertEquals(login_header, Expected_header);
		}
}
