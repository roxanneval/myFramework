package testTakeaLot;

import pageObjectsTakeaLot.CartPage;
import pageObjectsTakeaLot.CheckOutPage;
import pageObjectsTakeaLot.LandingPage;
import org.testng.annotations.Test;

public class Tests {
	
	//Instantiate Pages
	
	LandingPage landPG = new LandingPage(); 
	CartPage cartPG = new CartPage();
	CheckOutPage checkoutPG = new CheckOutPage();
	
	/* GIVEN shopper is on the Landing Page 
	 * WHEN Shopper selects item
	 * THEN the item will be selected 
	 * GIVEN_ShopperIsOnLandingPage_WHEN_ShopperSelectsAnItem_THEN_TheItemWillBeselected
	 */
	
	/* GIVEN the Shopper is on the item 
	 * WHEN Shopper selects add to cart
	 * THEN the item will be added to cart
	 * GIVEN_ShopperIsOnItem_WHEN_ShopperSelectsAddToCart_THEN_TheItemWillBeAddedToCart_AND_ShopperSelectsGoToCart
	 */
	
	/* GIVEN the shopper is on the Cart
	 * WHEN Shopper selects checkout
	 * THEN the shopper will be re-directed to Payment Page
	 * GIVEN_ShopperOnCheckoutPage_WHEN_ShooperClicksCheckOut_THEN_RedirectedToPaymentPage
	 */
	
	
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperSelectsAnItem_THEN_TheItemWillBeselected() {
	}
		
	@Test
	public void GIVEN_ShopperIsOnItem_WHEN_ShopperSelectsAddToCart_THEN_TheItemWillBeAddedToCart_AND_ShopperSelectsGoToCart() {	
	}
	
	@Test 
	public void GIVEN_ShopperOnCheckoutPage_WHEN_ShooperClicksCheckOut_THEN_RedirectedToPaymentPage(){
		
	}
	

}
