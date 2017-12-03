package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Code to select an item in Dropdown
public class AutoSuggestiveDropdown {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://fantasycricket.dream11.com/in/");

		driver.findElement(By.xpath("//*[@id='m_rtxtEmail1']")).sendKeys("aa");

		// Explicit wait time
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='m_frmRegister']/div[1]/ul")));

		// Select 4th option from dropdown
		driver.findElement(By.xpath("//*[@id='m_frmRegister']/div[1]/ul/li[4]/p")).click();

		driver.quit();
	}

}
