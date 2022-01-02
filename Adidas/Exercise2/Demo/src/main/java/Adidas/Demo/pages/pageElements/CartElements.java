package Adidas.Demo.pages.pageElements;

public interface CartElements {
	String XPATH_PRODUCTS_IN_CART = "//table/tbody[@id = 'tbodyid']/tr/td[2]";
	String XPATH_BUTTON_PLACE_ORDER = "//button[text()='Place Order']";
	String ID_FORM = "orderModal";
	String ID_FORM_NAME = "name";
	String ID_FORM_COUNTRY = "country";
	String ID_FORM_CITY = "city";
	String ID_FORM_CARD = "card";
	String ID_FORM_MONTH = "month";
	String ID_FORM_YEAR = "year";
	String XPATH_FORM_BUTTON_PURCHASE = "//button[text()='Purchase']";
	String XPATH_FORM_BUTTON_OK = "//button[text()='OK']";
	String CSS_ORDER_DETAILS = ".lead.text-muted";

}
