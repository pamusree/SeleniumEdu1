package com.selnum.popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	public static void main(String[] args) throws InterruptedException 
	{
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 20);
	  
	  String baseurl = "http://demo.automationtesting.in/Alerts.html";
	  
	  driver.navigate().to(baseurl);
	
	  WebElement alertbtn = driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button"));
	  wait.until(ExpectedConditions.visibilityOf(alertbtn));
	  alertbtn.click();
	  
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  

	}

}
