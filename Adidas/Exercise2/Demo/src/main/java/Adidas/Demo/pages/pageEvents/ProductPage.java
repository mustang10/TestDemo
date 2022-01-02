package Adidas.Demo.pages.pageEvents;

import org.openqa.selenium.By;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.pages.pageElements.ProductElements;

public class ProductPage {
	public CommonActions _commonActions;
	public ProductPage(CommonActions commonActions) {
		this._commonActions = commonActions;
	}
	public void addToCart() {
		_commonActions.clickOnElement(By.xpath(ProductElements.XPATH_BUTTON_ADD), 10);
		
	}
}
