package Adidas.Demo.seleniumTests.testClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/FinishOrder.feature", glue = "StepDefinition.FinishOrder")
public class FinishOrder {

}
