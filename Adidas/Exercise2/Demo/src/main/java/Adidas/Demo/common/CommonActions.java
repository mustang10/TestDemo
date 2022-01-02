package Adidas.Demo.common;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonActions {
	WebDriver _driver;

	public CommonActions(WebDriver driver) {
		_driver = driver;
		System.out.println(_driver.getCurrentUrl());
	}

	public void goToUrl(String url) {
		_driver.get(url);
	}

	/**
	 * Moves to some given element
	 * 
	 * @param elementAddress
	 * @param waitingTime
	 */
	public void moveToElement(By elementAddress, int waitingTime) {
		WebElement elementToMove = findElement(elementAddress, waitingTime);
		Actions actions = new Actions(_driver);

		actions.moveToElement(elementToMove).perform();
	}

	public WebElement findElement(By elementAddress, int waitingTime) {
		return fluentWait(elementAddress, waitingTime);
	}

	public List<WebElement> findElements(By elementAddress, int waitingTime) {
		return _driver.findElements(elementAddress);
	}

	public void clickOnElement(By elementAddress, int waitingTime) {
		fluentWait(elementAddress, waitingTime).click();
	}
	
	public void clickOnElement(By elementAddress) {
		_driver.findElement(elementAddress).click();
	}

	public String getAlertText() {
		TargetLocator window = _driver.switchTo();
		Alert alert = findAlert(window);
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	private Alert findAlert(TargetLocator window) {
		while (!isAlertPresent(window))
			;
		return window.alert();
	}

	private Boolean isAlertPresent(TargetLocator window) {
		try {
			window.alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present.");
			return false;
		}
	}

	public void WriteText(By elementAddress, String text, int waitingTime) {
		moveToElement(elementAddress, waitingTime);
		fluentWait(elementAddress, waitingTime).sendKeys(text);
	}

	public void waitUntilVisibility(final By elementAddress, int waitingTime, final Boolean visibility) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver).withTimeout(Duration.ofSeconds(waitingTime))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(TimeoutException.class)
				.ignoring(NoSuchElementException.class);
		try {
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return (driver.findElement(elementAddress).isDisplayed() == visibility);
				}
			});
		} catch (TimeoutException e) {
			System.out.println("Timeout from waitUntilVisibility");
		}
	}

	public String getElementText(By elementAddress, int waitingTime) {
		return fluentWait(elementAddress, waitingTime).getText();
	}
	public String getElementText(By elementAddress) {
		return _driver.findElement(elementAddress).getText();
	}

	/**
	 * waits for an element using fluent wait
	 * 
	 * @param waitingTime in seconds
	 * @return
	 */
	public WebElement fluentWait(final By elementAddress, int waitingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver).withTimeout(Duration.ofSeconds(waitingTime))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(UnhandledAlertException.class).ignoring(StaleElementReferenceException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(elementAddress);
			}
		});
	}

}
