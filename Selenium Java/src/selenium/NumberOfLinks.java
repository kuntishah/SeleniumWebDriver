package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

		System.out.println(driver.findElement(By.tagName("a")));

		driver.quit();
	}
}
