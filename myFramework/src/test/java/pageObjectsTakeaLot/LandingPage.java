package pageObjectsTakeaLot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {
	
	//These are re-usable Methods on the landing page
	
		
		public boolean checkLandingPageNavigation() {
		return false;

	    }

		
		public void clickCartButton() {
			
		}
		
		
		public void clickSearchButton() {
			clickElement(By.cssSelector("button[type='submit']"));
			
		}
		
		public void clickSearchBar() {
			clickElement(By.cssSelector("input[name='search']"));
		} 
		
		public void enterTextInSearchBar(String enterTextInSearchBar) {
			enterText(By.name("search"), enterTextInSearchBar);
		}
		
		
		
		public void clikOnItem() {
			clickElement(By.cssSelector(
					"div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
		} 
		
		
		
		public void quizPopUp() {
			String nextButton = "_hj-3HqTj_styles_surveyActionButton";
			try {
				clickElement(By.className("_hj-2fsWS_styles_closeEndedOptionText"));
				clickElement(By.className(nextButton));
				clickElement(By.className(nextButton));
				clickElement(By.className("_hj-3Y4y-_styles_closeButton"));}
			
			catch(Exception e) {
				System.out.println("Survey not there");
				e.printStackTrace();
			}
		}
		
		public void clickCookiesButton() {
			try {
				clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));}
			catch (Exception e) {
				System.out.println("cookie not there");
				//e.printStackTrace
			}
		}
		}

