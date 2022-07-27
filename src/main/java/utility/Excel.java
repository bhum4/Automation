package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static String getData (String Sheetname , int Row , int Cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream File = new FileInputStream("D:\\EmpDetails.xlsx");
		
		String Value = WorkbookFactory.create(File).getSheet(Sheetname).getRow(Row).getCell(Cell).getStringCellValue();
		
		return Value ;
		
	}

}
