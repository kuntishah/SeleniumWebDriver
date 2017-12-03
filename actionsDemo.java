package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Code to use Actions class for mouse events
public class actionsDemo {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Go to URL
		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);

		// hover over element
		a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();

		WebElement move = driver.findElement(By.id("twotabsearchtextbox"));

		// enter text in all capital letters
		a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

		move = driver.findElement(By.id("twotabsearchtextbox"));

		// select entire text - for eg. we wrote hello - select hello
		// we generally double click on the text and the text gets selected
		a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		move = driver.findElement(By.id("twotabsearchtextbox"));

		// right click on the element
		a.moveToElement(move).contextClick().build().perform();

		driver.quit();
	}

}
