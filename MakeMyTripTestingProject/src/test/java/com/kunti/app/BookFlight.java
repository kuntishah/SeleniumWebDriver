package com.kunti.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class BookFlight extends base {

	public FileInputStream fisExcel;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	private static Logger log = LogManager.getLogger(BookFlight.class.getName());

	@BeforeTest
	public void initialise() throws IOException {
		log.info("Load Properties");
		loadProperties();
	}

	@BeforeMethod
	public void browserSet() throws IOException {
		log.info("Set up browser");
		driver = setUpBrowser();

	}

	@Test(dataProvider = "getTestData")
	public void bookFlight(String way, String from, String to, String fromDt, String toDt, String adultPass,
			String childPass, String infantPass, String flightCls,String result) {
		log.info("Inside book flight test");
		if (driver != null) {
			log.info("get url");
			driver.get(prop.getProperty("url"));
			MakeMyTripHomePage hp = new MakeMyTripHomePage(driver);
			log.info("CLick on flight tab");
			hp.findBookFlightTab().click();
			log.info("CLick on one way/round trip/multicity ");

			hp.findWayButton(way).click();
			log.info("Enter from place");

			hp.findFromInputBox().clear();

			hp.findFromInputBox().sendKeys(from);
			hp.findFromInputBox().sendKeys(Keys.RETURN);
			
			log.info("Enter flight tab");

			List<WebElement> dd = hp.findToInputBox().findElements(By.xpath("//ul[@id='ui-id-2']/li"));

			for (WebElement ele : dd) {

				if (ele.getText().contains(to)) {
					ele.click();
				}

			} // for
			
			String month = fromDt.substring(0, fromDt.indexOf(" "));
			String date = fromDt.substring(fromDt.indexOf(" ") + 1, fromDt.indexOf(","));
			String year = fromDt.substring(fromDt.indexOf(",") + 1);

			fromDatePicker(hp, date, month, year);
			
			if(way.contains("Round"))
			{
				month = toDt.substring(0, toDt.indexOf(" "));
				date = toDt.substring(toDt.indexOf(" ") + 1, toDt.indexOf(","));
				year = toDt.substring(toDt.indexOf(",") + 1);

				toDatePicker(hp,date,month,year);
			}
			hp.findPassengerDropdownButton().click();
			List<WebElement> noAdults = hp.findNoOfAdults().findElements(By.tagName("li"));
			noAdults.get(Integer.parseInt(adultPass) - 1).click();

			List<WebElement> noChildren = hp.findNoOfChildren().findElements(By.tagName("li"));
			noChildren.get(Integer.parseInt(childPass) - 1).click();

			List<WebElement> noInfants = hp.findNoOfInfants().findElements(By.tagName("li"));
			noInfants.get(Integer.parseInt(infantPass) - 1).click();

			hp.findPassengerDone().click();

			hp.findClassOfFlight().click();

			hp.findClassBtn(flightCls).click();

			hp.findsearchFlightButton().click();

			Assert.assertEquals(driver.getTitle(), result);
		} // if driver null

	}

	public void fromDatePicker(MakeMyTripHomePage hp_obj, String date, String month, String year) {

		// click date picker
		hp_obj.findDepartureDatePicker().click();

		// pick the year - current or later
		while (!driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[2]"))
				.getText().equalsIgnoreCase(year)) {
			if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/div/span[2]"))
					.getText().equalsIgnoreCase(year)) {
				break;
			}
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span")).click();
		}

		int side = 0; // 0 is left, 1 is right

		// pick the month
		// if while condition is true (false before negation) then go inside
		// while loop
		// while going in checking the ui-corner-left
		while (!driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[1]"))
				.getText().equalsIgnoreCase(month)) {
			// check right
			if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/div/span[1]"))
					.getText().equalsIgnoreCase(month)) {
				side = 1;
				break;
			}

			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span")).click();
			side = 0;
		}

		// pick the date
		WebElement path = null;
		// take the path for the section - left/right
		if (side == 0) {

			path = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/table"));
		} else if (side == 1) {
			path = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/table"));

		}

		List<WebElement> noOfDays = path.findElements(By.className("ui-state-default"));

		// Select the date
		for (WebElement day: noOfDays) {

			if (day.getText().equalsIgnoreCase(date)) {
				day.click();
				break;
			}
		}
	}
	
	public void toDatePicker(MakeMyTripHomePage hp_obj, String date, String month, String year) {

		// click date picker
		hp_obj.findDepartureDatePicker().click();

		// pick the year - current or later
		while (!driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/div/div/span[2]"))
				.getText().equalsIgnoreCase(year)) {
			if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/div/span[2]"))
					.getText().equalsIgnoreCase(year)) {
				break;
			}
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/a/span")).click();
		}

		int side = 0; // 0 is left, 1 is right

		// pick the month
		// if while condition is true (false before negation) then go inside
		// while loop
		// while going in checking the ui-corner-left
		while (!driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/div/div/span[1]"))
				.getText().equalsIgnoreCase(month)) {
			// check right
			if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/div/span[1]"))
					.getText().equalsIgnoreCase(month)) {
				side = 1;
				break;
			}

			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/a/span")).click();
			side = 0;
		}

		// pick the date
		WebElement path = null;
		// take the path for the section - left/right
		if (side == 0) {

			path = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/table"));
		} else if (side == 1) {
			path = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/table"));

		}

		List<WebElement> noOfDays = path.findElements(By.className("ui-state-default"));

		// Select the date
		for (WebElement day: noOfDays) {

			if (day.getText().equalsIgnoreCase(date)) {
				day.click();
				break;
			}
		}
	}

	@DataProvider
	public Object[][] getTestData() throws IOException {

		fisExcel = new FileInputStream(
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/SeleniumWebDriver/MakeMyTripTestingProject/src/main/java/resources/MakeMyTripInputData.xlsx");
		wb = new XSSFWorkbook(fisExcel);
		sheet = wb.getSheet("Sheet1");
		int rownum = Integer.parseInt(prop.getProperty("RowNumTotal"));
		int colnum = Integer.parseInt(prop.getProperty("excelEndColNum"));
		System.out.println(rownum + " " + colnum);
		String[][] data = new String[rownum][colnum];
		for (int i = Integer.parseInt(prop.getProperty("excelStartRowNum")),a=0; i <= Integer.parseInt(prop.getProperty("excelEndRowNum")); i++,a++) {
			for (int j = Integer.parseInt(prop.getProperty("excelStartColNum")),b=0; j <= colnum; j++,b++) {

				row = sheet.getRow(i);
				cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				System.out.println(cell.getStringCellValue());
				data[a][b] = cell.getStringCellValue();
			}

		}
		fisExcel.close();
		return data;

	}

	@AfterMethod
	public void teardown() {
		// driver.quit();
	}

}
