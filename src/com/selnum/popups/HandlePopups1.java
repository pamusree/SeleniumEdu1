package com.selnum.popups;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlePopups1 {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	public static void main(String[] args) throws InterruptedException
	{
	  	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	wait = new WebDriverWait(driver, 20);
	  	driver.navigate().to("http://www.popuptest.com/");
	  	String parentId = driver.getWindowHandle();
	  	System.out.println(driver.getCurrentUrl());
	  	
        WebElement multipop = driver.findElement(By.xpath("//a[@href='popuptest1.html']"));
        multipop.click();
        Set<String> popupsList = driver.getWindowHandles();
        System.out.println(popupsList.size());
        //Iterator iterator = popupsList.iterator();
        
        String mainpopurl = null;
        
       for(String pList : popupsList)
        {
    	   if(pList.contentEquals(parentId))
    	   {
    		   mainpopurl = driver.getCurrentUrl();
    		   System.out.println(mainpopurl);
    		   continue;
    		   
    	   }
    	    driver.switchTo().window(pList);
        	driver.manage().window().maximize();
        	System.out.println(driver.getCurrentUrl());
            //Thread.sleep(1000);
        	driver.close();
        	
        }
       
       wait.until(ExpectedConditions.numberOfWindowsToBe(1));
       driver.switchTo().window(parentId);
       System.out.println(driver.getCurrentUrl());
       Thread.sleep(1000);
       WebElement bckbtn = driver.findElement(By.xpath("//input[@type='button']")); 
       bckbtn.click();
       Set<String> bpoplist = driver.getWindowHandles();
	   System.out.println(bpoplist.size());  
		  for(String list : bpoplist) 
		{ /*
			 * if(list.contentEquals(parentId)) { continue; }
			 */
			  driver.switchTo().window(list);
		      driver.manage().window().maximize();
		      System.out.println(driver.getCurrentUrl()); 
		      driver.close(); 
		  }
		  
		 
	}

}
