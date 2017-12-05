package practiseToolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstExercise {

	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://store.demoqa.com/");
	
	String pageTitle = driver.getTitle();
	int pageTitleLength = pageTitle.length();
	
	System.out.println(pageTitle + " " + pageTitleLength);
	
	if(driver.getCurrentUrl().equals("http://store.demoqa.com")){
		System.out.println("Current URL is as expected url");
	}else{
		System.out.println("Current URL is NOT as expected url");

	}
	
	String pageSource = driver.getPageSource();
	int pageSourceLength = pageSource.length();
	
	System.out.println("Page Length "+pageSourceLength);
	
	driver.close();
	
	
	}	
	
}
