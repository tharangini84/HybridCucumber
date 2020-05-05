package com.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

public class Forbecaller 
{
	
	@Test
	public void forbe() throws IOException, InterruptedException 
	
	{
		
		forbeshw  fw=new forbeshw();
		
		//a.open the url with browse ...confirm it with title and 2 elements...take screen shot
		fw.openbrowser("https://www.forbes.com/#78a56b652254");
		//fw.click("/html/body/div[1]/div[1]/div/section[1]/button/img");
		fw.checkTitle("Forbes");
		fw.checkelement("/html/body/div[1]/header/nav/div[2]/ul/li[1]", "Billionaires");
		fw.checkelement("/html/body/div[1]/header/nav/div[2]/ul/li[6]", "Small Business");
		fw.takescreenshot("D:\\screenshot\\forbes.img"); 
		
		//3.click billionaires menu ...confirm with title and 2 elements and take screenshot
		fw.MenuItem("/html/body/div[1]/header/nav/div[2]/ul/li[1]");
		fw.checkTitle("Billionaires");
		//fw.checkelement(locator1, element_text1);
		Thread.sleep(3000);
		
		
		//5.click Advisor menu ...confirm with title and 2 elements and take screenshot

		fw.MenuItem("/html/body/div[1]/header/nav/div[2]/ul/li[9]");
		fw.checkTitle("Advisor");
		
		//7.Check the Advisor color is Blue
		fw.scroll("/html/body/div[1]/div[4]/h2/span");
		fw.color("/html/body/div[1]/div[4]/h2/span");
		
		
		//10.
		
		fw.click("/html/body/div[1]/header/nav/div[3]/button");
		fw.checkTitle("Search");
	
		//fw.closebrowser();
		
		
	}
	

}
