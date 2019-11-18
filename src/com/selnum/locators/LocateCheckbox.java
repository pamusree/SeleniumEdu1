package com.selnum.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocateCheckbox {

	public static WebDriver driver = null;
	   
	   public static WebDriverWait wait = null;
	   
	   public static void main(String a[])
	   {
		   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		   
		   driver = new ChromeDriver();
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   driver.navigate().to("http://demo.automationtesting.in/Register.html");
		   
		   WebElement chkbox1 = driver.findElement(By.id("checkbox1"));
		   chkbox1.click();
		   
		   WebElement chkbox2 = driver.findElement(By.id("checkbox2"));
		   chkbox2.click();
		   
		   WebElement rdbtn = driver.findElement(By.xpath("//input[@value='Male']"));
		   rdbtn.click();
		   
		   WebElement drplist = driver.findElement(By.id("Skills"));
		   Select skills = new Select(drplist);
		  
		   
		   skills.selectByIndex(3);
		   System.out.println(drplist.getText());
		
	}

}
