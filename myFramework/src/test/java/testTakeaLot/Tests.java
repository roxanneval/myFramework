package testTakeaLot;

import pageObjectsTakeaLot.BasePageTakeaLot;
import pageObjectsTakeaLot.CartPage;
import pageObjectsTakeaLot.CheckOutPage;
import pageObjectsTakeaLot.ItemDetailPage;
import pageObjectsTakeaLot.LandingPage;
import pageObjectsTakeaLot.ResultsPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests {
	
	//Instantiate Pages
	LandingPage landingPage = new LandingPage(); 
	CartPage cartPage = new CartPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	ResultsPage resultsPage = new ResultsPage();
	BasePageTakeaLot basePageTakealot = new BasePageTakeaLot();	
	ItemDetailPage itemDetailPage = new ItemDetailPage();
	
	
	/* 1
	 * GIVEN shopper is on the Landing Page == LandingPage.checkLandingPageNavigation
	 * WHEN Shopper clicks on the cart button == LandingPage.clickCartButton()
	 * THEN check that the shopper is on the cart page == CartPage.checkCartPageNavigation
	 * AND check that Cart is empty is displayed == CartPage.displayEmptyCart "Your shopping cart is empty"
	 * GIVEN_ShopperIsOnLandingPage_WHEN_ShopperClicksOnCartButton_THEN_CheckShopperIsOnCartPage_AND_CheckCArtIsEmpty()
	 */
	
	
	/* 2
	 * GIVEN shopper is on the Landing Page == LandingPage.checkLandingPageNavigation
	 * WHEN Shopper enters "DKNY" as the search string == LandingPage.searchForItem
	 * AND clicks the search button == LandingPage.clickSearchButton
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 * GIVEN_ShopperIsOnLandingPage_WHEN_ShopperEntersDKNYonSearchField_AND_ShopperClicksSearchButton_THEN_DKNYisDisplayed()
	 */
	
	/* 3
	 * GIVEN the shopper has selected the item
	 * WHEN Shopper adds item to cart
	 * AND shopper navigates to Cart
	 * THEN check that item has added to cart
	 * GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToCart_AND_ShopperNavigatesToCart_THEN_CheckItemIsAddedToCart()
	 */
	
	
	
	//1
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperClicksOnCartButton_THEN_CheckShopperIsOnCartPage_AND_CheckCArtIsEmpty() {	
	}

	//2
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperEntersDKNYonSearchField_AND_ShopperClicksSearchButton_THEN_DKNYisDisplayed() {	
		basePageTakealot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar("DKNY");
		landingPage.clickSearchButton();
		landingPage.clickElementText();	
		resultsPage.SwitchToNewTab();
		itemDetailPage.checkElementText();
		
		
	}
	@BeforeTest
	public void setup() {
		basePageTakealot.clickCookiesButton();
	}
	
	//3
	@Test 
	public void GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToCart_AND_ShopperNavigatesToCart_THEN_CheckItemIsAddedToCart() {
		
	}
	

}
