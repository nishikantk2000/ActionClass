package encapsulation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC002_LoginFlow {
	public static WebDriver driver;
  @Test
  public void testloginpage() {
	  LoginpageClass encapSelenium = new LoginpageClass(driver);
	 // LoginpageClass.getpage();
	  encapSelenium.getusername().sendKeys("Admin");
	  encapSelenium.getpassword().sendKeys("admin123");
	  encapSelenium.getloginbutton().click();
	  Assert.assertEquals("OrangeHRM",driver.getTitle());
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
