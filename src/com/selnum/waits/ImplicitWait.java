package com.selnum.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWait 
{
   public static WebDriver driver = null;
   
   public static WebDriverWait wait = null;
   
   public static void main(String a[])
   {
	   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	   
	   driver = new ChromeDriver();
	   wait = new WebDriverWait(driver, 20);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.navigate().to("https://gmail.com");
	   
	   WebElement email = driver.findElement(By.id("identifierId"));
	   
	   email.sendKeys("sonyexp10@gmail.com");
	   
	   WebElement next = driver.findElement(By.id("identifierNext"));
	   
	   next.click();
	   
	   WebElement pswd = driver.findElement(By.name("password"));
	   
	   pswd.sendKeys("******");
	   
	   WebElement pnext = driver.findElement(By.id("passwordNext"));
    
	   pnext.click();
	   
	   wait.until(ExpectedConditions.titleContains("Inbox"));
	   String title = driver.getTitle();
	   
	   if(title.contains("Inbox"))
	   {
		   System.out.println("Successfully landed in Inbox");
	   }
	   else if(title.contains("Authentication"))
	   {
		   System.out.println("Landed in Authentication page");
		   
		   driver.findElement(By.xpath("//span[text()='Done']")).click();
	   }
	   else 
	   {
		   System.out.println("Login failed");
	   }
	   
	   driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div/div[2]/div/a")).click();
	   driver.findElement(By.linkText("Sign out")).click();
   }
}
