package com.selnum.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpath {

	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		String baseurl = "https://google.com";
		
		driver.navigate().to(baseurl);
		
		driver.manage().window().maximize();
		
		WebElement welmnt = driver.findElement(By.xpath("//img[@title='Will Rogers\' 140th Birthday']"));
		
		welmnt.click();
		
	}

}
