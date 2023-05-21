package actionClass;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CheckProductCart 
{

	public static void main(String[]argu) throws InterruptedException 
	{
		//setup WebDriver 
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://magento.softwaretestingboard.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//search in text box "jacket"  
		  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("jacket");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  WebElement findelement = driver.findElement(By.xpath("//*[@id=\"qs-option-1\"]"));
		  findelement.click();
		 //click on men jacket
		  WebElement btnMouseHover = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[2]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(btnMouseHover).build().perform();
		  btnMouseHover.click();
		//Scrollwindow using javascript
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1500)");
		 //click on Hero Hoodie 
          WebElement image = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img"));
		  actions.click(image).build().perform();
		 
		  //select size,Colour and Qty 
		  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  Thread.sleep(4000);
				  
		  WebElement size = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
		  actions.click(size).build().perform();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  
		  WebElement colour = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));
		  actions.click(colour).build().perform();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  WebElement addcartbtn = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span"));
		  js.executeScript("arguments[0].scrollIntoView();", addcartbtn);
			 
			js.executeScript("arguments[0].style.border='5px solid blue'", addcartbtn);

			js.executeScript("arguments[0].click();", addcartbtn);

		  js.executeScript("window.scroollBy(0,500)");
		
		  actions.click(addcartbtn).build().perform();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  //check the product in cart to added or not 
		  WebElement checkCart = driver.findElement(By.xpath("//div[@class='minicart-wrapper']/a"));
		  actions.sendKeys(Keys.PAGE_UP).build().perform();
			 
		  actions.click(checkCart).build().perform();
		  
		
		  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		  
		  Thread.sleep(2000);
		  
		  driver.quit();
		  
	}
	
}
				

	

