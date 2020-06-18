package com.learnautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartBrowserAndApplication {
	
	public static WebDriver openBrowser(String url, WebDriver driver)
	{
		
		System.setProperty("webdriver.chrome.driver", ConfigDataProvider.getDataFromConfigFile("chromeDriverLocation"));
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
			
	}

}
