package Adidas.Demo.pages.pageEvents;

import org.openqa.selenium.By;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.pages.pageElements.HomeElements;
import Adidas.Demo.utils.PageObjectData;

public class HomePage {
	CommonActions _commonActions;
	public HomePage(CommonActions commonActions) {
		this._commonActions = commonActions;
	}
	
	public void goHome() {
		_commonActions.goToUrl(PageObjectData.URL);
	}

	public void navigate_to_categories() {
		_commonActions.moveToElement(By.xpath(HomeElements.XPATH_CATEGORY_LIST), 5);
	}

	public void select_Laptops() {
		_commonActions.clickOnElement(By.xpath(HomeElements.XPATH_CATEGORY_LIST_LAPTOPS), 5);
	}

	public void selectProduct(String productName) {
		By elementXpath=By.xpath("//a[text()='" + productName + "']");
		_commonActions.moveToElement(elementXpath, 10);
		_commonActions.clickOnElement(elementXpath);
	}
}
