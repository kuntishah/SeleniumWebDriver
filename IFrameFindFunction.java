package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//on the website click in the checkbox  I am not robot - it is in an iframe
//once you click another iframe opens
//click on verify in the new iframe
public class IFrameFindFunction {

	public static void main(String[] args) {

		//Set up browser
		WebDriver driver = new SafariDriver();
		
		//go to url
		driver.get("https://www.google.com/recaptcha/api2/demo");
		
		driver.manage().window().maximize();
		
		//Use javascript executor to scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		By by = By.xpath("//*[@id='recaptcha-anchor']/div[5]");
		
		//find the above By by in the frame number
		int frameNumber = findFrame(driver,by);
		System.out.println("No "+frameNumber);
		
		//if frame number found them frame number is 0 or more
		if (frameNumber>-1){
			
			//switch to the respective frame
			driver.switchTo().frame(frameNumber);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Click on the By by path 
			driver.findElement(by).click();
			
			driver.switchTo().defaultContent();

			by = By.xpath("//*[@id='recaptcha-verify-button']");
			
			int frameNumber2 = findFrame(driver,by);
			System.out.println("No "+frameNumber);
			
			if(frameNumber2>-1){
			    driver.switchTo().frame(frameNumber2);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.findElement(by).click();
			    driver.switchTo().defaultContent();
			}
			
		}else{ //if frame number is less than 0 then frame not found
			System.out.println("No iframe found");
		}
		
		driver.quit();
	}//main
	
	//find frame in the website for the path passed in By by
	static int findFrame(WebDriver driver, By by){
		
		System.out.println("inside find frame");
		int i = -1;
		
		//get count of iframes in the website
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameCount);
		
		//if count is > 0 
		if(frameCount > 0){
			
			//find in which frame the By by path is present
			for(i=0;i<frameCount;i++){
				
				driver.switchTo().frame(i);
				
				//if the By by path size is > 0 then path is present in the frame
				if(driver.findElements(by).size() > 0){
					driver.switchTo().defaultContent();

					break;
				}
				
				driver.switchTo().defaultContent();

			
			}//for loop
			
		}//if framecount
		
		WebDriverWait wd = new WebDriverWait(driver,5);
	
		return i;
		
		
	}
}
