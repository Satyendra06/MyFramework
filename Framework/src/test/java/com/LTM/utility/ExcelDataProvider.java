package com.LTM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ExcelDataProvider() throws IOException
	{
	File src= new File("./TestData/TestData.xlsx");
	FileInputStream fis= new FileInputStream(src);
	wb= new XSSFWorkbook(fis);
	}
	
	public String readExcelData(String sheetName, int row, int column)
	{
		sheet1=wb.getSheet(sheetName);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public int countRows(String sheetName)
	{
		int total_rows=wb.getSheet(sheetName).getLastRowNum();
		return total_rows;
	}
}

