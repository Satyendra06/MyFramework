package com.LTM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider() throws IOException
	{
		File src=new File("./Configuration/config.properties");
		FileInputStream fis=new FileInputStream(src);
		
		pro=new Properties();
		pro.load(fis);
	}
	
	public String browserName()
	{
		return pro.getProperty("browserName");
	}
	
	public String testURL()
	{
		return pro.getProperty("testURL");
	}
	
	public String prodURL()
	{
		return pro.getProperty("prodURL");
	}
}
