package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Radiobutton {
	public static void main(String[] args){
		
		//Set up browser
		System.setProperty("webdriver.gecko.driver", "/Users/kuntishah/Desktop/SeleniumRelatedFiles/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//go to url
		driver.get("http://echoecho.com/htmlforms10.htm");
		
		//get number of radio buttons in a section
		int s = driver.findElements(By.xpath("//input[@name='group1']")).size();
		System.out.println(s);
		
		//select a radio button
		driver.findElement(By.xpath("//input[@value='Cheese']")).click();;

		for(int i = 0 ; i <s ; i++){
			/*//by index select each radio button in a program
			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();*/
			
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			if (text == "Cheese"){
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}

		}
		driver.quit();
	}
}
