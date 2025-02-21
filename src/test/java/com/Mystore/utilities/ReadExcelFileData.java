package com.Mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileData {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getStringcellvalue(String fileName, String sheetname,int rownum, int cellnum) {
		try {
			FileInputStream inputstream=new FileInputStream(fileName);
			workbook=new XSSFWorkbook(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);
		cell=   workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		return cell.getStringCellValue();
	}




	public static int Rowcount(String fileName, String sheetname) {

		try 
		{

			FileInputStream inputstream = new FileInputStream(fileName);

			workbook=new XSSFWorkbook(inputstream);


			sheet=workbook.getSheet(sheetname);
			int row=sheet.getLastRowNum()+1;
			return row;
		}
		catch (Exception e)
		{
			e.printStackTrace();
  
			return 0; 
		}
	}

	public static int cellCount(String fileName , String sheetName) {
		try
		{

			FileInputStream inputstream = new FileInputStream(fileName);

			workbook=new XSSFWorkbook(inputstream);


			sheet=workbook.getSheet(sheetName);
			int row=sheet.getLastRowNum()+1;
			int cell=sheet.getRow(0).getLastCellNum();
			return cell;
		}
		catch (Exception e) {

			return 0;
		}
	}

}




