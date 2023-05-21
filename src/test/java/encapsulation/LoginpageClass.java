package encapsulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageClass {
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	private WebDriver driver;
	public LoginpageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getusername() {
		
		return username;
	}
	public WebElement getpassword() {
		return password;
	}
	public WebElement getloginbutton() {
		return loginButton;
	}
	public String getpage() {
		driver.get("url");
		return url;
	}

}
