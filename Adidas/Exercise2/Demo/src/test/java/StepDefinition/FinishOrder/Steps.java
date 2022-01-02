package StepDefinition.FinishOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	@Given("^a cart with a (Sony vaio i5)$")
	public void a_cart_with_a_Sony_vaio_i(String laptop) throws Throwable {
		_pageFactory.getHomePage().goHome();
		_pageFactory.getHomePage().navigate_to_categories();
		_pageFactory.getHomePage().select_Laptops();
		_pageFactory.getHomePage().selectProduct(laptop);
		_pageFactory.getProductPage().addToCart();

		String expectedResult = "Product added";
		String alertText = _commonActions.getAlertText();
		Assert.assertTrue(alertText.equals(expectedResult));

		_pageFactory.getNavBar().navigateToCart();
	}

	@When("^user click on Place Order$")
	public void user_click_on_Place_Order() throws Throwable {
		_pageFactory.getCartPage().placeOrder();
	}

	@When("^fill the form with (Fernando Torres), (Spain), (Valencia), (\\d+), (\\d+), (\\d+)$")
	public void fill_the_form_with_Fernando_Torres_Spain_Valencia(String name, String country, String city,
			long creditCard, int month, int year) throws Throwable {
		_pageFactory.getCartPage().fillForm(name, country, city, creditCard, month, year);
	}

	@Then("^the order details must be shown with amount of (\\d+)$")
	public void the_order_details_must_be_shown_with_amount_of(double expectedAmount) throws Throwable {
		String id = _pageFactory.getCartPage().getOrderId();
		System.out.println("Order ID: " + id);
		double amount = _pageFactory.getCartPage().getOrderAmount();
		System.out.println("Order Amount: " + amount);
		Assert.assertTrue(amount == expectedAmount);
	}

	@Then("^user click on ok$")
	public void user_click_on_ok() throws Throwable {
		String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		takeScreenshot(fileName);
		_pageFactory.getCartPage().closeForm();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed())
			takeScreenshot(scenario.getName());
		quit();
	}
}
