package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Go into the frame and drag and drop an element from source to target.
//Use Actions class to perform drag and drop operation
public class framesDemo {

	public static void main(String[] args) {

		//Set up browser
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//go to url
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//can also say - driver.switchTo.frame(0); - this switches to first frame
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(source, target).build().perform();
		
		//to come back outside frame
		driver.switchTo().defaultContent();
		
		driver.quit();
	}

}
