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

//	public int getRowCountInSheet() {
//		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		return rowcount;
//	}

	public int cellCount(int rowNum) {
		int cellcount = sheet.getRow(rowNum).getLastCellNum();
		return cellcount;

	}
}
//}
//}
//
//	public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
//		// creating a new cell in row and setting value to it
//		sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
//
//		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
//		wb.write(outputStream);
//	}

//		FileInputStream fi = new FileInputStream("C:\\Users\\Leona\\Desktop\\MyExcelData");
//		
//		XSSFWorkbook wb = new XSSFWorkbook(fi);
//		Sheet s = wb.getSheet("Sheet0");
//		Row r1 = s.getRow(0);
//		Row r2 = s.getRow(1);
//		Cell c1 = r1.getCell(0);
//		Cell c11 = r1.getCell(1);
//		Cell c2 = r1.getCell(0);
//		Cell c22 = r1.getCell(1);
//		
//}
