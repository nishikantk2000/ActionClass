package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeactionClass 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// droppable link
		driver.findElement(By.xpath("(//div[@id='sidebar']/aside/ul/li[2])[1]")).click();
		
		 
		driver.switchTo().frame(0);
	 
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).perform();
		
		driver.switchTo().defaultContent();  // parent window
		driver.findElement(By.name("s")).sendKeys("CyberSuccess");
		
		Thread.sleep(4000l);
		driver.quit();
		
			
	}

}
