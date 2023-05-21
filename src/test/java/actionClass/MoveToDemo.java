package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		WebElement btnMouseHover = driver.findElement(By.id("mousehover"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(btnMouseHover).build().perform();
		WebElement menuTop = driver.findElement(By.xpath("//fieldset/div/div"));
		
		actions.click(menuTop).build().perform();
		driver.close();
	}

}
