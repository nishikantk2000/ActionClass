package assignmentclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
	    
	    WebElement sigup= driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
	    sigup.click();
	    Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Nishikant");
		 Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("Kishirsagar");
		 Thread.sleep(2000);
		driver.findElement(By.name("reg_email__")).sendKeys("nishikantk@gmail.com");
		 Thread.sleep(2000);
		driver.findElement(By.name("reg_passwd__")).sendKeys("@nishikant");
		 Thread.sleep(2000);
		WebElement dateElement = driver.findElement(By.id("day"));
		Select dateDropdown = new Select(dateElement);
		dateDropdown.selectByIndex(0);
		Thread.sleep(2000);
		WebElement monthElement = driver.findElement(By.id("month"));
		Select monthDropdown = new Select(monthElement);
		monthDropdown.selectByValue("8");
		Thread.sleep(2000);
		WebElement yearElement = driver.findElement(By.id("year"));
		Select yearDropdown = new Select(yearElement);
		yearDropdown.selectByVisibleText("2000");
		Thread.sleep(2000);
		
	
		WebElement rediobtn= driver.findElement(By.xpath("//input[@value='2']"));
		rediobtn.click();
		Thread.sleep(2000);
		
		
		driver.quit();
	 }

}
