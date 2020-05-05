package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class login
{
	WebDriver driver;

	@FindBy(id="username")
	WebElement email;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")
	WebElement login;

	public login(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void lgin(String emid,String pass)
	{
		email.sendKeys(emid);
		password.sendKeys(pass);
		 login.click();
		
	}

}
