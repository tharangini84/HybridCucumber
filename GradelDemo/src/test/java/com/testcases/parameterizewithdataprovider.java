package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parameterizewithdataprovider
{
WebDriver driver;
@Test(dataProvider="facebooklogin")
public void Loginintofacebook(String username,String password) 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("pass")).sendKeys(password);
	//driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
	System.out.println(driver.getCurrentUrl());
	System.out.println("user is able to login sucessfully");
	
}
@AfterMethod
public void tearDown() throws InterruptedException
	{
	Thread.sleep(3000);
	driver.quit();
	}
@DataProvider(name="facebooklogin")
public Object[][] passData()
	{
	Object[][] data=new Object[3][2];
	//username
	data[0][0]="sai";
	//password
	data[0][1]="baba";
	
	data[1][0]="cherry";
	data[1][1]="sai";
	
	data[2][0]="berry";
	data[2][1]="sai";
	
	return data;
	}

}
