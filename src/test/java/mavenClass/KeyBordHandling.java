package mavenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBordHandling 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);", "");
        
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr Cyber Success");
        
        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("CyberSuccess@gmail.com");
        
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Deccan,Pune, 14");

        String k = Keys.chord(Keys.CONTROL,"a"); //pressing CONTRL+a
        currentAddress.sendKeys(k);
        
        // Copy into clipboard the Current Address by pressing CONTROL+A
        k=Keys.chord(Keys.CONTROL,"c");// press Contrl+c
        currentAddress.sendKeys(k);
        Thread.sleep(2000l);
        
        //Press the TAB Key to Switch Focus to Permanent Address
 //       Actions actions = new Actions(driver);
 //       actions.sendKeys(Keys.TAB).build().perform();
        Thread.sleep(2000l);

        //Paste the Address in the Permanent Address field
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.clear();
        k = Keys.chord(Keys.CONTROL,"v");
        permanentAddress.sendKeys(k);
        

        
        Thread.sleep(4000l);
        driver.quit();
	}

}
