package abstraction;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TC001_LoginTest {
	public WebDriver driver;
  @Test
  public void LoginPage1() {
	  LoginPageMethods login = new LoginPageMethods(driver);
	  login.enterUserName("Admin");
	  login.enterPassword("admin123");
	  login.clickLoginButton();
  }
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	 // WebDriverManager.chromedriver().setup();
	//  ChromeOptions option=new ChromeOptions();
	 // option.addArguments("--remote-allow-origins-");
	  WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
