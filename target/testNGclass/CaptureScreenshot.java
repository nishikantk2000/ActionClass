package testNGclass;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot 
{
	public static void main(String[]argu) throws IOException 
	{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  String url = "https://courses.letskodeit.com/practice";
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.manage().window().maximize();
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,500)", "");
	
	  //String destFile = System.getProperty("user.dir")+
			//"/Automationproject/ScreenShot.png";
	  File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	  //captureScreenshot(sourceFile, destFile);
	  Files.copy(sourceFile,new File("C:\\Users\\Nishikant Kshirsagar\\eclipse-workspace\\Automationproject\\ScreenShot\\error.jpg"));
	  
	
	  driver.quit();
	}

	


}
