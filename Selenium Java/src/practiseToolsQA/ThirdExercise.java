package practiseToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
driver.findElement(By.name("firstname")).sendKeys("abcd");
driver.findElement(By.name("lastname")).sendKeys("xas");;
driver.findElement(By.id("submit")).click();
driver.close();
	}

}
