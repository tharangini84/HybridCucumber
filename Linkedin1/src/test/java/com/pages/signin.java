package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signin
{
	WebDriver driver;
	@FindBy(xpath="/html/body/nav/a[3]")
	WebElement signin;
	
	public signin(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sgnin() 
	{
		signin.click();
	}
}
