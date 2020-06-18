package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioAndCheckBoxPage {
	
	WebDriver driver;
	
	public By maleRadio_btn = By.xpath("//input[@name='optradio' and @value='Male']");
	public By getCheckedValue_btn = By.id("buttoncheck");
	public By msg = By.xpath("//p[contains(text(),'checked')]");
	
	public RadioAndCheckBoxPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public String selectMaleRadioBtn()
	{
		driver.findElement(maleRadio_btn).click();
		driver.findElement(getCheckedValue_btn).click();
		String successMsg = driver.findElement(msg).getText();
		return successMsg;
	}

}
