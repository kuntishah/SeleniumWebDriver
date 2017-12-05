package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowsDemo {
	public static void main(String[] args) {

		// Set up browser
		WebDriver driver = new SafariDriver();

		// go to url
		driver.get("https://accounts.google.com/signup");

		// ****USE WEBDRIVERWAIT

		WebDriverWait waits = new WebDriverWait(driver, 5);
		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a")));

		System.out.println("Parent title " + driver.getTitle());

		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();

		Set<String> ids = driver.getWindowHandles();

		Iterator<String> idIter = ids.iterator();

		String parentId = idIter.next();

		String childId = idIter.next();

		driver.switchTo().window(childId);

		waits = new WebDriverWait(driver, 5);

		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gb']/div[2]/div[3]/div/a")));
		System.out.println("Child title " + driver.getTitle());

		driver.quit();

	}

}
