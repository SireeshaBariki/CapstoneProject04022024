package testCases;

import java.io.File;
import java.io.IOException;

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

public class SearchByUserName extends BaseClass {

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
	public void searchusername() throws InterruptedException
	{
		AdminPage_PageObject adminpg=new AdminPage_PageObject(driver);
		adminpg.setUserName("Admin");
		adminpg.ClickonSearch();
		WebElement table=driver.findElement(By.xpath("//div[@class='oxd-table-card']//div[@role='row']"));
		System.out.print(table.getText()+"  \t   ");
		Thread.sleep(2000);
	    long timestamp = System.currentTimeMillis(); // Get timestamp for unique filename
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
		try {
	        FileUtils.copyFile(screenshotFile, new File("Screenshots/SearchUserName" + timestamp + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		adminpg.resetpage();
	}
}

