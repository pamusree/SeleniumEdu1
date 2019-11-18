package com.selnum.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadBrowser 
{
	public static WebDriver wdriver = null;
	
	public static void main(String a[])
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		wdriver = new ChromeDriver();
		
		String brwid = wdriver.getWindowHandle();
		System.out.println(brwid);
		
		String baseurl = "http://www.google.com";
		
		//wdriver.get(baseurl);
		
		
		String title = wdriver.getTitle();
		
		System.out.println(title);
	}
}