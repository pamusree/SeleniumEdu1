package com.selnum.educasestudies;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisteredUserException 
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
   @BeforeMethod
   public void openbrwsr()
   {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * ".\\Drivers\\chromedriver.exe"); ChromeOptions coptions = new
		 * ChromeOptions(); // coptions.addArguments( "disable-popup-blocking"); driver
		 * = new ChromeDriver();
		 */
	   System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   wait = new WebDriverWait(driver,90);
	   driver.navigate().to("https://www.edureka.co/");
   }
   
   @Test(priority=1,enabled=false)
   public void logInRegUser()
   {
	   Actions action = new Actions(driver);
	   
	   WebElement login = driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]"));
	   wait.until(ExpectedConditions.elementToBeClickable(login));
	   login.click();
	   
	   WebElement username = driver.findElement(By.id("si_popup_email"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("lekha.rama@hotmail.com");
		
		WebElement pswd = driver.findElement(By.id("si_popup_passwd"));
		wait.until(ExpectedConditions.elementToBeClickable(pswd));	
		pswd.sendKeys("Lekha123");

		WebElement logbtn = driver.findElement(By.xpath("//button[@class=\"clik_btn_log btn-block\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(logbtn));
		logbtn.click();
		
		WebElement search = driver.findElement(By.xpath("//input[@class='dropdown-toggle search_input']"));
		search.sendKeys("all courses");
		search.sendKeys(Keys.ENTER);
		
		
		WebElement profile2 = driver.findElement(By.xpath("(//span[@class=\"webinar-profile-name\"])[1]"));
		wait.until(ExpectedConditions.visibilityOf(profile2));
		
		//wait.until(ExpectedConditions.elementToBeClickable(profile2));
		profile2.click();
		
		
		WebElement logoutbtn = driver.findElement(By.xpath("(//a[@href=\"https://www.edureka.co/signout\"])[1]"));
		wait.until(ExpectedConditions.visibilityOf(logoutbtn));
		logoutbtn.click();
	
   }
   
   @Test(priority = 2)
   public void regUserException() 
   {
	  Actions action = new Actions(driver);
	  WebElement signup = driver.findElement(By.linkText("Sign Up"));
	  signup.click();
	  
	  WebElement regemail = driver.findElement(By.id("sg_popup_email"));
	  
	  regemail.sendKeys("lekha.rama@hotmail.com");
	  
		/*
		 * JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 * jsExecutor.executeScript("$(arguments[0]).change();", regemail);
		 */
		
	  
		  WebElement selcode =driver.findElement(By.xpath("(//div[@class=\"selected-dial-code\"])[5]"));
		  wait.until(ExpectedConditions.elementToBeClickable(selcode));
		  selcode.click();
		 
  		
		  WebElement ccode =driver.findElement(By.cssSelector(".sup_frm.signup-new-form>.inputfld>.allow-dropdown>.flag-container>.country-list>.country:nth-of-type(2)"));
		  
		  ccode.click();
		  System.out.println(ccode.getTagName()+ccode.getText());
		    
	  WebElement phnum = driver.findElement(By.id("sg_popup_phone_no"));
	  phnum.sendKeys("3313306776");
	  
	  WebElement subbtn = driver.findElement(By.cssSelector(".clik_btn_log.btn-block.signup-new-submit"));
	  subbtn.submit();
	  
	  WebElement exception = driver.findElement(By.xpath("//input[@id=\"sg_popup_email\"]/following-sibling::p"));
	  String exmsg = exception.getText();
	  String exptdmsg = "You are registered with us. Login to continue.";
	  System.out.println(exmsg);
	  if(exmsg.contentEquals(exptdmsg))
	  {
		  Reporter.log("Test passed.Already Registered User Exception being displayed ");
	  }
	  else {
		Reporter.log("Test failed. Expected Exception not displayed ");
	}
	  Reporter.log(exmsg);
   }

   @AfterMethod(enabled=false)
   public void clsbrwsr()
   {
	   driver.quit();
   }
}
