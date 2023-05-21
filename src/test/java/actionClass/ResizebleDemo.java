package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizebleDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[3]/a")).click();
		
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200);");
		
		driver.switchTo().frame(0);
		
		WebElement resizableEle = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(resizableEle)
			   .moveByOffset(200, 200)
			   .release()
			   .build().perform();
	}

}
