package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Click on calendar and select 23 April as the date.
//Write a generic program where we can change the date alone and the code
//still works and does not need code changes except for the date itself

public class CalendarPath2USA {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://www.path2usa.com/travel-companions");

		driver.findElement(By.xpath("//*[@id='travel_date']")).click();

		// driver.findElement(By.cssSelector("[class='datepicker-days']
		// [class='datepicker-switch']")).click();

		// select april month
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("April")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();

		}

		// select 23 date
		int noOfDays = driver.findElements(By.className("day")).size();

		for (int i = 0; i < noOfDays; i++) {
			if (driver.findElements(By.className("day")).get(i).getText().equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;

			}

		}
		
		driver.quit();

	}

}
