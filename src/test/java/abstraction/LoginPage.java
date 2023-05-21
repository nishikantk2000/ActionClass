package abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 
	WebDriver driver;

	public LoginPage(WebDriver driver ) {
		this.driver = driver;
	}
   By userName = By.id("username");
   By password = By.id("Password");
   By loginButton = By.id("Login");
   
   public void enterUserName(String userNameValue) {
	   
   }
   public void enterPassword(String passwordValue) {
	   
   }
   public void clickloginButton() {
	   
   }
} 
 

