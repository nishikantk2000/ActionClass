package actionClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingLinksAsection 
{
    public static void main(String[]argu)
    {
    	WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebElement box = driver.findElement(By.xpath("//div[@class='dev-links']"));
		
		List<WebElement> low = box.findElements(By.tagName("a"));
		System.out.println("size: " + low.size());
		
		for(WebElement ele: low)
			System.out.println(ele.getText());
    }
}
