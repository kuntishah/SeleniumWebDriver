package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//How to find Element by CSS selector
// tagname[attribute='value']
// [attribute='value'] all tag with this attribute and value
// #IDVALUE
// .classname if the classname has space in between then replace space with dot EG: class name becomes .class.name

public class browser2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("abcd");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("1234");
		driver.findElement(By.cssSelector("#Login")).click();
		
		driver.quit();
	}

}
