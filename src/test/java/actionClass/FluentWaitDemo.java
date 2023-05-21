package actionClass;


import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo
{ 

	public static void main(String[]argu) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("facebook");
		Thread.sleep(3000);

			   // Waiting 30 seconds for an element to be present on the page, checking
			   // for its presence once every 5 seconds.
			   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					   .withTimeout(Duration.ofSeconds(30))
				       .pollingEvery(Duration.ofSeconds(5))
				       .ignoring(NoSuchElementException.class);
			  
		WebElement clickseleniumlink =wait.until(new Function<WebDriver, WebElement>()
			{
		       public WebElement apply(WebDriver driver) 
		       {
		        WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/span"));
		        element.click();
				return element;
				
		       }
		    });
		//WebElement openlink=driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a"));
			//	openlink.click();
		        Thread.sleep(2000);
				clickseleniumlink.click();
				driver.close();
				
      }
 }
