package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_PageObject extends BasePage {
      
	WebDriver driver;
	
	
   public Dashboard_PageObject (WebDriver driver)
		{
			super (driver);
			
		}

   // WebElements Locators+identification
@FindBy(xpath="//h6[normalize-space()='Dashboard']")   WebElement dashboard_display;
@FindBy(xpath="//img[@alt='client brand banner']")  WebElement logo;
@FindBy(xpath="//input[@placeholder='Search']")  WebElement search_inputBtn;
@FindBy(xpath="//span[normalize-space()='Admin']")  WebElement admin_link;
@FindBy(xpath="//span[normalize-space()='PIM']")  WebElement PIM_link;
@FindBy(xpath="//span[normalize-space()='Leave']")  WebElement leave_link;
@FindBy(xpath="//span[normalize-space()='Time']")  WebElement time_link;
@FindBy(xpath="//span[normalize-space()='Recruitment']")  WebElement recruitment_link;
@FindBy(xpath="//span[normalize-space()='My Info']")  WebElement myInfo_link;
@FindBy(xpath="//span[normalize-space()='Performance']")  WebElement performance_link;


@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']") WebElement dashboard_button;
@FindBy(xpath="//span[normalize-space()='Directory']")  WebElement directory_link;
@FindBy(xpath="//span[normalize-space()='Maintenance']") WebElement maintenance_link;
@FindBy(xpath="//span[normalize-space()='Claim']")  WebElement claim_link;
@FindBy(xpath="//span[normalize-space()='Buzz']")  WebElement buzz_link;

//Action methods



public void clickadmin()
{
	admin_link.click();
}

public boolean dashboardLogoPresence()
{
	boolean status=logo.isDisplayed();
	return status;
}
}
