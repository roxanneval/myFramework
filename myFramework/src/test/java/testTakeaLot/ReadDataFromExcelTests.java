package testTakeaLot;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


import org.testng.annotations.Test;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import frameWorkClasses.GetSheetData;


public class ReadDataFromExcelTests {
	
//	GetSheetData rExcel = new GetSheetData();
	
//	@Test(dataProvider="Brand&Quantity")
//	public void BrandQuantitySting(String brand, String quantity) {
//		System.out.println(brand + " " + quantity);
//	}
	
//	@DataProvider(name = "Brand&Quantity")
//	public Object[][] getDataFromExcel(){
//		String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
//		Object[][] errObj = rExcel.getData(excelDirectory +"BrandANDQuantity.xlsx", "Sheet1"); 
//		return errObj;
//	}
	
//	@Test
//    public void getData() throws IOException, GeneralSecurityException {
//        GetSheetData sheetAPI = new GetSheetData();
//        List<List<Object>> values = GetSheetData.getData("Sheet1!A1:B3");
//        System.out.println(values);
//    }
	
	@Test
	public void getData(String getData){
		System.out.println(getData);
	}
}