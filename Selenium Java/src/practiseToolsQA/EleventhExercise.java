package practiseToolsQA;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EleventhExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String firstWindowHandle = driver.getWindowHandle();
		System.out.println(firstWindowHandle);

		WebElement button = driver.findElement(By.xpath("//div[@id='content']/p[3]/button"));
		
		button.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();   
		int setSize = windowHandles.size();
		
		for(int i =0;i<setSize;i++){
				String wd =iterator.next();
			
				if(wd!=firstWindowHandle){
				driver.switchTo().window(wd);
				System.out.println(wd);
				
				}
			
		}
		
		driver.close();
		driver.switchTo().window(firstWindowHandle);
		driver.close();
		driver.quit();
	}

}
