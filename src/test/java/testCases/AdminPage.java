package testCases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AdminPage {
	 private WebDriver driver;
	   private By Admin= By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']");
	    private By dropdownlist = By.xpath("//div[@class='oxd-select-text-input' and text()='-- Select --']");
	    private By admindata=By.xpath("//div[@role='option' and @class='oxd-select-option' and span[text()='Admin']]");
	    private By searchButton = By.xpath("//button[@type='submit' and normalize-space()='Search']");

	    public AdminPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void searchByUserRole() throws InterruptedException {
	        // Select user role from dropdown
	    	WebElement admin=driver.findElement(Admin);
	    	admin.click();
	    	Thread.sleep(4000);
	    	WebElement user=driver.findElement(dropdownlist);
	    	user.click();
	    	Thread.sleep(4000); // 4 seconds 
	    	WebElement ad=driver.findElement(admindata);
            ad.click();
	    	
	    	Thread.sleep(5000);
	        // Click on the search button
	        driver.findElement(searchButton).click();
	        Thread.sleep(4000);

	        // Display total records found (you may need to adjust the actual locator)
	        List<WebElement> recordsList = driver.findElements(By.xpath("//div[@class='oxd-table']"));
	        for (WebElement record : recordsList) {
	            System.out.println(record.getText());
	        }

	        // Refresh the page (you may need to adjust the actual locator)
	        driver.navigate().refresh();
	    }
}


