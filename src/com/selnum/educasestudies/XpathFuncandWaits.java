package com.selnum.educasestudies;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathFuncandWaits 
{
	public static WebDriver driver = null;
	   
	   public static WebDriverWait wait = null;
	   
	   
	   public static void main(String a[])
	   {
		   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		   
		   driver = new ChromeDriver();
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//page load time out
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//implicit wait
		   driver.manage().window().maximize();//maximize window
		   
		   String baseurl = "https://edureka.co";
		   driver.navigate().to(baseurl);//navigate to edureka.co
		   
		   driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
		   
		   long ctime = System.currentTimeMillis();
		   jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		   System.out.println("Passed time:" + (System.currentTimeMillis()-ctime));
		   WebElement search = driver.findElement(By.xpath("//input[@id='search-inp3']"));
		   wait.until(ExpectedConditions.visibilityOf(search));  
		   search.click();
		   
		   WebElement srchbar = driver.findElement(By.xpath("//*[@id=\"search-inp-overlay-new\"]"));
		   srchbar.sendKeys("selenium");
		   
		   WebElement srchbtn = driver.findElement(By.xpath("//*[@id=\"search-button-top\"]"));
		   srchbtn.click();
		   
		   WebElement selcourse = driver.findElement(By.xpath("//*[@id=\"add-master-courses\"]/a[1]"));
		   selcourse.click();
		   
		   String seltitle = driver.getTitle();
		   System.out.println(seltitle);
		   
		   String exptitle = "Selenium Certification Training & Course With Project - Edureka";
		   
		   if(seltitle.contentEquals(exptitle))
		   {
			   System.out.println("Landed on correct page--titles match");
		   }
		   else 
		   {
				System.out.println("Error--titles of the page do not match");   
		   }
		   
		   driver.navigate().back();
		   
		   WebElement allcourses = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		   allcourses.click();
		   
		   Wait fluWait = new FluentWait<WebDriver>(driver)
				              .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500));
		   
		  
}
		   	   
	   
}
