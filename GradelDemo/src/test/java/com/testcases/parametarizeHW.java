package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parametarizeHW
{
	
	WebDriver driver;
	@Test(dataProvider="orangelogin")
	public void Loginintoorange(String username,String password) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl());
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("user is able to login ");
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("hannah.flores");

		//Select dropdown=new Select(driver.findElement(By.xpath(//*[@id=\"searchSystemUser_userType\"]));
		//dropdown.selectByVisibleText("Admin");
		
		//driver.selectdropdown("//*[@id=\"searchSystemUser_userType\"]", "Admin");
		//driver.enterbyid("searchSystemUser_employeeName_empName", "Hannah Flores");
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException
		{
		Thread.sleep(3000);
		driver.quit();
		}
	@DataProvider(name="orangelogin")
	public Object[][] passData()
		{
		Object[][] data=new Object[3][2];
		//username
		data[0][0]="Admin";
		//password
		data[0][1]="admin123";
		
		data[1][0]="cherry";
		data[1][1]="sai";
		
		data[2][0]="berry";
		data[2][1]="sai";
		
		return data;
		}


}
