package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public static XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File file = new File("./ExcelSheet/Data.xlsx");
		
		try
		{
		
		FileInputStream fis = new FileInputStream(file);
		
		wb = new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("Requested excel sheet is not found: " + e.getMessage());
		}
	}
	
	public static String getStringData(int sheetIndex, int rownum, int cellnum)
	{
		return wb.getSheetAt(sheetIndex).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	
	public static double getIntData(int sheetIndex, int rownum, int cellnum)
	{
		return wb.getSheetAt(sheetIndex).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}

}
