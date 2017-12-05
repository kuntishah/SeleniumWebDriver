package practiseToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FourteenExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/samples/05_drag_n_drop/05_pro_drag_ext.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement toDrag = driver.findElement(By.xpath("//*[@id='treeboxbox_tree']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[4]/span"));
	
		WebElement underDrop = driver.findElement(By.xpath("//*[@id='treeboxbox_tree2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
	
		
		
		System.out.println("done");
	
	
		WebElement From = driver.findElement(By.xpath("//*[@id='treeboxbox_tree']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[4]/span"));
		 
		WebElement To = driver.findElement(By.xpath("//*[@id='treeboxbox_tree2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		Actions builder = new Actions(driver);
		 
		Action dragAndDrop = builder.clickAndHold(From)
		 
		.moveToElement(To)
		 
		.release(To)
		 
		.build();
		 
		dragAndDrop.perform();
		
		System.out.println("done");

	}

}
