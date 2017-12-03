package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Use @Parameter for test. Parameter is set in TestNG
public class ParameterizationTests {

	WebDriver driver;

	@Parameters("browser")
	@Test
	public void mainTest(String browser) throws IOException {

		//Load Properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/kuntishah/E2EProject/src/main/java/resources/data.properties");
		prop.load(fis);
		
		//According to the value of the browser parameter passed set the browser
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriver"));
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
			// Internet Explorer works only on windows
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriver"));
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Safari")) {
			// Safari driver works only in Mac
			driver = new SafariDriver();

		}

		driver.get("http://google.com");

		driver.quit();
	}

}
