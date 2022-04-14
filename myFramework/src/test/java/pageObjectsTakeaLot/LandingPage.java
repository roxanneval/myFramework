package pageObjectsTakeaLot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {
	
	//These are re-usable Methods on the landing page
	
		
		public boolean checkLandingPageNavigation() {
		return false;

	    }

		
		/* 1
		 * GIVEN shopper is on the Landing Page == LandingPage.checkLandingPage
		 * WHEN Shopper clicks on the cart button == LandingPage.clickCartButton()
		 * THEN check that the shopper is on the cart page == CartPage.checkCartPageNavigation
		 * AND check that Cart is empty is displayed == CartPage.displayEmptyCart("Your shopping cart is empty"
		 * GIVEN_ShopperIsOnLandingPage_WHEN_ShopperClicksOnCartButton_THEN_CheckShopperIsOnCartPage_AND_CheckCArtIsEmpty
		 */
		public void clickCartButton() {
			
		}
		
		/* 2
		 * GIVEN shopper is on the Landing Page == LandingPage.checkLandingPageNavigation
		 * WHEN Shopper enters "DKNY" as the search string == LandingPage.searchForItem
		 * AND clicks the search button == LandingPage.clickSearchButton
		 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
		 * GIVEN_ShopperIsOnLandingPage_WHEN_ShopperEntersDKNYonSearchField_AND_ShopperClicksSearchButton_THEN_DKNYisDisplayed()
		 */
		
		public void clickSearchButton() {
			clickElement(By.cssSelector("button[type='submit']"));
			
		}
		
		public void clickSearchBar() {
			clickElement(By.cssSelector("input[name='search']"));
		} 
		
		public void enterTextInSearchBar(String enterTextInSearchBar) {
			enterText(By.name("search"), enterTextInSearchBar);
		}
		
		
		
		public void clickElementText() {
			clickElement(By.cssSelector(
					"div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
		}
		//div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV
		
		
		public void selectItem (String selectItem) {
			
		}
		
}
