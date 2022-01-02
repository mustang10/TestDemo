package Adidas.Demo.seleniumTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Adidas.Demo.common.CommonActions;
import Adidas.Demo.factory.DriverFactory;
import Adidas.Demo.pages.PageFactory;

public class BaseTest {

	DriverFactory _driverFactory;
	public PageFactory _pageFactory;
	public CommonActions _commonActions;

	public BaseTest() {
		_driverFactory = new DriverFactory();
		_commonActions = new CommonActions(_driverFactory.getdriver());
		_pageFactory = new PageFactory(_commonActions);
	}

	public void takeScreenshot(String fileName) {
		File screenshot = ((TakesScreenshot) _driverFactory.getdriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	public void quit() {
		_driverFactory.quit();
	}

}
