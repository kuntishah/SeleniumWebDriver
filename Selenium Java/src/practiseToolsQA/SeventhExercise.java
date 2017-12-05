package practiseToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeventhExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		Select sel = new Select(driver.findElement(By.id("selenium_commands")));
		
		sel.selectByIndex(0);
		sel.deselectByIndex(0);
		
		sel.selectByVisibleText("Navigation Commands");
		sel.deselectByVisibleText("Navigation Commands");
		
		int selSize = sel.getOptions().size();
		
		List<WebElement> selOptions = sel.getOptions();
		
		for (WebElement opt: selOptions){
			
			sel.selectByVisibleText(opt.getText());
		}
		
		List<WebElement> selected = sel.getAllSelectedOptions();
		
		System.out.println("Options selected are:");
		for(WebElement opt: selected){
			System.out.println(opt.getText());
		}
		
		driver.close();
		
	}

}
