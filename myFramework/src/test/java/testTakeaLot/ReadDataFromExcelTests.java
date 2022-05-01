package testTakeaLot;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ReadDataFromExcelTests {
	
	//Instantiate the class
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider="Brand & Quantity")
	public void BrandQuantity(String brand, String quantity) {
		System.out.println(brand + " " + quantity);
		int quantityInt = Integer.parseInt(quantity);
		System.out.println("Transformed to int " + quantityInt);
	}
	
	@Test(dataProvider="Brand & Quantity")
	public void BrandQuantityInt(String brand, int quantity) {
		System.out.println(brand + " " + quantity);
	}
	
	@DataProvider(name = "Brand & Quantity")
	public Object[][] getDataFromExcel() throws IOException{
		String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = rExcel.getExcelData(excelDirectory +"Brand&Quantity.xlsx", "Sheet1");
		return errObj;
	}

}
