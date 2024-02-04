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

public class SearchByUserStatus extends BaseClass {

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
	public void searchUserStatus() throws InterruptedException {
				
		AdminPage_PageObject adminpg=new AdminPage_PageObject(driver);
		
		driver.findElement(By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		List<WebElement> statusdp=driver.findElements(By.xpath("//div[@role='option']"));
		//List<WebElement> statusdp=driver.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']"));
		//Find Total number of Options
				System.out.println("Total number of Options present in the statusdropdown :"+statusdp.size());
				
				//print all the options in the dropdown
				System.out.println("Printing the Elements in the Dropdown  " );//div[@role='option']
				for(int i=0;i<statusdp.size();i++)
				{
					System.out.println(statusdp.get(i).getText());
					}
				
				//Select Option from the Dropdown
				Thread.sleep(1000);
			
				for(int i=0;i<statusdp.size();i++)
				{
					if(statusdp.get(i).getText().equals("Disabled"))
					{
						statusdp.get(i).click();
					}
				}
				
							
				driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
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
				}
							   
				
		
	}
	
	


