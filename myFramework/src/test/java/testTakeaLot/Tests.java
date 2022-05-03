package testTakeaLot;

import pageObjectsTakeaLot.BasePageTakeaLot;
import pageObjectsTakeaLot.CartPage;
import pageObjectsTakeaLot.CheckOutPage;
import pageObjectsTakeaLot.ItemDetailPage;
import pageObjectsTakeaLot.LandingPage;
import pageObjectsTakeaLot.ResultsPage;
import pageObjectsTakeaLot.WishListPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.ReadExcel;

public class Tests {
	
	//Instantiate Pages
	LandingPage landingPage = new LandingPage(); 
	CartPage cartPage = new CartPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	ResultsPage resultsPage = new ResultsPage();
	BasePageTakeaLot basePageTakealot = new BasePageTakeaLot();	
	ItemDetailPage itemDetailPage = new ItemDetailPage();
	WishListPage wishListPage = new WishListPage();
	ReadExcel rExcel = new ReadExcel();
	

	

	
	
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
	
	/* 5
	 * GIVEN the shopper has selected the item
	 * WHEN Shopper adds item to cart
	 * AND shopper navigates to WishList
	 * THEN check that item has added to WishList
	 * GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToWishList_AND_ShopperNavigatesToWishList_THEN_CheckItemIsAddedToWishList()
	 */
	
	
	
	
	//1
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperClicksOnCartButton_THEN_CheckShopperIsOnCartPage_AND_CheckCArtIsEmpty1() {	
	}

	//2
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperEntersDKNYonSearchField_AND_ShopperClicksSearchButton_THEN_DKNYisDisplayed2() {	
		String searchInput = "DKNY";
		String actualText;
		String expectedText = searchInput;
		basePageTakealot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		landingPage.clikOnItem();	
		resultsPage.SwitchToNewTab();
		itemDetailPage.itemBrand();
		actualText = itemDetailPage.itemBrand();
		System.out.println("This is the description for the item:" + " " + actualText );
		Reporter.log("Expected result is:" + " " + expectedText);
		Reporter.log("Actual result is:" + " " + actualText);
		Assert.assertEquals(expectedText, actualText);
		
	
	}
	@BeforeTest
	public void setup() {
		basePageTakealot.clickCookiesButton();
	}
	
	@AfterTest
	public void cleanUp() {
		basePageTakealot.cleanUp();
	}
	
	//3
	@Test 
	public void GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToCart_AND_ShopperNavigatesToCart_THEN_CheckItemIsAddedToCart3() throws InterruptedException {	
			String searchInput = "DKNY";
			basePageTakealot.navigateToHomePage();
			landingPage.clickSearchBar();
			landingPage.enterTextInSearchBar(searchInput);
			landingPage.clickSearchButton();
			landingPage.clikOnItem();	
			resultsPage.SwitchToNewTab();
			itemDetailPage.clickAddtoCart();
			itemDetailPage.clickGoToCart();
			cartPage.checkcartCount("(1 item)");
			Assert.assertEquals(cartPage.checkcartCount("(1 item)"), true);
			cartPage.removeFromCart();
			
		
		}
	
	//4
	@Test
	public void GIVEN_ShopperIsOnLandingPage_WHEN_ShopperEntersDKNYonSearchField_AND_ShopperClicksSearchButton_THEN_DKNYisDisplayed4() {
		String searchInput = "DKNY";
		String actualBrand;
		String expectedBrand = "DKNY";
		basePageTakealot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		landingPage.clikOnItem();
		itemDetailPage.SwitchToNewTab();
		actualBrand = itemDetailPage.itemBrand();
		System.out.println("Print the Text " + actualBrand);
		String headingDescription = itemDetailPage.headingDescription();
		System.out.println("The heading of the first item is text " + headingDescription);
		Reporter.log("Expected Brand is " + " " + expectedBrand);
		Reporter.log("Actual Brand is " + actualBrand);
		Reporter.log("Expected Item Description is ");
		Assert.assertEquals(actualBrand, expectedBrand);
		Assert.assertTrue(headingDescription.contains("DKNY"));
	}
	//5
	@Test
	public void GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToWishList_AND_ShopperNavigatesToWishList_THEN_CheckItemIsAddedToWishList2() {
		String searchInput = "DKNY";
		String pageDtl;
		basePageTakealot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		landingPage.clikOnItem();	
		resultsPage.SwitchToNewTab();
		itemDetailPage.clickAddToWishList();
		itemDetailPage.clickGoToWishList();
		pageDtl = wishListPage.confirmWishlistPage();
		System.out.println("This is my " + pageDtl);
		Reporter.log("Page Details: " + pageDtl);
		
		
}
	
	//6
	@Test
	public void GIVEN_ShopperHasSelectedItem_WHEN_ShopperAddsItemToWishList_AND_ShopperNavigatesToWishList_THEN_CheckItemIsAddedToWishList3() {
		String searchInput = "samsung";
		basePageTakealot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		landingPage.clikOnItem();	
		resultsPage.SwitchToNewTab();
		itemDetailPage.clickSelectOptions();
		itemDetailPage.clickColour();		
		
}
	//7
		@Test(dataProvider="Brand&Quantity")
		public void SearchWithExcel(String brand, String quantity) throws InterruptedException {
			
			basePageTakealot.navigateToHomePage();
			landingPage.clickSearchBar();
			landingPage.enterTextInSearchBar(brand);
			landingPage.clickSearchButton();
			landingPage.clikOnItem();	
			resultsPage.SwitchToNewTab();
			itemDetailPage.clickAddtoCart();
			itemDetailPage.clickGoToCart();
			
		}
	
		@DataProvider(name = "Brand&Quantity")
		public Object[][] getDataFromExcel() throws IOException{
			String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
			Object[][] errObj = rExcel.getExcelData(excelDirectory +"Brand&Quantity.xlsx", "Sheet1");
			return errObj;
		}
}
