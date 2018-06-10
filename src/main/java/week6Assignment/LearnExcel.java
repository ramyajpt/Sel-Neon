package week6Assignment;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		/*FileInputStream fis = new FileInputStream(new File("./data/Login_Data.xlsx"));
		XSSFWorkbook book = new XSSFWorkbook(fis);*/
		//Workbook accepts either a file or fileInputStream as argument. So the below line is also correct.
		XSSFWorkbook book = new XSSFWorkbook(new File("./data/CreateLead.xlsx"));

		XSSFSheet sheet = book.getSheetAt(0);

		XSSFRow row = sheet.getRow(1);			

		String value = row.getCell(2).getStringCellValue();
		System.out.println(value);


		book.close();


	}

}
