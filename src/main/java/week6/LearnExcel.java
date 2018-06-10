package week6;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public Object[][] readExcel() throws IOException, InvalidFormatException {
		/*FileInputStream fis = new FileInputStream(new File("./data/Login_Data.xlsx"));
		XSSFWorkbook book = new XSSFWorkbook(fis);*/
		//Workbook accepts either a file or fileInputStream as argument. So the below line is also correct.
		XSSFWorkbook book = new XSSFWorkbook(new File("./data/CreateLead.xlsx"));
		
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount);
		System.out.println("Cell Count is : " + columnCount);
		Object[][] data = new Object[rowCount][columnCount];
		//The iteration starts with 1, since the first row is header.
		for(int i = 1; i <= rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);			
			for(int j = 0; j < columnCount; j++)
			{
				String value = row.getCell(j).getStringCellValue();
				data[i-1][j] = value;
				System.out.println(value);
			}
		}
		book.close();
		return data;

	}

}
