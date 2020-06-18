package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.RadioAndCheckBoxPage;

public class ClickRadioButtonAndCheckBox extends BaseClass{
	
	
	@Test
	public void verifyMaleRadioBtn()
	{
		
		logger=extent.createTest("Click On Radio button");
		
		logger.info("Test is started");
		
		RadioAndCheckBoxPage rc = new RadioAndCheckBoxPage(driver);
		
		String msg = rc.selectMaleRadioBtn();
		
		Assert.assertTrue(msg.equalsIgnoreCase("Radio button 'Male' is checked"));
		
		logger.info("Test is completed");
	}

}
