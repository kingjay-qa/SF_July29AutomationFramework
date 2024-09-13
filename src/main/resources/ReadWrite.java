package seleniumautomationframeworkjuly29;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ReadWrite {

	public static void main(String[] args) throws IOException{
		String path = new System.getProperty("user.dir"+"/src/main/resources/Demo.xlsx");
		XSSFWorkbook studata = new XSSFWorkbook(path);
		XSSFSheet sheet = studata.createSheet("Students");
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Serial Num");
		row.createCell(1).setCellValue("Name");
		
		row = sheet.createRow(1);
		
		row.createCell(0).setCellValue("1");
		row.createCell(1).setCellValue("Jay");
		
		FileOutputStream fr = new FileOutputStream(path);
		studata.write(fr);
		studata.close();
	}

}
