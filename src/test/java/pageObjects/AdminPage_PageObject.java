package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage_PageObject extends BasePage {
       WebDriver driver;
	
	 public AdminPage_PageObject (WebDriver driver)
		{
			super (driver);
			
		}

	// WebElements Locators+identification

@FindBy(xpath="//span[normalize-space()='User Management']")  WebElement userManagement;
@FindBy(xpath="//a[normalize-space()='Users']") WebElement users;
@FindBy(xpath="//span[normalize-space()='Job']")  WebElement job;
@FindBy(xpath="//span[normalize-space()='Organization']")  WebElement organization;
@FindBy(xpath="//span[normalize-space()='Qualifications']") WebElement qualifications;
@FindBy(xpath="//span[normalize-space()='More']")  WebElement more;
@FindBy(xpath="//i[@class='oxd-icon bi-question-lg']")  WebElement help;
@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")  WebElement Adminpageusername;
@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']")  WebElement UserRole_txt;
@FindBy(xpath="//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")  WebElement UserRole_dpdown;
@FindBy(xpath="//input[@placeholder='Type for hints...']")  WebElement EmployeeName;
@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']")  WebElement Status_txt;
@FindBy(xpath="//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")  WebElement Status_dpdown;
@FindBy(xpath="//button[normalize-space()='Reset']")  WebElement reset;
@FindBy(xpath="//button[normalize-space()='Search']")  WebElement search;
@FindBy(xpath="//button[normalize-space()='Add']")  WebElement add;
@FindBy(xpath="//div[@role='columnheader']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")  WebElement columnheader;

//Action methods

public void setUserName(String username)
{
	Adminpageusername.sendKeys(username);
}

public void ClickUserRoledropdown()
{
	UserRole_dpdown.click();
}
public void ClickonSearch()
{
	search.click();
}
public void ClickonStatus()
{
	Status_txt.click();
}
 public void resetpage()
 {
	 reset.click();
 }

}


