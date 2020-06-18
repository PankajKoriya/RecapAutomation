package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.CheckboxPage;

public class ClickonCheckbox extends BaseClass{
	
	@Test
	public void checkboxTest()
	{
		Reporter.log("Testcase execution started", true);
		
		logger=extent.createTest("CheckBox Test");
		
		logger.info("Test case execution is started");
		
		CheckboxPage cbp = PageFactory.initElements(driver, CheckboxPage.class);
		String msg = cbp.clickOnCheckBox();
		Assert.assertTrue(msg.equalsIgnoreCase("Success - Check box is checked"));
		
		logger.info("Test case execution is completed");
	}

}
