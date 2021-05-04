package com.LTM.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String testURL)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver=new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("We don't support this browser");
		}
		
		driver.manage().window().maximize();
		driver.get(testURL);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
		
}
