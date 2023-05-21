package testNGclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumtestng 
{
	
	WebDriver driver;
	
	@DataProvider(name="DP")
	public Object[][] getCredentials()
	{
		
		Object[][] data = {
			 	{"Admin","admin123", "Valid"},
			 	{" ",    "admin123", "Blank"},
			  	{"Admin"," ",        "Blank"},
				{"user1","user1",    "Invalid"}
		};
		
		return data;
	}
	
	
	
	  
  
  @Test(dataProvider="DP")
  public void verifyLogin(String username, String password, String result)
	{
		String txtError;
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		if(result.equals("Blank"))
		{	
			txtError = driver.findElement(By.xpath("//form[@class='oxd-form']//span")).getText();
			Assert.assertTrue(txtError.equals("Required"),"Test case failed with blank credentails");
		} else if (result.equals("Valid"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			try
			{
				WebElement logo = wait.until(
						ExpectedConditions.presenceOfElementLocated(
								By.xpath("//img[@alt='client brand logo']")));
				// if element is found that means test case is passed
				Assert.assertTrue(true);
			} catch(Exception e)
			{
				Assert.assertTrue(false,"Test case failed with Valid credentails");
			}
		} else if (result.equals("Invalid"))
		{
			Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='app']//p)[1]")).getText().trim().equals("Invalid credentials"), "Test Case Failed with invalid credentails");
		}
	}
  @BeforeTest
  public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
	}
  
  @AfterTest
  public void afterTest()  
  {
	
	    driver.quit();
  }

}
