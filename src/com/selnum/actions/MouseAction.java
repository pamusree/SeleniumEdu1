package com.selnum.actions;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction 
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	public static void main(String[] args)
	{
	  	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	wait = new WebDriverWait(driver, 20);
	  	driver.navigate().to("http://www.amazon.com/");
	  	
        WebElement acctLists = driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]"));
        acctLists.click();
        Actions action = new Actions(driver);
        action.moveToElement(acctLists).perform();
        
        String text = acctLists.getText();
        System.out.println(text);
        
      
	}
}
