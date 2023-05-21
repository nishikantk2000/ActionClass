package assignmentclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Googletest {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		WebElement googletextfeild = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		 googletextfeild.sendKeys("face");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		WebElement Search= driver.findElement(By.xpath("//*[@id=\"jZ2SBf\"]/div[1]/span"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(Search).click().build().perform();
		
		Thread.sleep(2000);
		driver.close();

     }
}

