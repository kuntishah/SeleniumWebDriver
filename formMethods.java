package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//isDisplayed method
public class formMethods {

	public static void main(String[] args) {
		
		//Set up browser
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//go to url
		driver.get("https://makemytrip.com");
		
		//Checks if Return field is enabled - yes
		System.out.println(driver.findElement(By.xpath("//input[@id='hp-widget__return']")).isDisplayed());

		//Changes to One Way
		driver.findElement(By.xpath("//*[@id='js-switch__option']/div[3]/label")).click();
		
		//Checks if Return field is enabled - disabled because now the flight is one way
		System.out.println(driver.findElement(By.xpath("//input[@id='hp-widget__return']")).isDisplayed());
		
		driver.quit();
	}

}
