package mavenClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysDemo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		String a = "Cyber", b=" Success" , c=" Ltd", d="Deccan Pune";
		driver.findElement(By.name("q")).sendKeys(a,b,c,d);

//		driver.findElement(By.name("q")).sendKeys(a, Keys.ENTER);
		
		
		Thread.sleep(4000l);
		
		
		driver.quit();
	}

}
