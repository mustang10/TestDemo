package Adidas.Demo.seleniumTests.testClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/AddProductToCart.feature", glue = "StepDefinition.AddProductToCart")
public class AddProductToCartTest{
    public AddProductToCartTest() {

    }
}
