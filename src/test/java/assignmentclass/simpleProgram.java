package assignmentclass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class simpleProgram {

	public static void main(String[] args) {
		String fileName = "C://Selenium//Config.properties.txt";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(fis); //load config.proeprties into a memory
			String url = (String) prop.get("url");
			System.out.println("url : " + url);
			String browserName = (String) prop.get("browser");
			String ss = prop.getProperty("searchString");
			System.out.println("Search String : " + ss);
			System.out.println("Browser Name: " + browserName);
			String timeout = prop.getProperty("timeout");
			System.out.println("timeout : " + (Integer.parseInt(timeout)+2));
		} catch (FileNotFoundException e) {
			System.out.println("File Does not exist : " + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File loading issue : " + fileName);
			e.printStackTrace();
		}
	}

}
