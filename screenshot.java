package selenium;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//how to take screenshot 
public class screenshot {

	public static void main(String[] args) {


		//Set up browser
		System.setProperty("webdriver.chrome.driver", "/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//go to url
		driver.get("http://google.com");
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("/Users/kuntishah/Desktop/screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
