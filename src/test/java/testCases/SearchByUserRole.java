package testCases;

import java.io.File;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.AdminPage_PageObject;
import pageObjects.Dashboard_PageObject;
import pageObjects.PageObject_HomePage;
import testBase.BaseClass;

public class SearchByUserRole extends BaseClass {
	
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
}
	
	@Test(dependsOnMethods = { "adminlink" })
	public void searchuserrole() throws InterruptedException 
	{
		
		AdminPage_PageObject adminpg=new AdminPage_PageObject(driver);
		adminpg.ClickUserRoledropdown();
		List<WebElement> Roledp=driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		
		//Find Total number of Options
		System.out.println("Total number of Options present in the dropdown :"+Roledp.size());
		
		//print all the options in the dropdown
		System.out.println("Printing the Elements in the Dropdown  " );
		for(int i=0;i<Roledp.size();i++)
		{
			System.out.println(Roledp.get(i).getText());
			}
		
		//Select Option from the Dropdown
		for(int i=0;i<Roledp.size();i++)
		{   Thread.sleep(2000);
			if(Roledp.get(i).getText().equals("Admin"))
			{
				Roledp.get(i).click();//div[@class='oxd-table-body']
			}
		}
		Thread.sleep(1000);
		
		adminpg.ClickonSearch();
		//driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		//driver.findElement(By.xpath("//div[@class='oxd-table-card']//div[@role='row']"));
		//WebElement table=driver.findElement(By.xpath("//div[@class='oxd-table-card']//div[@role='row']"));---gotoutput
		WebElement table=driver.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']"));
		System.out.println(table.getText()+"  \t   ");
		Thread.sleep(2000);
		
	    long timestamp = System.currentTimeMillis(); // Get timestamp for unique filename
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
		try {
	        FileUtils.copyFile(screenshotFile, new File("Screenshots/SearchUserStatus" + timestamp + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		adminpg.resetpage();
	}}
		/*try {
		
		//adminpg.ClickonSearch();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
		
		Thread.sleep(2000);
		WebElement UserRoleTable=driver.findElement(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\"]"));//div[@class="oxd-table-row oxd-table-row--with-border"]
		//WebElement UserRoleTable=driver.findElement(By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"][@role=\"cell\"]//div"));
		System.out.println(UserRoleTable.getText()+"  \t   ");
		
		Thread.sleep(3000);}
		catch(Exception e)
		{
			System.out.println("----");
		}
		}
	   // long timestamp = System.currentTimeMillis(); // Get timestamp for unique filename
		//TakesScreenshot screenshot= (TakesScreenshot)driver;
		//File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
		//try {
	     //   FileUtils.copyFile(screenshotFile, new File(" Screenshots/SearchUserRole " + timestamp + ".png"));
	    // catch (Exception e) 
		//{
	     //   e.printStackTrace();
	    //}
		//adminpg.resetpage();
		}*/
		
		
		
	
			
	    	    
		
	


	
