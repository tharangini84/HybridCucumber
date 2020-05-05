package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class forbeshw 

{
WebDriver driver;

	public void openbrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);		
	}
	
	public void click(String click1) 
	{		
		driver.findElement(By.xpath(click1)).click();
	}
	
	public void checkTitle(String expected_title) 
	{
		
		//Actual Title
		String actualtitle=driver.getTitle();
		System.out.println("Actual title is -->"+actualtitle);
		
		//Expected title
		//String expected_title="Forbes news";
		
		//to check actual title matches partial of expected title
		Assert.assertTrue(actualtitle.contains(expected_title));
		
		//to check actual title matches  of expected title
		//Assert.assertEquals(actualtitle, expected_title);
		
		//driver.quit();

	}
	
	public void ad(String locator,String ad) throws IOException
	{
		driver.switchTo().frame(driver.findElement(By.className(locator)));
		System.out.println(driver.findElement(By.id(ad)).isDisplayed());
		// Along with driver pass element also in takeScreenshot() method.
		Screenshot screenshot;
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("c:\\ElementScreenshot.jpg"));
		driver.switchTo().defaultContent();
		
	}
	
	
	public void checkelement(String locator1,String element_text1)
	{
		WebElement element = driver.findElement(By.xpath(locator1));
		String strng = element.getText();
		System.out.println(strng);
		Assert.assertEquals(element_text1, strng);
		System.out.println("Element matched");
	}
	
	
	public void MenuItem(String locator2) throws IOException
	{
		
		driver.findElement(By.xpath(locator2)).click();
		String menu_item=locator2;
		System.out.println("menu item"+menu_item);
		//Actions action =new Actions(driver);
		//action.moveToElement(menu1).click().build().perform();
	
	}
	
	public void takescreenshot(String path) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
	}
	 
	public void color(String locator4) 
	 {
			
		String textcolor=driver.findElement(By.xpath(locator4)).getCssValue("color");
		System.out.println("Color of the Element"+textcolor);
		String hexcolor=Color.fromString(textcolor).asHex();
		System.out.println(""+hexcolor);
	}
	
	public void scroll(String locator5) 
	{

		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement scroll=driver.findElement(By.xpath(locator5));
		  js.executeScript("arguments[0].scrollIntoView();", scroll);
	}
	
	public void closebrowser()
	
	{
		
		driver.quit();
	}
}
