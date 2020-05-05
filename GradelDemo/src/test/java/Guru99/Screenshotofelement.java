package Guru99;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshotofelement
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\SELENIUM AGAMA SOLUTIONS\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.forbes.com/");	
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/section[1]/button/img")).click();
		
		WebElement element = driver.findElement(By.xpath ("//*[@id=\"row-0\"]/div[1]/div[1]/h3/a"));

		// Along with driver pass element also in takeScreenshot() method.

		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

		ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\screenshot\\ElementScreenshot.jpg"));
		
		driver.quit();

	}

}
