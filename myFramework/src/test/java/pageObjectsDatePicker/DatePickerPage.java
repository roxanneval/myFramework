package pageObjectsDatePicker;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class DatePickerPage extends BasePage {
	
	
	public void enterDateTime(String desiredDateTime) {
	String dateTimeSelector = "input#datetimepicker";
	clearText(By.cssSelector(dateTimeSelector));
	enterText(By.cssSelector(dateTimeSelector), desiredDateTime);
	}
	public void selectDateFromDatePicker (String desiredDateTime) throws InterruptedException {
		
		// example date "5/3/2022 3:40 PM"
		// extract the desired month 5
		// extract the desired day 3
		// extract the desired year
		// extract the desired time
		
		/*
		desiredDateTime = "5/3/2022 3:40 PM" (" ") - Space will split it
		[0]5/3/2022
		[1]3:40
		[2]PM
		THEN Split [0] bt "/"
		[0]5
		[1]3
		[2]2022
		*/
		
		//Split the desired DateTime to get only the Date part
		String date_MM_dd_yyyy[] = (desiredDateTime.split(" ")[0].split("/"));

		//navigate to the datepicker url which comes from config

		// click on the date button
		clickElement(By.cssSelector("button:nth-of-type(2) > .k-button-icon.k-i-calendar.k-icon"));

		// Find the right arrow element for for future dates
		WebElement leftArrow = driver.findElement(By.cssSelector(".k-button-icon.k-i-arrow-60-left.k-icon"));
		
		// Find the middle button to click the month year
		WebElement middleButton = driver.findElement(By.cssSelector(".k-header.k-hstack > a:nth-of-type(2)"));
		
		// Find the left arrow element for for past dates
		WebElement rightArrow = driver.findElement(By.cssSelector(".k-i-arrow-60-right.k-icon"));
	

		// click middle/left/right
		Thread.sleep(200);
		middleButton.click();
		//leftArrow.click();
		//rightArrow.click();

		// Figure out if the year is in the past present or future
		//Get the year difference between current year and the desired year
		/*Based on this array date_MM_dd_yyy we are looking for the year
		[0]5
		[1]3
		[2]2022 - Integer.parseInt(date_MM_dd_yyy[2])
		 */
		int yearDiff = Integer.parseInt(date_MM_dd_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(yearDiff);
		//Select the desired year
		if (yearDiff != 0) {
			//If you have to move to the next year
			if (yearDiff > 0) {
			for (int i=0; i<yearDiff; i++) {
				System.out.println("YearDiff: " + i);
				rightArrow.click();
			}
		}
		//If you have to move to a previous year
			else if (yearDiff < 0) {
				for (int i=0; i < (yearDiff*(-1)); i++) {
					System.out.println("YearDiff: " + i);
					leftArrow.click();
				}
			}	
				

			
		//Get all the months from the Calendar
		List<WebElement> list_AllMonths = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td"));
		//Extract the string month and converting into an int
			int desiredMonth = Integer.parseInt(date_MM_dd_yyyy[0]);
			System.out.println(desiredMonth);
			//Select the desired month
			list_AllMonths.get(desiredMonth -1).click();
			}
				
		//Get a list of all the days in the selected month		
		List<WebElement> list_AllDays = driver.findElements(By.xpath
				("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
		//Extract the string day and converting into an int
				int desiredDay = Integer.parseInt(date_MM_dd_yyyy[1]);
				System.out.println(desiredDay);
				//Select the desired month
				list_AllDays.get(desiredDay -1).click();
				
		// Click the time button
		clickElement(By.cssSelector("button:nth-of-type(1) > .k-button-icon.k-i-clock.k-icon"));
		
		// Get a list of all the time
		Thread.sleep(200);
		List<WebElement> allTime = driver.findElements(By.xpath("//ul//li[@role='option']"));
		//Extract the desired time
		//"5/3/2022 3:40 PM"
		//desiredDateTime = desiredDateTime.split(" ")[1] + " " + desiredDateTime.split(" ")[2];
		desiredDateTime = desiredDateTime.substring(desiredDateTime.indexOf(" ")+1);
		System.out.println("Desired Time is:" + desiredDateTime);
		Thread.sleep(200);
		
		// Select the desired day
		//For loop syntax
		//For (Statement 1; Statement 2; Statement 3){
		//Statement 1 is executed on time
		//Statement 2 condition for executing the code block
		//Statement 3 is executed every time after the code block
		for (WebElement webElement: allTime) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(desiredDateTime)) {
			System.out.println("Selected Date: " + webElement.getText());
			webElement.click();
			}
			else {
				System.out.println("The desired time is not valid: " + desiredDateTime);
				break;
			}
		}
		//// Time part	
		// Select the desired time	
	
		
		
	
	}
}
	

