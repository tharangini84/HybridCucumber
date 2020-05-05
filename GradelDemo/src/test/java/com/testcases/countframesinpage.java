package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class countframesinpage
{

	public static void main(String[] args) throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		    driver.get("https://www.forbes.com/#78a56b652254");  
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/section[1]/button/img")).click();
		    int size = driver.findElements(By.tagName("iframe")).size();

		    for(int i=0; i<=size; i++)
		    {
			driver.switchTo().frame(i);
			int total=driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section[2]/div/a")).size();
			System.out.println(total);
		    driver.switchTo().defaultContent();
		    }
		driver.quit();    
	}

}
