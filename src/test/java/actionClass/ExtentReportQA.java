package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportQA 
{
	private static WebDriver driver = null;
	static String expectedTitleebay = "Electronics,Cars,Fashion,Collectibles & More | eBay";
	
	public static void main(String[] argu) throws InterruptedException
	{
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/resources"+"/ExtentReport.html");
				
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("ebay Search Test","test to validate search box ");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test1.log(Status.INFO,"Starting test case");
		driver.manage().window().maximize();
		test1.pass("Maxmize has done");
		
		driver.get("https://www.ebay.com");
		Thread.sleep(2000);
		test1.pass("Navigate to Ebay.com");
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitleebay);
		test1.pass("title is correct");
		
		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Mobail");
		test1.pass("Entered text in text box");
		driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));
		test1.pass("Press keybopard enter key");
		
		driver.close();
		
		test1.pass("closed the browser");
		test1.pass("test completed");
		
		
		extent.flush();
		
	}

}
