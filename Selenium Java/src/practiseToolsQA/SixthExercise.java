package practiseToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SixthExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		WebElement forDropdown = driver.findElement(By.id("continents"));
		Select sel = new Select(forDropdown);
		
		boolean isItMultiple = sel.isMultiple();
		System.out.println("Selection is multiple ? "+ isItMultiple);
		sel.selectByIndex(1);
		sel.selectByVisibleText("Africa");
		
		List<WebElement> listSel = sel.getAllSelectedOptions();
		
		for(WebElement w:listSel){
		System.out.println(w.getText());
		}
		
		sel.selectByVisibleText("North America");
		
		
		
		driver.close();
	}

}
