package abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageMethods{
  

    WebDriver driver;
public LoginPageMethods(WebDriver driver) {
		this.driver = driver;
		
	}
    By userName = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
	public void enterUserName(String userNameValue) {
		
		WebElement user = driver.findElement(userName);
				user.sendKeys(userNameValue);
	}
	public void enterPassword(String passwordValue) {
		
	 WebElement pass = driver.findElement(password);
			 pass.sendKeys(passwordValue);
		
	}
	public void clickLoginButton() {
		WebElement click=driver.findElement(loginButton);
				click.click();
	}
}
