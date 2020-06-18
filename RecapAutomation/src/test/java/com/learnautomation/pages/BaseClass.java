package com.learnautomation.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.CaptureScreenshot;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.StartBrowserAndApplication;

public class BaseClass {
	
	public WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public ConfigDataProvider cdp;
	public ExcelDataProvider edp;
	
	@BeforeSuite
	public void setUp()
	{
		Reporter.log("Setup for test suite is started", true);
		
		cdp = new ConfigDataProvider();
		edp = new ExcelDataProvider();
		
		reporter = new ExtentHtmlReporter("./ExtentReports/learnAutomation_" + CaptureScreenshot.getDate() +".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		Reporter.log("Setup for test suite is completed", true);
		
	}
	
	@BeforeClass
	public void openBrowser()
	{
				
		Reporter.log("Browser started", true);
		
		driver = StartBrowserAndApplication.openBrowser(ConfigDataProvider.getDataFromConfigFile("url"), driver);
		
		Reporter.log("Browser opened", true);
	}
	
	@AfterMethod
	public void testResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test is passed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.captureSs(driver)).build());
		}
		else
		{
			logger.fail("Test is failed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.captureSs(driver)).build());
		}
		
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		
		Reporter.log("Browser is closed", true);
		
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		
		Reporter.log("Report is generated", true);
	}

}
