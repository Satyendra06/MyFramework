package com.LTM.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Screenshots, DateFormat, Frames, Alerts, Windows, Javascript executor, Sync issues
	
	public static String captureScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		
		String ScreenshotPath = System.getProperty("user.dir") + "./Screenshots/"+ getCurrentDateTime() +".png";
		
		FileHandler.copy(src, new File(ScreenshotPath));
		System.out.println("Screenshot Captured Successfully");
		
		return ScreenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat currentdate=new SimpleDateFormat("DD_mm_yyyy_HH_mm_ss");
		Date date=new Date();
		
		return currentdate.format(date);
	}
}
