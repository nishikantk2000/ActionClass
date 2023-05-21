package testNGclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionTestNG 
{ 
	WebDriver driver;
	SoftAssert softAssert;
	
  @Test(priority=1)
  public void testNGPcloudylogin() 
  { 
	  softAssert = new SoftAssert();
	  WebElement loginHeader = driver.findElement(By.xpath("//*[@id=\"dynamic\"]/div/nav/div/form/a[1]"));
	  loginHeader.click();
	  WebElement username = driver.findElement(By.id("userId"));
	  username.sendKeys("nishikantk2000@gmail.com");
	 
	  WebElement password = driver.findElement(By.id("password"));
	  password.sendKeys("Nishikantk2000");
	  
	
	  WebElement loginbtn = driver.findElement(By.id("loginSubmitBtn"));
	  loginbtn.click();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	  
	  String expectedTitle = 
			  "Mobail app testing,Contenuous Testing Cloud, Mobail Testing Tool | pCloudy";
	  String actualTitle = driver.getTitle();
	  
	  softAssert.assertEquals(actualTitle, expectedTitle,"pCloudy Login Test Failed");
	  System.out.println("Soft Assertion Statement is Executed");
	  softAssert.assertAll();
			  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.pcloudy.com/");
  }

  @AfterTest
  public void afterTest() 
  {

	  if(driver != null) 
	  {
		  driver.quit();
      }

  }

}
