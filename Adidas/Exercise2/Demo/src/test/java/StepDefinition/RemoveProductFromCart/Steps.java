package StepDefinition.RemoveProductFromCart;

import java.util.List;

import org.junit.Assert;

import Adidas.Demo.seleniumTests.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps  extends BaseTest {
	public Steps() {
		super();
	}

	// Remove
	@Given("^a cart with (Sony vaio i5) and (Dell i7 8gb)$")
	public void a_cart_with_product_and_product(String laptop1, String laptop2) throws Throwable {
		// Add laptop1
		_pageFactory.getHomePage().goHome();
		_pageFactory.getHomePage().navigate_to_categories();
		_pageFactory.getHomePage().select_Laptops();
		_pageFactory.getHomePage().selectProduct(laptop1);
		_pageFactory.getProductPage().addToCart();

		String expectedResult = "Product added";
		String alertText = _commonActions.getAlertText();
		Assert.assertTrue(alertText.equals(expectedResult));

		// Add laptop2
		_pageFactory.getNavBar().navigateToHome();
		_pageFactory.getHomePage().navigate_to_categories();
		_pageFactory.getHomePage().select_Laptops();
		_pageFactory.getHomePage().selectProduct(laptop2);
		_pageFactory.getProductPage().addToCart();

		alertText = _commonActions.getAlertText();
		Assert.assertTrue(alertText.equals(expectedResult));
		
		_pageFactory.getNavBar().navigateToCart();
	}

	@When("^user delete (Dell i7 8gb) from cart$")
	public void user_delete_product_from_cart(String laptopName) throws Throwable {
	    _pageFactory.getCartPage().removeProduct(laptopName);
	}
	
	@Then("^the (Dell i7 8gb) must be removed from the cart$")
	public void the_Dell_i_gb_must_be_removed_from_the_cart(String laptopName) throws Throwable {
        List<String> productsInCart = _pageFactory.getCartPage().getProductsInCart();
        Assert.assertFalse(productsInCart.contains(laptopName));
	}

	@Then("^the (Sony vaio i5) must still on the cart$")
	public void the_Sony_vaio_i_must_still_on_the_cart(String laptopName) throws Throwable {
        List<String> productsInCart = _pageFactory.getCartPage().getProductsInCart();
        Assert.assertTrue(productsInCart.contains(laptopName));
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed())
			takeScreenshot(scenario.getName());
		quit();
	}
}
