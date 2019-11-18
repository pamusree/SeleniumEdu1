package com.selnum.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByTag 
{
  public static WebDriver driver = null;
  
  public static void main(String a[])
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  
	  String baseurl  = "https://google.com";
	  
	  driver.navigate().to(baseurl);
	  
	  String winId = driver.getWindowHandle();
	  
	  driver.manage().window().maximize();
	  
	  //collection of all link elements by tag <a>
	  List<WebElement> glinks = driver.findElements(By.tagName("a"));
	  
	  System.out.println("Num of glinks:" + glinks.size());
	  for(WebElement link : glinks)
	  {
		  String gLinkName = link.getText();
		  System.out.println(gLinkName);
	  }
  }
}
