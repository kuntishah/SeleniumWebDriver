package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Code to select from static dropdown, dynamic dropdown and checkbox.
public class Dropdown {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("http://book.spicejet.com");

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * //Static dropdowns
		 * 
		 * Select adult = new Select(driver.findElement(By.id(
		 * "ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"
		 * ))); //Select option by Value adult.selectByValue("5"); Select child
		 * = new Select(driver.findElement(By.id(
		 * "ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD"
		 * ))); //Select option by Index child.selectByIndex(2); Select infant =
		 * new Select(driver.findElement(By.id(
		 * "ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_INFANT"
		 * ))); //Select option by Visible Text
		 * infant.selectByVisibleText("3 Infants");
		 */

		/*
		 * //dynamic dropdowns driver.findElement(By.xpath(
		 * "//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']"
		 * )).click(); //For this website the set of cities is written once only
		 * //The same set is used by Leaving from and Going to fields
		 * //Selecting for Leaving field
		 * driver.findElement(By.xpath("//a[@value='AMD']")).click(); // [2] is
		 * written because we want to select in Going to field and this should
		 * select the second time this city appears
		 * driver.findElement(By.xpath("(//a[@value='IXB'])[2]")).click();
		 */

		// Checkboxes
		// Check if the checkboxes is selected or not
		System.out.println(driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_Defense"))
				.isSelected());
		// Click the check box
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_Defense")).click();
		System.out.println(driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_Defense"))
				.isSelected());

		driver.quit();
	}
}
