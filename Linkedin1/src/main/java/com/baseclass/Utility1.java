package com.baseclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility1 extends Library2
{
	WebDriver driver;
	public Utility1(WebDriver driver)
	{
	this.driver=driver;
	}
	public void take_screenshot(String path1)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(source, new File(path1));
		}catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	public void gettitle()
	{
		//String title=driver.getTitle();
		System.out.println("Title is:"+driver.getTitle());
		
	}

public void actions(String locator1) 
{
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(locator1))).click().build().perform();;
}
public void dropdown(String locator,String pick) 
{
	Select drop=new Select(driver.findElement(By.xpath(locator)));
	drop.selectByVisibleText(pick);
}
public void ExplicitWait(String locator) 
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(locator))));
	
}

}
