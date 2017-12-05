package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//How to set up different browsers
public class browser {

	public static void main(String[] args) {

		// Set up Firefox driver
		System.setProperty("webdriver.gecko.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();

		/*//Set up Google Chrome driver
		 * System.setProperty("webdriver.chrome.driver",
		 * "/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		 * WebDriver driver = new ChromeDriver();
		 */

		/*
		 * //Set up Internet Explorer browser - works only in Windows
		 * System.setProperty("webdriver.ie.driver",
		 * "/Users/kuntishah/Desktop/SeleniumRelatedFiles/internetexplorer/IEDriverServer.exe"); 
		 * WebDriver driver = new InternetExplorerDriver();
		 */

		/*
		 * //Set up Safari driver - works only in Mac OS WebDriver driver = new
		 * SafariDriver();
		 */

		driver.get("http://google.com");

		driver.quit();
	}

}
