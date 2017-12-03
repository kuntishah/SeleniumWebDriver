package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Select date 27 February 2018 in MakeMyTrip website
public class CalendarMakeMyTrip {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://us.makemytrip.com/");

		// click date picker
		driver.findElement(By.xpath("//*[@id='top_content']/div[2]/div[2]/div[2]/div[1]/div[7]/span/span[2]/a"))
				.click();

		// pick the year - current or later
		while (!driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")).getText()
				.equalsIgnoreCase("2018")) {
			if (driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText()
					.equalsIgnoreCase("2018")) {
				break;
			} else if (driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/div/span[2]")).getText()
					.equalsIgnoreCase("2018")) {
				break;
			}
			driver.findElement(By.cssSelector("[class = 'ui-icon ui-icon-circle-triangle-e']")).click();
		}

		int side = 0; // 0 is left, 1 is middle and 2 is right

		// pick the month
		// if while condition is true (false before negation) then go inside
		// while loop
		// while going in checking the ui-corner-left
		while (!driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText()
				.equalsIgnoreCase("February")) {
			// check middle
			if (driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText()
					.equalsIgnoreCase("February")) {
				side = 1;
				break;
			} else {
				// check ui-corner-right
				if (driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/div/span[1]")).getText()
						.equalsIgnoreCase("February")) {
					side = 2;
					break;
				}
			}
			driver.findElement(By.cssSelector("[class = 'ui-icon ui-icon-circle-triangle-e']")).click();
			side = 0;
		}

		// pick the date
		WebElement path = null;
		// take the path for the section - left/middle/right
		if (side == 0) {

			path = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]"));
		} else if (side == 1) {
			path = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]"));

		} else if (side == 2) {
			path = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]"));
		}

		int noOfDays = path.findElements(By.className("ui-state-default")).size();

		// Select the date
		for (int i = 0; i < noOfDays; i++) {

			if (path.findElements(By.className("ui-state-default")).get(i).getText().equalsIgnoreCase("27")) {
				path.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
		}
		
		driver.quit();
	}
}
