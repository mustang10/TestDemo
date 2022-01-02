package Adidas.Demo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Adidas.Demo.utils.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	// Properties
	public static WebDriver _driver;

	public DriverFactory() {
		_driver = getdriver();
	}

	public WebDriver getdriver() {
		if (_driver == null) {
			return browserLaunch();
		}

		return _driver;
	}

	public WebDriver setupDriver() {
		Browser browser;
		try {
			browser = Browser.valueOf(System.getProperty("browser"));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println("Invalid browser name. Launching tests with chrome.");
			browser = Browser.CHROME;
		}
		
		switch (browser) {
		case CHROME:
			_driver = createCromeDriver();
			break;
		case FIREFOX:
			_driver = createFirefoxDriver();
			break;
		default:
			System.out.println("Browser not supported");
			break;
		}
		return _driver;
	}

	private WebDriver createFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	private WebDriver createCromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	public WebDriver browserLaunch() {
		_driver = setupDriver();
		_driver.manage().window().maximize();
		System.out.println("Browser initialised");
		return _driver;
	}

	public void quit() {
		if (_driver != null) {
			_driver.close();
		}
	}
}
