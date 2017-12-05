package practiseToolsQA;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TwelveExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		String mainWindowHandle = driver.getWindowHandle();
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("alert"))));
				
		driver.findElement(By.id("alert")).sendKeys(Keys.RETURN);
		
		
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		driver.close();
		driver.quit();
		
		
	}

}
