package com.selnum.educasestudies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDifferentControls2 
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	public static void main(String a[])
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		
		WebElement username = driver.findElement(By.id("si_popup_email"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("******");
		
		WebElement pswd = driver.findElement(By.id("si_popup_passwd"));
		wait.until(ExpectedConditions.elementToBeClickable(pswd));
		pswd.sendKeys("*****");
		
		WebElement logbtn = driver.findElement(By.xpath("//button[@class=\"clik_btn_log btn-block\"]"));
		logbtn.click();
		
		WebElement profile = driver.findElement(By.xpath("//img[@class=\"user_image\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
		
		WebElement selprofile = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right caret_drop\"]"));
		selprofile.findElement(By.linkText("My Profile")).click();
		
		WebElement prsnl_dtls = driver.findElement(By.id("personal_details"));
		prsnl_dtls.click();
		
		WebElement fname = driver.findElement(By.name("fullname"));
		wait.until(ExpectedConditions.elementToBeClickable(fname));
		fname.clear();
		fname.sendKeys("******");
		
		WebElement cntbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-default pull-right verify-continue-btn\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(cntbtn));
		cntbtn.click();
		
		WebElement nextbtn = driver.findElement(By.xpath("//button[text()='Next' and @class='btn pull-right onboarding-primary-button']"));
		wait.until(ExpectedConditions.elementToBeClickable(nextbtn));
		nextbtn.click();
		
		WebElement nextbtn2 = driver.findElement(By.xpath("//button[text()='Next' and @class='btn onboarding-primary-button pull-right']"));
		wait.until(ExpectedConditions.elementToBeClickable(nextbtn2));
		nextbtn2.click();
		
		WebElement savebtn = driver.findElement(By.xpath("//button[text()='Save' and @class='btn pull-right onboarding-primary-button']"));
		savebtn.click();
		

		WebElement profile2 = driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-profile-main/app-header/header/nav/div/div[3]/ul/li[8]/div/button/img"));
		wait.until(ExpectedConditions.elementToBeClickable(profile2));
		profile2.click();
		
		WebElement selprofile2 = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right caret_drop\"]"));
		selprofile2.findElement(By.linkText("Log Out")).click();
		
	}

}
