package practiseToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
        driver.findElement(By.partialLinkText("Partial")).click();
    	String sClass = driver.findElements(By.tagName("button")).toString();
		System.out.println(sClass);
        driver.findElement(By.linkText("Link Test")).click();
        driver.close();
        
	}

}
