//package frameWorkClasses;
//
//import java.io.FileInputStream;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ReadExcel extends BasePage {
//
//	public String[][] getExcelData(String filename, String sheetName){
//	String[][] data = null;	
//	try {
//		/*
//		 * Java fileInputStream class obtains input bytes from a file. It is used for reading byte-oriented data (streams of raw bytes),
//		 * such as image data, audio, video etc. You can also read Character-Stream data. But, f or reading streams of characters, 
//		 * it is recommended to use FileReader class.
//		 */
//		FileInputStream fis = new FileInputStream (filename);
//		/*
//		 * High level representation of a spreadsheet workbook. This is the first object most users will construct whether they are reading
//		 * or writing a workbook. It is also the top level object for creating a new sheet/ect.
//		 */
//		XSSFWorkbook wb = XSSFWorkbook(fis);
//		XSSFSheet sh = wb.getSheet(sheetName);
//		DataFormatter formatter = new DataFormatter();
//		XSSFRow row = sh.getRow(0);
//		int noOfRows = sh.getPhysicalNumberOfRows();
//		int noOfCols = row.getLastCellNum();
//		//High Level representation of a cell in a row of a spreadsheet.
//		
//		data = new String [noOfRows -1][noOfCols];
//		for (int i = 1; i < noOfRows; i++) {
//			for (int j = 0; j < noOfCols; j++) {
//		//FormatCellvalue (Cell cell)
//		//Returns the formatted values of a cell as a String regardless of the cell type.
//				data[i - 1][j] = formatter.formatCellValue(sh.getRow(i).getCell(j));
//				//System.out.println(data[i - 1][j]);
//			}
//		}
//	}
//	catch (Exception e) {
//		System.out.println("The exception is: " + e.getMessage());
//	}
//	return data;
//	}
//
//	private XSSFWorkbook XSSFWorkbook(FileInputStream fis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
//
//
