package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 
 * @author DELL
 *
 */


public class excelfile {

	
	
	
	Workbook wb = null;
	
	public String  fetchdatafromexcel(String sheetname,  int Rindex, int Cindex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_v1.xlsx");
		wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(Rindex).getCell(Cindex).toString();
		return data;
	}
	
	
	
	
	
	public void writebackdataFromExcelFile(String sheetname,  int Rindex, int Cindex,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_v1.xlsx");
		wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(Rindex).createCell(Cindex).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/vtiger_v1.xlsx");
		wb.write(fos);
		
		
		
	}
	
	
	public String fetchDatatoExcelFile_existingrow(String sheetname,  int Rindex, int Cindex,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_v1.xlsx");
		wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(Rindex).createCell(Cindex).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/vtiger_v1.xlsx");
		wb.write(fos);
		return data;
		
		
	}
	
	
	
	public void closeexcel() throws IOException {
		wb.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
