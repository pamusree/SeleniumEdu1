package com.selnum.educasestudies;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class edurekacase1 {

	public static WebDriver chrdriver = null;
	public static WebDriver foxdriver = null;
	public static WebDriverWait wait = null;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		
		chrdriver = new ChromeDriver();
		foxdriver = new FirefoxDriver();
		
		/* initialise chrome driver*/
		chrdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(chrdriver, 50);
		String wind1 = chrdriver.getWindowHandle();
		System.out.println(wind1);
		chrdriver.manage().window().maximize();
		
		/* initialise firefox driver*/
		foxdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(foxdriver, 50);
		String wind2 = foxdriver.getWindowHandle();
		System.out.println(wind1);
		foxdriver.manage().window().maximize();
		
		
		String baseurl = "https://edureka.co";
		
		chrdriver.navigate().to(baseurl);
		foxdriver.navigate().to(baseurl);	
		
		WebElement srchbyname = chrdriver.findElement(By.name("user_v1[query]"));
		WebElement srchbyid = chrdriver.findElement(By.id("search-inp3"));
		WebElement srchbyclass = chrdriver.findElement(By.className("search_inp"));
		WebElement srchbyxpath = chrdriver.findElement(By.xpath("//input[@name='Search Input']"));
		
		
		
		
	}

}
