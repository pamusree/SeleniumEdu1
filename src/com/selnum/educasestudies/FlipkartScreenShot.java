package com.selnum.educasestudies;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartScreenShot 
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
   @BeforeMethod
   public void openbrwsr()
   {
	   
		 /* System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		 */
		
		
		  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		  ChromeOptions coptions = new ChromeOptions(); 
		  coptions.addArguments("disable-popup-blocking");
		  driver = new ChromeDriver(coptions);
		 
		
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   wait = new WebDriverWait(driver,90);
	   driver.navigate().to("https://www.flipkart.com/");
   }
   
   @Test
   public void flipkart()
   {
	   Actions action = new Actions(driver);
	   WebElement search = driver.findElement(By.name("q"));
	   search.sendKeys("Selenium");
	   search.sendKeys(Keys.ENTER);
	   
	   WebElement popup = driver.findElement(By.xpath("//div[@class='_3Njdz7']/button"));
	   wait.until(ExpectedConditions.visibilityOf(popup));
	   popup.click();
	   
	   WebElement selitem = driver.findElement(By.xpath("//div[@data-id=\"9781788299671\"]"));
	   selitem.click();
	   
	   Set<String> winids = driver.getWindowHandles();
	   List<String> winidlist = new ArrayList<String>(winids);
	   String curwinid = winidlist.get(1);
	   
	   for(String id: winids)
	   {
		   System.out.println("id:"+id);
	   }
	   
	   String pageurl = driver.getCurrentUrl();
	   System.out.println(pageurl);
			   
		  driver.switchTo().window(curwinid);
		  pageurl = driver.getCurrentUrl();
		  System.out.println(pageurl);
		  WebElement pincode = driver.findElement(By.xpath("//input[@id=\"pincodeInputId\"]"));
		  wait.until(ExpectedConditions.visibilityOf(pincode));
		  pincode.sendKeys("500032"); 
		  action.moveToElement(driver.findElement(By.cssSelector("._2aK_gu"))).click();
		 
	   
	   WebElement duration = driver.findElement(By.xpath("//span[@class=\"_3nCwDW\"]"));
	   String durationmsg = duration.getText();
	   Reporter.log(durationmsg);
	   
	   WebElement addcart = driver.findElement(By.cssSelector("._2AkmmA._2Npkh4._2MWPVK"));
	   wait.until(ExpectedConditions.elementToBeClickable(addcart));
	   addcart.click();
	
		  pageurl = driver.getCurrentUrl();
		  System.out.println(pageurl);
	  
	   WebElement placeorder = driver.findElement(By.cssSelector("._2AkmmA.iwYpF9._7UHT_c>span"));
		
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("_37Bhrp")));
	   wait.until(ExpectedConditions.visibilityOf(placeorder));
	  
	   placeorder.click();
	   
	   WebElement email = driver.findElement(By.xpath("//input[@class='_2zrpKA _14H79F']"));
	   wait.until(ExpectedConditions.visibilityOf(email));
	   email.sendKeys("test@gmail.com");
	   
	   WebElement cont = driver.findElement(By.cssSelector("div._2CQ7Aq>button._2AkmmA._1poQZq._7UHT_c>span"));
	   wait.until(ExpectedConditions.elementToBeClickable(cont));
	   cont.click();
	   
	   WebElement pswd = driver.findElement(By.cssSelector("div._39M2dM>input[type='password']"));
	   wait.until(ExpectedConditions.visibilityOf(pswd));
	   pswd.sendKeys("test123");
	   
	   WebElement cont2 = driver.findElement(By.cssSelector("div._2CQ7Aq>button._2AkmmA._1poQZq._7UHT_c>span"));
	   wait.until(ExpectedConditions.elementToBeClickable(cont2));
	   cont2.click();
	   
	  WebElement errmsg = driver.findElement(By.cssSelector("div.A4KZv8>div>div>div.JAUzCh"));
	  wait.until(ExpectedConditions.visibilityOf(errmsg));
	  Boolean b = errmsg.isDisplayed();
	  String emsg = errmsg.getText();
	  File scrn = errmsg.getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrn, new File( ".//ScreenShots//"+"Errormsg.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println("Displayed: "+b+ " msg: "+emsg);
	  Reporter.log(emsg);
	   //cont.click();
   }

}
