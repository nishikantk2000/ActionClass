package mavenClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlelessBrowser 
{

  public static void main(String[] args) throws InterruptedException 
	{
	  WebDriverManager.chromedriver().setup(); 
	 // EdgeOptions option=new EdgeOptions(); 
	  //option.setHeadless(true); 
	  WebDriver driver=new ChromeDriver();
	 
	
	driver.get("https://courses.letskodeit.com/practice");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	System.out.println("Title is " + driver.getTitle());
	driver.findElement(By.id("opentab")).click();
	Thread.sleep(1000l);
	Set<String> windIds = driver.getWindowHandles();
	Iterator<String> iter = windIds.iterator();
	String pWindId = iter.next();
	String cWindId = iter.next();
	
	driver.switchTo().window(cWindId);
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.titleContains("All"));
	Thread.sleep(1000l);
	System.out.println("cWind title: " + driver.getTitle());
	driver.switchTo().window(pWindId);
	System.out.println("pWind title: " + driver.getTitle());
	Thread.sleep(1000l);
	driver.quit();
	}

}
