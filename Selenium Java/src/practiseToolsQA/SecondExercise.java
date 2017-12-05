package practiseToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondExercise {
	
public static void main(String[] args){
	
	System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demoqa.com");
	driver.findElement(By.xpath("//a[@href='http://demoqa.com/registration/']")).click();
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.close();
	
}

}
