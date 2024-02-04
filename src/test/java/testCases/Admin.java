package testCases;

import org.testng.annotations.Test;

import pageObjects.Dashboard_PageObject;
import pageObjects.PageObject_HomePage;
import testBase.BaseClass;

public class Admin extends BaseClass{
    
	@Test
	public void login()
	{
	PageObject_HomePage homepg=new PageObject_HomePage(driver);
	homepg.setUserName("Admin");
	homepg.setPassword("admin123");
	homepg.clicklogin();
	}

	@Test(dependsOnMethods = { "login" })	
public void adminlink()
{
	Dashboard_PageObject adminlk=new Dashboard_PageObject(driver);
	adminlk.clickadmin();
	

}}

