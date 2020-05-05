package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Library2;
import com.baseclass.Utility1;
import com.pages.signin;

public class signintestcase extends Library2
{
	@BeforeClass
	public void strtup() throws IOException
		{
		System.out.println("checking");
		launchapplication();
		}
	
	@Test
	public void signiin()
	{
		System.out.println("checking sign in");
		signin sn=new signin(driver);
		sn.sgnin();
	}

	@AfterClass
	public void teardown() 
	{
		Utility1 util=new Utility1(driver);
		util.gettitle();
		util.take_screenshot("src/test/resources/screenshot2/linkedinsignin.png");
		util.quit();
	}
}
