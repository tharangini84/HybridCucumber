package com.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Library2
{
	protected  WebDriver driver;
	public static Properties prop;
		//to Launch Browser
		public void launchapplication() throws IOException 
		{
			FileInputStream fileIS=new FileInputStream("C:\\Users\\Sudhakar\\eclipse-workspace\\Linkedin1\\src\\test\\resources\\configurationfiles1\\configfile1");
			prop=new Properties();
			prop.load(fileIS);//LOADS CONFIG FILES
			String browser=prop.getProperty("browser");
			
			try 
			{
				if (browser.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\geckodriver-v0.26.0-win64\\geckodriver.exe");
					driver=new FirefoxDriver();
					
				}else if(browser.equalsIgnoreCase("chrome")) 
					
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
					driver=new ChromeDriver();

				
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			  
				driver.get(prop.getProperty("url"));  
		  }catch(WebDriverException e)
			
			{
				System.out.println("browser could not be launched");
			}
		}
		
		
		public void quit()
		{
			driver.close();
		}
		
}
