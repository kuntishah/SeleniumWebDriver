package practiseToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FifthExercise {
	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://toolsqa.com/automation-practice-form/");
	
	List<WebElement> radioButtonSex = driver.findElements(By.name("sex"));
	
	boolean isIt = radioButtonSex.get(0).isSelected();
	
	if(isIt){
		radioButtonSex.get(1).click();
	}else{
		radioButtonSex.get(0).click();
	}
	
	List<WebElement> yearsOfExp = driver.findElements(By.cssSelector("\\input[name='tool']"));
	
	if(yearsOfExp.size() > 0){
	
	for(WebElement noOfYears : yearsOfExp){
		if (noOfYears.getAttribute("value").equals("3")){
			noOfYears.click();
		}
	}
	}
	List<WebElement> toolToUse = driver.findElements(By.name("tool"));
	if(toolToUse.size()>0){
	for(WebElement tool: toolToUse){
		if(tool.getAttribute("value").equals("Selenium IDE")){
			tool.click();
		}
	}
	}
	
	driver.close();
	}
}
