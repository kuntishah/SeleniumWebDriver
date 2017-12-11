package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;



public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	private static Logger log = LogManager.getLogger(base.class.getName());

	//initialise the driver to browser - chrome, firefox, ie or safari
	public WebDriver initializer() throws IOException{
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/****/E2EProject/src/main/java/resources/data.properties");
		prop.load(fis);
		log.info("Data.properties file loaded");

		String browser = prop.getProperty("browser");
		log.info("Browser value retrieved from properties file");

		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();
			log.info("Chrome driver assigned");

		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriver"));
			driver = new FirefoxDriver();
			log.info("Firefox driver assigned");

		}
		else if(browser.equalsIgnoreCase("IE")){
			//Internet Explorer works only on windows
			System.setProperty("webdriver.ie.driver",prop.getProperty("ieDriver"));
			driver = new InternetExplorerDriver();
			log.info("InternetExplorer driver assigned");

		}
		else if(browser.equalsIgnoreCase("Safari")){
			//Safari driver works only in Mac
			driver = new SafariDriver();
			log.info("Safari driver assigned");

		}
		else{
			log.error("Browser value is incorrect");
			
		}
	
		return driver;			
	}
	
	public void takeScreenshot(String result) throws IOException{
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
	    FileUtils.copyFile(srcFile, new File("/Users/kuntishah/E2EProject/screenshots/"+result+"Screenshots.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
