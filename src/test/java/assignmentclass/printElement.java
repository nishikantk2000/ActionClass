package assignmentclass;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printElement 
{

	public static void main(String[] args) throws InterruptedException 
	{
		loginpage();
	}
	static void loginpage() throws InterruptedException
	{ 

		   WebDriverManager.chromedriver().setup();
			WebDriver driver  = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
			driver.findElement(By.name("username")).sendKeys("Admin");
			Thread.sleep(2000);
			driver.findElement(By.name("password")).sendKeys("admin123");
			Thread.sleep(2000);
		
			WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
			loginbtn.click();
			
			Thread.sleep(2000);
			WebElement showElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside"));
			    System.out.print("List of Element present"+ showElement.getText());
			    
			    
			Actions action = new Actions(driver);
		    WebElement shift = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i"));
		    action.moveToElement(shift).click().build().perform();
		    Thread.sleep(2000);
			WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
			action.moveToElement(logout).click().build().perform();
		 
			Thread.sleep(2000);
			    driver.quit();
			
			
		
		
	
		
		
	}
	

}
