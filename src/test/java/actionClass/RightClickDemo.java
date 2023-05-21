package actionClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class RightClickDemo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement img= driver.findElement(By.xpath("(//p)[2]/img"));
		Actions action = new Actions(driver);
		action.contextClick(img).build().perform(); //right click on an image
		Thread.sleep(2000l);
		//click on Product Info
		driver.findElement(By.id("dm2m1i1tdT")).click();  // product info
		Thread.sleep(2000l);
		// click on Parameters info
		driver.findElement(By.id("dm2m2i2tdT")).click();  //parameter
		//opens new window
		Set<String> windoHandles = driver.getWindowHandles();
		Iterator<String> windIds = windoHandles.iterator();
		String pWindId = windIds.next();
		String cWindId = windIds.next();
		driver.switchTo().window(cWindId);
		String actualNewWindowTitle = driver.getTitle();
		System.out.println("actualNewWindowTitle: " +actualNewWindowTitle);
		String expNewWindTitle = "Menu Javascript Parameters - Product Info";
		if (actualNewWindowTitle.equals(expNewWindTitle))
			System.out.println("Test case PASSED !!!");
		else
			System.out.println("Test case FAILED !!!");
				
		Thread.sleep(4000l);
		driver.quit();

	}

}
