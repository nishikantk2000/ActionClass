package mavenClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlinkElementHanding 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement txtFirstName = driver.findElement(By.name("firstname"));
		highlight(js,txtFirstName, "My Cyber", 100);

	 	WebElement txtLastName = driver.findElement(By.name("lastname"));
		highlight(js,txtLastName, "Success",100);
		
		
		WebElement txtEmail = driver.findElement(By.name("reg_email__"));
		highlight(js,txtEmail,"CyberSuccess@gmail.com",100);

		String val= driver.findElement(By.name("firstname")).getAttribute("value");
		System.out.println("value: " + val);

		String txt = driver.findElement(By.name("firstname")).getText();
		System.out.println("txt: " + txt); //will not have any value
	}

	static void highlight(JavascriptExecutor js, WebElement element, String data, int ticks)
	{
		for(int i=0;i<=ticks;i++) // 0 1 2 3 4 5 6 7
		{
			if (i%2==0)
				js.executeScript("arguments[0].style.backgroundColor='red'",element);
			else
				js.executeScript("arguments[0].style.backgroundColor='white'",element);
		}
		js.executeScript("arguments[0].style.backgroundColor='white'",element);
		element.sendKeys(data);

	}

}
