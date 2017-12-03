package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		/*
		 * //html alerts driver.get("https://www.goindigo.in/");
		 * driver.findElement(By.xpath("//*[@class='one-way-tab bw-trip-tabs']")
		 * ).click(); driver.manage().timeouts().implicitlyWait(10,
		 * TimeUnit.SECONDS);
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[@id='globalModal']/div/div/div[3]/button")).click();
		 */

		// Javascript alerts
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");

		/*
		 * //simple alert Ok or jus dismiss it
		 * driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click(
		 * ); driver.switchTo().alert().accept();
		 * driver.switchTo().defaultContent();
		 */

		/*
		 * //confirm alert box - OK or Cancel or just dismiss it
		 * driver.findElement(By.xpath("//*[@id='content']/p[8]/button")).click(
		 * ); driver.switchTo().alert().accept();
		 * driver.switchTo().alert().dismiss();
		 * driver.switchTo().defaultContent();
		 */

		driver.findElement(By.xpath("//*[@id='content']/p[11]/button")).click();
		// driver.switchTo().alert().sendKeys("Yes");
		// driver.switchTo().alert().sendKeys("No");
		System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

		driver.close();

	}

}
