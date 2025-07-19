package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./ConfigData/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
		
	}
	public int getRowCount(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
		{
		FileInputStream fis=new FileInputStream("./ConfigData/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheet).getLastRowNum();
		return rowcount;
	}

}
