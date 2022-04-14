package pageObjectsTakeaLot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ItemDetailPage extends BasePage {

		
		public String checkElementText() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}
	
}
