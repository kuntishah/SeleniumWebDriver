package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public void loadProperties() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/kuntishah/Desktop/SeleniumRelatedFiles/SeleniumWebDriver/MakeMyTripTestingProject/src/main/java/resources/data.properties");
		prop.load(fis);
	}
	
	public WebDriver setUpBrowser() throws IOException{
		
		
		if (prop.getProperty("browser").contains("firefox")){
			log.info("Setting firefox driver");
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
			driver = new FirefoxDriver();
		}else if(prop.getProperty("browser").contains("chrome")){
			log.info("Setting chrome driver");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
			
		}else if(prop.getProperty("browser").contains("safari")){
			log.info("Setting safari driver");

			driver = new SafariDriver();
		}
		
		
		return driver;
	}
	
	

}
