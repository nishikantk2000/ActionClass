package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreameHandling 
{
   public static void main(String[]argu)
   {
	   WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       
		driver.switchTo().frame("courses-iframe");
		System.out.println(driver.findElement(By.xpath("//*[@id='zen_all_courses_dynamic']/div[1]/h1")).getText());
		
   }
}
