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

import pageObjects.Dashboard_PageObject;
import pageObjects.PageObject_HomePage;
import testBase.BaseClass;
@Test
public class PrintOptions extends BaseClass {

	
	@Test(priority=1)
	public void login()
	{
	PageObject_HomePage homepg=new PageObject_HomePage(driver);
	homepg.setUserName("Admin");
	homepg.setPassword("admin123");
	homepg.clicklogin();
	}

	@Test (priority=2)
	public void get12Options() throws InterruptedException 
	{
		Thread.sleep(2000);

	List<WebElement> Options12= driver.findElements(By.xpath("//li[@class=\"oxd-main-menu-item-wrapper\"]"));	
	System.out.println("Number of options from the left side menu : "+Options12.size());
	
	for(WebElement option:Options12)
	{
		
		System.out.println(option.getText());
	}
	
	}
	
	
	@Test(priority=3)	
public void adminlink() throws InterruptedException
{
	Dashboard_PageObject adminlk=new Dashboard_PageObject(driver);
	adminlk.clickadmin();
	// Capture screenshot for Admin Page
	Thread.sleep(2000);
    long timestamp = System.currentTimeMillis(); // Get timestamp for unique filename
	TakesScreenshot screenshot= (TakesScreenshot)driver;
	File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
	try {
        FileUtils.copyFile(screenshotFile, new File("Screenshots/Admin_Page" + timestamp + ".png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}
		
		
	}


//li[@class="oxd-main-menu-item-wrapper"]