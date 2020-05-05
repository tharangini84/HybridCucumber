package com.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class wrappermethods
{
	WebDriver driver;
	public void insertapp(String url)
		{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		}
	public void enterbyid(String locator,String value) 
		{
		driver.findElement(By.id(locator)).sendKeys(value);
		}
	public void clickbyxpath(String locator1) 
		{
		driver.findElement(By.xpath(locator1)).click();
		}
	@Test
	public void Login() throws InterruptedException, IOException
	{
		
		FileInputStream fil=new FileInputStream(new File("C:\\Users\\Sudhakar\\Downloads\\FacebookLogin.xlxs"));
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int count=sheet.getLastRowNum();
		System.out.println(count);
		for(int i=0;i<=count;i++) 
		{
		

        XSSFRow row=sheet.getRow(i);
		XSSFCell cell=row.getCell(0);
		String un=cell.getStringCellValue();
		XSSFCell cell1=row.getCell(1);
		String pwd=cell1.getStringCellValue();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
		
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("https://www.linkedin.com/");
			driver.findElement(By.xpath("/html/body/nav/a[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.id("password")).sendKeys(pwd);
			
			
			}
			
	}

	public void takescreenshot(String path) throws IOException
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
		}
	public void mouseaction(String locator3,String value2)
	   {
		WebElement value21=driver.findElement(By.xpath(locator3));
		Actions action =new Actions(driver);
		action.moveToElement(value21).click().build().perform();
	   }

	public void selectdropdown(String locator4,String value) 
	{
		Select dropdown=new Select(driver.findElement(By.xpath(locator4)));
		dropdown.selectByVisibleText(value);
		
	}

	public void closeapp() throws InterruptedException
		{
		Thread.sleep(8000);
	    driver.close();	
		}
}
