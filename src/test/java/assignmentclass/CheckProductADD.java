package assignmentclass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class CheckProductADD 
{
  WebDriver driver ;
  
  @Test
  public void test1() 
  {
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("jacket");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  WebElement findelement = driver.findElement(By.xpath("//*[@id=\"qs-option-1\"]"));
	  findelement.click();
	  
	  WebElement btnMouseHover = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[2]"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(btnMouseHover).build().perform();
	  btnMouseHover.click();
  }
  @BeforeTest
  public void beforeTest() 
  {   
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://magento.softwaretestingboard.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
