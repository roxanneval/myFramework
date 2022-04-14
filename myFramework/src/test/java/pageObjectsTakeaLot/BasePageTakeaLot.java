package pageObjectsTakeaLot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class BasePageTakeaLot extends BasePage{
	
	//Method: Got to home page
	public void navigateToHomePage() {
		driver.get("https://www.takealot.com/");
		waitForUrl(30, "takealot");
	}
	
	public void clickCookiesButton() {
		if(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.cookies-banner-module_dismiss-button_24Z98")) != null)
			clickElement(By.cssSelector("button.cookies-banner-module_dismiss-button_24Z98"));
	}
	
		
	}
	


