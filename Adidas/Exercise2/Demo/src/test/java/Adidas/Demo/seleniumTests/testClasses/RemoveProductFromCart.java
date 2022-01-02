package Adidas.Demo.seleniumTests.testClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/RemoveProductFromCart.feature", glue = "StepDefinition.RemoveProductFromCart")
public class RemoveProductFromCart {

}
