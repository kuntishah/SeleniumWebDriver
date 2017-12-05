package practiseToolsQA;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NinethExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.findElement(By.id("timingAlert")).click();
		
		Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
				
		alert.accept();
		
		driver.close();
		driver.quit();
		
		
	}

}
