package pageObjectsTakeaLot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class WishListPage extends BasePage{

	public String confirmWishlistPage() {
		String wishLst = getElementText(By.cssSelector("h1"));
		return wishLst;
	}
	
}
