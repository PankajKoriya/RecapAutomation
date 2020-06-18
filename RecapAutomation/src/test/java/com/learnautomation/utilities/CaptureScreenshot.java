package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	
	public static String captureSs(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "./Screenshots/learnAutomation_" + CaptureScreenshot.getDate() + ".png";
		
		FileHandler.copy(src, new File(dest));
		
		return dest;
		
		
		
	}
	
	public static String getDate()
	{
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		return sdf.format(date);
		
		
	}

}
