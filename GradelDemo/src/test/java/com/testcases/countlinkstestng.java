package com.testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class countlinkstestng 
{
@Test
	public void links() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement test=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		test.sendKeys("testing");
		Thread.sleep(3000);
		WebElement search=driver.findElement(By.name("btnK"));
		search.click();
		Thread.sleep(6000);
		
		java.util.List<WebElement> list=driver.findElements(By.tagName("a"));
		int a=list.size();
		System.out.println("No. of links="+a);
	}
}
