package StepDefinition.AddProductToCart;

import java.util.List;

import org.junit.Assert;

import Adidas.Demo.seleniumTests.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseTest {
	public Steps() {
		super();
	}

	// Add
	@Given("^user navigates to demoblaze home page$")
	public void user_navigates_to_demoblaze_home_page() throws Throwable {
		_pageFactory.getHomePage().goHome();
	}

	@When("^user navigate to categories$")
	public void user_navigate_to_categories() throws Throwable {
		_pageFactory.getHomePage().navigate_to_categories();
	}

	@When("^select Laptops$")
	public void select_Laptop() throws Throwable {
		_pageFactory.getHomePage().select_Laptops();
	}

	@When("^select (Sony vaio i5)$")
	public void sony_vaio_i5(String laptopName) throws Throwable {
		_pageFactory.getHomePage().selectProduct(laptopName);
	}

	@When("^add the product to cart$")
	public void add_the_product_to_cart() throws Throwable {
		_pageFactory.getProductPage().addToCart();
	}

	@Then("^a popup \\(Product added\\) must be shown$")
	public void a_popup_Product_added_must_be_shown() throws Throwable {
		String expectedResult = "Product added";
		String alertText = _commonActions.getAlertText();
		Assert.assertTrue(alertText.equals(expectedResult));
	}

	@Then("^the Sony vaio (Sony vaio i5) must be on the cart$")
	public void the_Sony_vaio_i5_must_be_on_the_cart(String laptopName) throws Throwable {
		_pageFactory.getNavBar().navigateToCart();
		List<String> productsInCart = _pageFactory.getCartPage().getProductsInCart();
		Assert.assertTrue(productsInCart.contains(laptopName));
	}
	
	@Then("^the number of products in cart must be (\\d+)$")
	public void the_number_of_products_in_cart_must_be(int expectedResult) throws Throwable {
		List<String> productsInCart = _pageFactory.getCartPage().getProductsInCart();
		Assert.assertTrue(productsInCart.size() == expectedResult);
	}


	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed())
			takeScreenshot(scenario.getName());
		quit();
	}
}
