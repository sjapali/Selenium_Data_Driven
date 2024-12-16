package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP002 {
	@DataProvider(name="fbreg2")
	public String[][] getData() throws IOException {
		
		String[][] data = null;
		
		FileInputStream file = new FileInputStream("./testData/TC002.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet  = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("rowcount " +rowCount +" column count: " +columnCount);
		data = new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);			
			for(int j=0;j<columnCount;j++)
			{
				System.out.println("i : " +i +"j :" +j);
				String celldata = row.getCell(j).getStringCellValue();
				System.out.println("celldata : " +celldata);
				data[i-1][j] = celldata;
				System.out.println("data from xcel is " +data[i-1][j]);
			}
			
		}
		
		return data;
	}
	

}
