package testCases;



import org.testng.annotations.Test;


import pageObjects.PageObject_HomePage;
import testBase.BaseClass;



public class ValidLoginTest extends BaseClass {
	
	
	@Test
	
	public void login()
	{
	PageObject_HomePage homepg=new PageObject_HomePage(driver);
	homepg.setUserName("Admin");
	homepg.setPassword("admin123");
	homepg.clicklogin();
	}
	

}