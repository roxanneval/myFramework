package pageObjectsTakeaLot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ItemDetailPage extends BasePage {

		
		public String itemBrand() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}
		
		public String headingDescription() {
			String text2 = getElementText(By.cssSelector(".title-content-list a"));
			return text2;
		}
		
		public void clickAddtoCart() {
			clickElement(By.cssSelector
					(".cell.large-3.pdp-module_side-bar_TDHGJ .add-to-cart-button.add-to-cart-button-module_add-to-cart-button_1a9gT.button.expanded"));
		}
		
		public void clickGoToCart() {
			clickElement(By.cssSelector(".content-wrapper .checkout-now"));
		}
	
		public void clickAddToWishList() {
			clickElement(By.cssSelector(".button.shade-gray.wishlist-button.wishlist-split-button-module_wishlist-button_36rqk"));
		}
		
		public void clickGoToWishList() {
			clickElement(By.cssSelector(".icon-link.top-nav-module_wishlist-button_mIJ0_.wish > svg[role='presentation'] > path"));
		}
		
		public void clickSelectOptions() {
			clickElement(By.cssSelector(".basic.button.buybox-actions-module_call-to-action_3DrOo.dark.ghost.variants-cta"));
		}
		
		public void clickColour() {
			clickElement(By.cssSelector("li:nth-of-type(2) > .select-dropdown-module_list-item_2kHtk"));
		}
		
		public int getUnitPrice() {
			String unitPriceString = getElementText(By.cssSelector("[data-ref='buybox-price-main]"));
			String unitPrice = unitPriceString.replaceAll("//D", "");
			int unitPriceInt = Integer.parseInt(unitPrice);
			return unitPriceInt;
		}
}


