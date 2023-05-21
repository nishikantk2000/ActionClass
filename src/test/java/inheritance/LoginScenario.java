package inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginScenario extends Baseclass {


	@Test(description = "Vaild login Scenarios")
	public void logintoApp() {
		WebElement user =driver.findElement(By.name("username"));
		user.sendKeys("Admin");
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement button =driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();	
		}

}
