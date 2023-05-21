package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollntoElement 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebElement element = 
				driver.findElement(By.xpath("//div[@class='view-source']//a"));
		//scroll to a specific element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		 
		js.executeScript("arguments[0].style.border='5px solid blue'", element);

		js.executeScript("arguments[0].click();", element);

		WebElement txtSearch = driver.findElement(By.name("s"));
		
		js.executeScript("window.scrollBy(0,-1000)", "");
		
		
		
		
		
		
		
		driver.get("https://courses.letskodeit.com/practice");	
		js.executeScript(
				"document.getElementById('name').value='CyberSuccess'");
		
		

	}

}
