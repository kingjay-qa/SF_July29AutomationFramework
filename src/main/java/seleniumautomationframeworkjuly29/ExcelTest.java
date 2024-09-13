package seleniumautomationframeworkjuly29;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ExcelTest {
	public static void main(String[] args) throws IOException{
	//  /seleniumautomationframeworkjuly29/src/main/java/seleniumautomationframeworkjuly29/ExcelTest.java
	//	Workbook wb = new XSSFWorkbook();
		String path = System.getProperty("user.dir")+ "/src/main/resources/Demo.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;
		
		for(int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				System.out.print(cell + " ");
			}
			System.out.println();
			
		}
		 
	}

	

}
