package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {

	public void InitializeBrowser(BrowserType browserType) {

		WebDriver driver = null;
		switch (browserType) {
		case Chrome: {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case Firefox: {
			driver = new FirefoxDriver();
			break;
		}
		case IE: {
			break;
		}
		default:
			break;
		}

		DriverContext.setDriver(driver);
		DriverContext.Browser = new Browser(driver);

	}

}
