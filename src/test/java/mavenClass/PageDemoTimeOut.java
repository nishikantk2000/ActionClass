package mavenClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageDemoTimeOut 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://demoqa.com/text-box");
        
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Cyber");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("Success@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Deccan, Pune 14");
	}

}
