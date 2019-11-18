package com.selnum.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyFirstTestNg 
{
	@Test(priority = 1, enabled=false)
	public void firstTestNgMethod()
	{
		Reporter.log("First TestNg Method");
	}
	
	@Test(priority = 2,invocationCount = 2)
	public void createUser()
	{
		Reporter.log("User Created");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "createUser",priority=3)
	public void editUser()
	{
		Reporter.log("Used Edited");
	}
	
	@Test(dependsOnMethods = "createUser",priority=-1)
	public void deleteUser()
	{
		Reporter.log("User Deleted");
	}

}
