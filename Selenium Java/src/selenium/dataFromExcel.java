package selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Get and set value in Excel
public class dataFromExcel {

	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell column;
	static FileOutputStream fos;
	static FileInputStream fis;

	public static void main(String[] args) throws IOException {

		String value = getCellData(1, 2);
		System.out.println(value);
		value = getCellData(0, 2);
		System.out.println(value);
		value = getCellData(2, 2);
		System.out.println(value);

		value = setCellData(3, 1, "automation");
		System.out.println(value);

	}

	//Get Cell data from Excel
	public static String getCellData(int rowno, int colno) throws IOException {
		
		fis = new FileInputStream("/Users/kuntishah/Desktop/SeleniumRelatedFiles/Seleniumtest.xlsx");
		//Access Excel Workbook
		wb = new XSSFWorkbook(fis);
		
		//Access the Sheet
		sheet = wb.getSheet("Sheet1");
		
		//Access the row
		row = sheet.getRow(rowno);
		
		//Access the column / cell value
		column = row.getCell(colno);
		
		//Get String value from the cell
		String sendValue = column.getStringCellValue();
		
		//Close the Excel
		fis.close();
		
		return sendValue;
	}

	//Set cell value in Excel
	public static String setCellData(int rowno, int colno, String setValue) throws IOException {

		fis = new FileInputStream("/Users/kuntishah/Desktop/SeleniumRelatedFiles/Seleniumtest.xlsx");
		
		//Access Excel Workbook
		wb = new XSSFWorkbook(fis);
		
		//Access the Sheet
		sheet = wb.getSheet("Sheet1");

		//Access the row
		row = sheet.getRow(rowno);
		if (row == null) {
			row = sheet.createRow(rowno);
		}
		
		//Access the column / cell value
		column = row.getCell(colno);

		if (column == null) {
			column = row.createCell(colno);
		}
		
		//Set value in column
		column.setCellValue(setValue);
		System.out.println("value set");
		String sendValue = column.getStringCellValue();

		//Close the Excel workbook
		fis.close();

		//Open the workbook in outputstream
		FileOutputStream outFile = new FileOutputStream(
				"/Users/kuntishah/Desktop/SeleniumRelatedFiles/Seleniumtest.xlsx");
		
		//Write to excel file
		wb.write(outFile);
		
		//Close the excel file
		outFile.close();

		return sendValue;
	}

}
