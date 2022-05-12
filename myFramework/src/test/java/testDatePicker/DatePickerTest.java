package testDatePicker;

import org.testng.annotations.Test;

import pageObjectsDatePicker.DatePickerPage;

public class DatePickerTest {
	
	//Create an object of the Date Picker Page
	DatePickerPage dpPg = new DatePickerPage();
	
	//Initialise Variables 
	String desiredDateTime = "11/8/2037 4:00 PM";
	
	@Test
	public void datePickerTest1()throws InterruptedException {
		dpPg.selectDateFromDatePicker(desiredDateTime);

	}
	
	@Test
	public void enterdateTimeTest() {
		dpPg.enterDateTime(desiredDateTime);
	}
}
