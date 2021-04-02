package projectXL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TableXL {
	private static XSSFWorkbook wb;
	protected static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	// public static final String excelFilePath =
	// "C:\\Users\\Leona\\Desktop\\MyExcelData";

	public void setExcelFile(String excelFile, String sheetName) throws IOException {
		// Create an object of File class to open xlsx file
		File file = new File("C:\\Users\\Leona\\Desktop\\MyExcelData.xlsx");
		// Create an object of File InputStream class to read xlsx file
		FileInputStream inputStream = new FileInputStream(file);
		// creating workbook instance that refers to .xlsx file
		wb = new XSSFWorkbook(inputStream);
		// creating a Sheet object
		sheet = wb.getSheet(sheetName);

	}

	public String getCellData(int rowNumber, int cellNumber) {

		cell = sheet.getRow(rowNumber).getCell(cellNumber); // returning the cell value as string

		return cell.getStringCellValue();
	}



	public int cellCount(int rowNum) {
		int cellcount = sheet.getRow(rowNum).getLastCellNum();
		return cellcount;

	}
}

