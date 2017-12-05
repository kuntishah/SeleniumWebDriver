package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Code to access HTML table
public class AccessTableData {

	public static void main(String[] args) {

		// Set up browser
		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Go to URL
		driver.get(
				"http://www.espncricinfo.com/series/18037/game/1120289/Pakistan-vs-Sri-Lanka-4th-ODI-sl-in-uae-and-pak-2017-18-2017-18/");

		// Access the table
		WebElement table = driver
				.findElement(By.xpath("//*[@id='main-container']/div/div[2]/div[2]/article[1]/div/table"));

		// Access the rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		System.out.println("Number of rows: " + rows.size());

		// Access the cell values in the row
		for (WebElement row : rows) {

			List<WebElement> columnsPerRow = row.findElements(By.tagName("td"));

			System.out.println("");

			for (WebElement column : columnsPerRow) {

				System.out.print(column.getText() + "\t");
			}
		}

		driver.quit();

	}

}
