package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//The first page of the website
public class LandingPage {

	public WebDriver driver;
	By signin = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
	By featuredCourses = By.xpath("//*[@id='content']/div/div/h2");
	By navBar = By.xpath("//div[@class='navbar-header']");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getFeaturedCourses() {
		return driver.findElement(featuredCourses);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
