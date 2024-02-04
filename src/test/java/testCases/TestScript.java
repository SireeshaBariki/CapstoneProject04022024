package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestScript {
	 private WebDriver driver;
	    private LoginPage loginPage;
	    private AdminPage adminPage;

	    @BeforeClass

	    public void setUp() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        driver.manage().window().maximize();
	        loginPage = new LoginPage(driver);
	        adminPage = new AdminPage(driver);
	        
	          Thread.sleep(4000);
	    
	    }

	    @Test
	    public void loginTest() throws InterruptedException {
	        loginPage.login("Admin", "admin123");
	 
	          Thread.sleep(6000);

	    
	    }

	    @Test(dependsOnMethods = "loginTest")
	    public void searchusers() throws InterruptedException {
	   
	    	adminPage.searchByUserRole();

	    
	    }

	  
	    
	}

