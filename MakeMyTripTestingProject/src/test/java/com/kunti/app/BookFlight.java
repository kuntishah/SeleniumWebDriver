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
			driver.manage().window().maximize();
			HomePageMethods hp = new HomePageMethods(driver);
			log.info("CLick on flight tab");
			hp.clickBookFlight();
			
			log.info("CLick on one way/round trip/multicity ");

			if (way.contains("One")) {
				hp.clickOneWayButton();;
			} else if (way.contains("Round")) {
				hp.clickRoundTripButton();

			} else if (way.contains("Multi")) {
				hp.clickMultiCityButton();

			}
			
			log.info("Enter from place");
			hp.clickFromInputBox();
			hp.clearFromInputBox();
			hp.sendKeysFromInputBox(from);
			hp.sendKeysFromInputBox(Keys.RETURN);
			log.info("Enter to place");
			
			hp.clickToInputBox();
			hp.clearToInputBox();
			hp.sendKeysToInputBox(to);
		
			String month = fromDt.substring(0, fromDt.indexOf(" "));
			String date = fromDt.substring(fromDt.indexOf(" ") + 1, fromDt.indexOf(","));
			String year = fromDt.substring(fromDt.indexOf(",") + 1);

			hp.fromDatePicker(date, month, year);
			
			if(way.contains("Round"))
			{
				month = toDt.substring(0, toDt.indexOf(" "));
				date = toDt.substring(toDt.indexOf(" ") + 1, toDt.indexOf(","));
				year = toDt.substring(toDt.indexOf(",") + 1);

				hp.toDatePicker(date,month,year);
			}
			
			hp.clickPassengerDropdown();
			
			hp.clickNoAdults(adultPass);
			hp.clickNoChildren(childPass);
			hp.clickNoInfants(infantPass);

			

			hp.clickDonePassengerDropdown();

			hp.clickClassOfFlight();
					

			hp.clickClassBtn(flightCls);

			hp.clickSearchFlightButton();

			Assert.assertEquals(driver.getTitle(), result);
		} // if driver null

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
		driver.quit();
	}

}
