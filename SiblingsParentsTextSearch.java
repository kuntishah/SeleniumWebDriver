package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Search for siblings / parent
public class SiblingsParentsTextSearch {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.gecko.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();

		// go to url
		driver.get("http://www.qaclickacademy.com/interview.php");

		// Find Siblings of child
		// It will find the first sibling and then navigate to the immediate
		// sibling after it
		// Will click Selenium
		// driver.findElement(By.xpath("//*[@id =
		// 'tablist1-tab1']/following-sibling::li[1]")).click();
		// Will click Soap UI - navigates to second sibling under it
		// driver.findElement(By.xpath("//*[@id =
		// 'tablist1-tab1']/following-sibling::li[2]")).click();

		// Find parent of child
		// Will print out role of ul parent
		System.out.println(driver.findElement(By.xpath("//*[@id = 'tablist1-tab1']/parent::ul")).getAttribute("role"));

		// Search element by text only
		// Do not use this method unless no other way is possible
		// driver.findElement(By.xpath("//*[text() = ' Selenium ']")).click();

		driver.quit();
	}

}
