package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static String getUrl(String urlName) {
	String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestURLs.xlsx";
	File file = new File(filePath);
	FileInputStream fis =  null;
	XSSFWorkbook workbook = null;
	Map<String, String> obj = null;
	try {
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("PageUrls");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		obj =  new HashMap<String, String>();
		for(int i=1; i<=lastRowNum; i++) {
			for(int j=0; j<lastCellNum; j++) {
				if(j==0) {
					obj.put(sheet.getRow(i).getCell(j).getStringCellValue(), null);
					
				}else
				{
					obj.put(sheet.getRow(i).getCell(0).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
				}
			}
		}
		fis.close();
		workbook.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return obj.get(urlName);
	
	}
	public static Object[][] getTestDataFromExcel(String fileName,String sheetName) {
		String filePath = System.getProperty("user.dir")+ "\\src\\test\\resources\\"+fileName;
		File file = new File(filePath);
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		Object[][] data = null;
		try {
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		data = new Object[lastRowNum][lastCellNum];
		int rowCount=0;
		
		for(int i=1; i<=lastRowNum; i++) {
			int colCount = 0;
			for(int j=0; j<lastCellNum; j++) {
				data[rowCount][colCount]= sheet.getRow(i).getCell(j).getStringCellValue();
				colCount++;
			}
			rowCount++;
		}
		
		fis.close();
		workbook.close();
		 }
		catch(IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {
		Object[][] obj = getTestDataFromExcel("LoginTestData.xlsx", "ValidData");
		System.out.println(obj[0][0]);
	}
	
	
}
