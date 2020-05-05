package com.testcases;




import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Library2;
import com.baseclass.Utility1;
import com.excelutility.ExcelUtility;
import com.pages.login;
import com.pages.signin;

public class logintestcase extends Library2
{
	@BeforeClass
	public void strtup() throws IOException
		{
		launchapplication();
		
		}
	@Test
	public void linklogin() throws IOException
	{
		signin sn=new signin(driver);
		sn.sgnin();
		login ln=new login(driver);
		ExcelUtility util=new ExcelUtility();
		ln.lgin(util.excel_username(1), util.excel_password(1));
		
		
	}
	
	@AfterClass
	public void close()throws IOException
		{
		Utility1 util=new Utility1(driver);
		util.gettitle();
		util.take_screenshot("src/test/resources/screenshot2/orangehrmloginpg.png");
		quit();
		}
	
}
