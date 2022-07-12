package com.MyTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.mypages.BasePage;

/**
 * @author sambasivarao
 *
 */
public class ExcelDataConfig extends BasePage {

static Sheet sheet;
	public ExcelDataConfig(WebDriver driver) {
		super(driver);
	}

	@SuppressWarnings("resource")
	public static Object[][] ExcelData(String sheetName) throws IOException{

		FileInputStream fs = new FileInputStream("C:\\Users\\sambasivarao\\Desktop\\Selenium\\ExcelData\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			//Row row = sheet.getRow(i);
			//Create a loop to print cell values in a row
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				//Print Excel data in console
				//System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	/*
		 * Row row = sheet.getRow(0); Cell cell = row.getCell(0);
		 * System.out.println(sheet.getRow(0).getCell(0));
		 */
	}
	
}
		return data;
		}
	}


