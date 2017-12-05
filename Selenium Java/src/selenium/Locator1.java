package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Locator techniques
public class Locator1 {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("http://facebook.com");

		driver.findElement(By.id("email")).sendKeys("abcd");
		// driver.findElement(By.className("uiButton")).click();

		driver.findElement(By.linkText("Forgot account?")).click();
		// driver.findElement(By.partialLinkText("Forgot ")).click();

		// driver.findElement(By.name("pass")).sendKeys("1234");
		// driver.findElement(By.id("u_0_q")).click();

		// number of links present in page
		// List<WebElement> webelement = driver.findElements(By.tagName("a"));
		// System.out.println(webelement.size());

		driver.quit();
	}

}
