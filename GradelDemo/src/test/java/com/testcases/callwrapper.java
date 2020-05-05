package com.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

public class callwrapper 
{

	@Test
	public void facebooklogin() throws IOException, InterruptedException
	{
		wrappermethods wm=new wrappermethods();
		//wm.insertapp("https://www.facebook.com/");
		//wm.enterbyid("email","tharangini");
		//wm.enterbyid("pass","abd");
		//wm.clickbyxpath("//*[@id=\"u_0_b\"]");
		//wm.Login("");
		wm.takescreenshot("D:\\screenshot\\img.png");
		wm.closeapp();
	}
}
