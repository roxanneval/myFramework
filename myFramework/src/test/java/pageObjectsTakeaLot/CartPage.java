package pageObjectsTakeaLot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage{

	public boolean checkcartCount(String checkCount) throws InterruptedException{
		Thread.sleep(2000);
		String itemElement = ".cart-summary-module_cart-summary-item-count_3jkNC > span";
		System.out.println(getElementText(By.cssSelector(itemElement)));
		System.out.println(checkCount);
		
		if (getElementText(By.cssSelector(itemElement)).contains(checkCount))
		{
			Reporter.log("Amount correct " + checkCount);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		}
		Reporter.log("Amount incorrect: " + checkCount);
		Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
		return false;
		}
	
	public void removeFromCart() {
		clickElement(By.cssSelector(".button.clear.remove-item"));
	}
	
	}


