package com.learnautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckboxPage {
	
	@FindBy(how=How.LINK_TEXT, using="Input Forms")
	WebElement inputForms_link;
	
	@FindBy(linkText="Checkbox Demo")
	WebElement chkboxDemo_link;
	
	@FindBy(how=How.ID, using="isAgeSelected")
	WebElement chkBox;
	
	@FindBy(id="txtAge")
	WebElement msg;
	
	public String clickOnCheckBox()
	{
		inputForms_link.click();
		chkboxDemo_link.click();
		chkBox.click();
		return msg.getText();
		
	}

}
