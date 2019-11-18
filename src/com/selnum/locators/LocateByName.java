package com.selnum.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByName {

	public static WebDriver driver = null;
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		String baseurl = "https://google.com";
		
		driver.navigate().to(baseurl);
		WebElement welmnt = driver.findElement(By.name("q"));
		
		welmnt.sendKeys("flowers");
		welmnt.submit();
 
		driver.navigate().back();
		WebElement welmnt2 = driver.findElement(By.id("hplogo"));
		
		welmnt2.click();
		
		String wname = driver.getTitle();
		
		System.out.println(wname);
		
		
	}

}
