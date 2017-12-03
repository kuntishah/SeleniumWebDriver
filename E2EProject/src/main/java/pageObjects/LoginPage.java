package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Login page of the website
public class LoginPage {

	WebDriver driver;

	By emailID = By.id("user_email");
	By pwd = By.id("user_password");

	By loginButton = By.xpath("//*[@id='new_user']/div[3]/input");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInputText() {
		return driver.findElement(emailID);
	}

	public WebElement getPwdInputText() {
		return driver.findElement(pwd);
	}

	public WebElement getLoginButon() {
		return driver.findElement(loginButton);
	}
}
