package com.selnum.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocators 
{
public static WebDriver driver = null;
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		String baseurl = "https://google.com";
		
		driver.navigate().to(baseurl);
	  
  }
}
