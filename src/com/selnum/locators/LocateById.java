package com.selnum.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateById {

	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		String brwid1 = driver.getWindowHandle();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String baseurl = "https://google.com";
		
		driver.navigate().to(baseurl);
		
		String tagname = "";
		
	    WebElement welmnt = driver.findElement(By.id("tsf"));
		tagname = welmnt.getTagName();
		
		System.out.println(tagname);

	}

}
