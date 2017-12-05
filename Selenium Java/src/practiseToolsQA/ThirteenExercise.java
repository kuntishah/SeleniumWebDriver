package practiseToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirteenExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		WebElement iframe1 = driver.findElement(By.id("IF1"));
		WebElement iframe2 = driver.findElement(By.id("IF2"));
		
		driver.switchTo().frame(iframe1);
		
		driver.findElement(By.name("firstname")).sendKeys("first");
		driver.findElement(By.name("lastname")).sendKeys("last");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframe2);
		
		driver.findElement(By.xpath("//img[@class='alignnone size-medium wp-image-225']")).click();
		driver.switchTo().defaultContent();
		driver.close();
		driver.quit();

	}

}
