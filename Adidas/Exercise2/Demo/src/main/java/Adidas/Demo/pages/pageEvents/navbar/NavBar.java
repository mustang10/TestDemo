package Adidas.Demo.pages.pageEvents.navbar;

import org.openqa.selenium.By;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.pages.pageElements.navbar.NavBarElements;

public class NavBar {
	public CommonActions _commonActions;

	public NavBar(CommonActions commonActions) {
		this._commonActions = commonActions;
	}

	public void navigateToHome() {
		_commonActions.clickOnElement(By.xpath(NavBarElements.XPATH_HOME), 5);
	}
	public void navigateToCart() {
		_commonActions.clickOnElement(By.xpath(NavBarElements.XPATH_CART), 5);
		_commonActions.fluentWait(By.xpath(NavBarElements.XPATH_DELETE_BUTTON_ROW1), 10);
	}
}
