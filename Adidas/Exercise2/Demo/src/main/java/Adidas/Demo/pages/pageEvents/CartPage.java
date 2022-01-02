package Adidas.Demo.pages.pageEvents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.pages.pageElements.CartElements;
import Adidas.Demo.pages.pageElements.navbar.NavBarElements;

public class CartPage {
	public CommonActions _commonActions;
	public CartPage(CommonActions commonActions) {
		this._commonActions = commonActions;
	}
	public List<String> getProductsInCart() {
		_commonActions.waitUntilVisibility(By.xpath(NavBarElements.XPATH_DELETE_BUTTON_ROW1), 10, true);
		List<String> productNames = new ArrayList<String>();
		List<WebElement> products = getProducts();
		for (WebElement product : products) {
			String productName = product.getText();
			productNames.add(productName);
		}
		return productNames;
	}
	
	public void removeProduct(String productToRemove) {
		List<WebElement> products = getProducts();
		for (int i = 0; i< products.size(); i++) {
			WebElement product = products.get(i);
			if(product.getText().equals(productToRemove)) {
				_commonActions.clickOnElement(By.xpath("//table/tbody[@id = 'tbodyid']/tr["+(i+1)+"]/td[4]/a"), 5);
				_commonActions.waitUntilVisibility(By.xpath(NavBarElements.XPATH_DELETE_BUTTON_ROW1), 5, false);
				return;
			}
		}
	}
	private List<WebElement> getProducts() {
		return _commonActions
		.findElements(By.xpath(CartElements.XPATH_PRODUCTS_IN_CART), 5);
	}
	public void placeOrder() {
		_commonActions.clickOnElement(By.xpath(CartElements.XPATH_BUTTON_PLACE_ORDER), 10);
	}
	public void fillForm(String name, String country, String city, long creditCard, int month, int year) {
		_commonActions.waitUntilVisibility(By.id(CartElements.ID_FORM), 10, true);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_NAME), name, 10);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_COUNTRY), country, 10);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_CITY), city, 10);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_CARD), ""+creditCard, 10);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_MONTH), ""+month, 10);
		_commonActions.WriteText(By.id(CartElements.ID_FORM_YEAR), ""+year, 10);
		
		_commonActions.clickOnElement(By.xpath(CartElements.XPATH_FORM_BUTTON_PURCHASE), 10);
	}


	public void closeForm() {
		_commonActions.clickOnElement(By.xpath(CartElements.XPATH_FORM_BUTTON_OK));
	}
	public String getOrderId() {
		_commonActions.waitUntilVisibility(By.xpath(CartElements.XPATH_FORM_BUTTON_OK), 10, true);
		String details = getOrderDetails();
		String idLine = details.split("\n")[0];
		return getOrderDetailValue(idLine);
	}
	public double getOrderAmount() {
		String details = getOrderDetails();
		String amountLine =  details.split("\n")[1];
		String amountWithCurrency = amountLine.split(":")[1];
		String amount = amountWithCurrency.split(" ")[1];
		return Double.parseDouble(amount);
	}
	
	private String getOrderDetails() {
		return _commonActions.getElementText(By.cssSelector(CartElements.CSS_ORDER_DETAILS));
	}
	private String getOrderDetailValue(String line) {
		return line.split(":")[1].trim();
	}
}
