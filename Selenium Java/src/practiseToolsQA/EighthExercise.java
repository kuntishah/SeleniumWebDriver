package practiseToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EighthExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/kuntishah/Desktop/SeleniumRelatedFiles/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-table/");
		
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
		
		WebElement tableBody = table.findElement(By.tagName("tbody"));
		
		List<WebElement> tableTR = tableBody.findElements(By.tagName("tr"));
		
		int noOfRows = tableTR.size();
		int noOfCells = 0;
		
		for (int i=0;i<noOfRows;i++){
			
			//find no of cells for each row by finding out how many td tags are present in each tr
			List<WebElement> tableTD = tableTR.get(i).findElements(By.tagName("td"));
			noOfCells = tableTD.size();
			for (int j =0;j<noOfCells;j++){
				
				if(tableTD.get(j).getText().equals("Dubai")){
					
					System.out.println(i + ", " + j + " cell has value " + tableTD.get(j).getText());
					break;
					
				}	//if
			}//for j
			
		}//for i
		
		List<WebElement> firstRow = tableTR.get(1).findElements(By.tagName("td"));
		noOfCells = firstRow.size();
		
		for(WebElement cell :firstRow){
			
			if(cell.getText().equals("details")){
				cell.click();
				//url changes to http://toolsqa.com/automation-practice-table/#
				System.out.println(driver.getCurrentUrl());
				break;
			}//if
		}//for
		
		
		System.out.println("Columns in Clock Tower Hotel are:");
		
		for(int i =0;i<noOfRows;i++){
			
			WebElement thScope = tableTR.get(i).findElement(By.tagName("th"));
			if(thScope.getText().equals("Clock Tower Hotel")){
				
				List<WebElement>clockTowerRow = tableTR.get(i).findElements(By.tagName("td"));
				
				for(int j =0;j<clockTowerRow.size();j++){
					
					System.out.println(clockTowerRow.get(j).getText());
				}

			}
		}
		
		
		
		driver.close();
		driver.quit();
		
	}//main
	
	
		
	}//class


