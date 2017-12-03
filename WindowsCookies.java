package selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

//Code for cookies
public class WindowsCookies {

	public static void main(String[] args) {

		// WindowsUtils.tryToKillByName("notepad.exe");

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("http://google.com");

		// get cookies
		Set<Cookie> cook = driver.manage().getCookies();

		System.out.println("Before deleting number of cookies" + cook.size());

		// delete cookies
		driver.manage().deleteAllCookies();

		Set<Cookie> cook2 = driver.manage().getCookies();

		System.out.println("After deleting number of cookies" + cook2.size());

		driver.quit();
	}

}
