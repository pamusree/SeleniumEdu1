package com.selnum.educasestudies;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDifferentControls
{
  public static WebDriver driver = null;
  public static WebDriverWait wait = null;
  public static WebDriverWait jswait = null;
  
  public static void main(String a[])
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 20);
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  
	  String indigourl = "https://www.goindigo.in/?linkNav=home_header";
	  
	  driver.navigate().to(indigourl);
	  
	  WebElement oneway = driver.findElement(By.id("oneWayTrip"));
	  if(!oneway.isSelected())
	  {
		  oneway.click(); 
	  }
	   
	
	  WebElement from = driver.findElement(By.name("or-src"));
	  wait.until(ExpectedConditions.visibilityOf(from));
	  from.click();
	  
	  WebElement selfrom = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[1]/div/div/div/div/div[4]"));
	  selfrom.click();
	  
	  WebElement dest = driver.findElement(By.name("or-dest"));
	  wait.until(ExpectedConditions.visibilityOf(dest));
	  dest.sendKeys("Lucknow");
	  
	  WebElement departdate = driver.findElement(By.name("or-depart"));
	  departdate.click();
	    
	  WebElement calender = driver.findElement(By.xpath("//div[starts-with(@id,\"dp\")]"));
	  wait.until(ExpectedConditions.visibilityOf(calender));
	  calender.findElement(By.xpath("//div[starts-with(@id,'dp')]/div/div[1]/table/tbody/tr[3]/td[6]/a")).click();
	  
	  
	  WebElement passenger = driver.findElement(By.name("passenger"));
	  wait.until(ExpectedConditions.elementToBeClickable(passenger));
	  passenger.click();
	  
	  WebElement adultpsngr = driver.findElement(By.xpath("//div[@class=\"passenger-dropdown pax-selection-row\"]/ul/li/div/button[2]"));
	  //WebElement adultnum = driver.findElement(By.xpath("//div[@class=\"passenger-dropdown pax-selection-row\"]/ul/li/div/input[@class=\"counter adult-pax\"]"));
	  for(int i=1;i<=2;i++)
	  {
	    adultpsngr.click();
	  }
	 
	 
	  WebElement childpsngr = driver.findElement(By.xpath("//div[@class='passenger-dropdown pax-selection-row']/ul/li[2]/div/button[2]"));
	  for(int i=1;i<=2;i++)
	  {
	   childpsngr.click();
	  }
	  
	 
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  WebElement done = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/div/button"));
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	  js.executeScript("arguments[0].scrollIntoView()", done);
	  wait.until(ExpectedConditions.elementToBeClickable(done));
	  done.click();
	  
	  WebElement search = driver.findElement(By.xpath(" //*[@id=\"bookFlightTab\"]/form/div[7]/div[6]/button"));
	  wait.until(ExpectedConditions.elementToBeClickable(search));
	  search.click();
	  
	  Wait fluWait = new FluentWait<WebDriver>(driver)
              .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500));
	  
	  driver.close();
	  
  }
}
