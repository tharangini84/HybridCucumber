package com.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class countlinks {

	public static void main(String[] args) throws InterruptedException
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
				
				
				//to get count of all links
			 List<WebElement> links=driver.findElements(By.tagName("a"));
		     System.out.println("Total links="+links.size());
			 
			 //to get name of link
			 
		     for (int i=0; i<links.size();i++ )
		     {
		         System.out.println("link name:" + links.get(i).getAttribute("value"));
		     }
		     driver.quit();
	}
	

}
