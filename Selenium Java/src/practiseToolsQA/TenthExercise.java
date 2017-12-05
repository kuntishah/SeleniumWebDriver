package practiseToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class TenthExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(5, TimeUnit.SECONDS);
		
		
		Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>(){

			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				
				WebElement button = arg0.findElement(By.id("colorVar"));
				String col = button.getAttribute("style");
				System.out.println(col);
				if(col.contains("red")){
					return true;
				}
				return false;
			}
			
		};
		
		wait.until(function);
		
		driver.close();
		driver.quit();
	}

}
