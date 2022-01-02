package Adidas.Demo.pages;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.pages.pageEvents.*;
import Adidas.Demo.pages.pageEvents.navbar.NavBar;

public class PageFactory {
	//Pages
	HomePage _homePage;
	ProductPage _productPage;
	CartPage _cartPage;
	NavBar _navbar;
	
    CommonActions _commonActions;

    public PageFactory(CommonActions commonActions) {
        _commonActions = commonActions;
    }
    
    public HomePage getHomePage() {
    	if(_homePage == null)
    		_homePage = new HomePage(_commonActions);
    	return _homePage;
    }
    
    public ProductPage getProductPage() {
    	if(_productPage == null)
    		_productPage = new ProductPage(_commonActions);
    	return _productPage;
    }
    
    public CartPage getCartPage() {
    	if(_cartPage == null)
    		_cartPage = new CartPage(_commonActions);
    	return _cartPage;
    }
    public NavBar getNavBar() {
    	if(_navbar == null)
    		_navbar = new NavBar(_commonActions);
    	return _navbar;
    }
}
