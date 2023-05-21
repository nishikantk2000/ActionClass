package testNGclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionTestNG 
{ 
	WebDriver driver ;
  @Test(priority =1)
  public void testpclooudylogin() 
  {
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
	  
	  Assert.assertEquals(actualTitle, expectedTitle,"pCloudy Login Test Failed");
			  
	  
	  
	  
  }
  @BeforeTest
  public void setup() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.pcloudy.com/");
	  
  }

  @AfterTest
  public void tearDown()
  {
	  if(driver != null) 
	  {
		  driver.quit();
      }


  }
}
