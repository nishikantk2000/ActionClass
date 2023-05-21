package testNGclass;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT 
{ 
  WebDriver driver;
  @Test
  public void test1() 
  {
	// click on "Choose CV" button		
     //	    driver.findElement(By.xpath("//*[@id='registerThemeDefault']/div/div[4]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div/label/span")).click();
    //		driver.findElement(By.xpath("//*[@id='file-upload']")).click();
			driver.findElement(By.xpath("//label[@for='file-upload']")).click();
		
			
			//Enter file to upload using window's Open dialogue window
			try
			{
				Process p = Runtime.getRuntime().exec("E:\\CybersuccessSeleniumBatch05Aug21\\AutoIT\\FileUploadUsingLocalHTMLFile\\filetoupload.exe");
				int retValue = p.waitFor();
				System.out.println("retValue: " + retValue);
			} catch (Exception e)
			{
				System.out.println("File was not uploaded properly");
				e.printStackTrace();
			}
				
			// verify the uploaded filename
			                         
			String expFileName = "SampleFileToUpload.txt";

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = driver.findElement(By.xpath("//div[@class='message-box']"));
			String actFileName = wait.until(ExpectedConditions.visibilityOf(ele)).getText();

			
			System.out.println("expFileName: " + expFileName);
			System.out.println("actFileName: " + actFileName);
			Assert.assertTrue(expFileName.equals(actFileName), "Expected file : " + expFileName + " did not uploaded properly, act filename: " + actFileName);
		}
     @BeforeTest
     public void beforeMethod()
	 {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.monsterindia.com/seeker/registration?spl=IN-Acq-SEM-Google-Core_Brand_Old_BMM_Web_S-GSN-Core_Brand_Old-%2Bmonster-desktop-Brand---388396137523---CPC-6645446156&utm_campaign=IN_Acq_SEM-Google-Core_Brand_Old_BMM_Web_S-GSN-Core_Brand_Old-%2Bmonster-&utm_medium=SEM&utm_source=Google-GSN-CPC&utm_term=SEM_%2Bmonster&gclid=CjwKCAjw8KmLBhB8EiwAQbqNoC6kJ8TSNKOabGn59JegPBGPFv5h_qYAoyom5vp17qUnmWk7fLsT3xoCG2QQAvD_BwE");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
    @AfterTest
    public void afterTest() throws InterruptedException 
    {
		Thread.sleep(2000l);
		driver.quit();
		
	
    }

}
