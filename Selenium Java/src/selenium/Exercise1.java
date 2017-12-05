package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Get count of number of links on the page ebay.com
//Get count of number of links in the footer section on the page ebay.com
public class Exercise1 {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://www.ebay.com/");

		System.out.print("Number of links on ebay.com: ");
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.print("\nNumber of links in the footer of ebay.com: ");

		WebElement footer = driver.findElement(By.id("glbfooter"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		System.out.print("\nNumber of links in the footer section 2nd column of ebay.com: ");
		WebElement col2 = footer.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		System.out.println(col2.findElements(By.tagName("a")).size());

		System.out.println("\nSite names under 2nd col in footer section:");

		String BeforeTitle = driver.getTitle();
		System.out.println("\nBefore Title: " + BeforeTitle);

		// We need to maximize the window because
		// Ebay with maximized screen has "Site map" as link text and
		// Ebay with minimized screen has "Site Map" as line text
		// We are searching for "Site map" and so we want maximized screen

		driver.manage().window().maximize();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3300)", "");

		Actions a = new Actions(driver);

		for (int i = 0; i < col2.findElements(By.tagName("a")).size(); i++) {
			System.out.println(col2.findElements(By.tagName("a")).get(i).getText());

			if (col2.findElements(By.tagName("a")).get(i).getText().equals("Site map")) {

				a.moveToElement(col2.findElements(By.tagName("a")).get(i)).click().build().perform();

				break;
			}

		}

		String AfterTitle = driver.getTitle();

		System.out.println("\nAfter Title: " + AfterTitle);

		if (BeforeTitle != AfterTitle && AfterTitle.equals("Sitemap | eBay")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");

		}

		driver.quit();

	}

}
