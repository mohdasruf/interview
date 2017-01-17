package com.stepDefinition;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class loginSteps {

	WebDriver driver = null;

	@Given("^the user is on facebook page$")
	public void the_user_is_on_facebook_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\toshiba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
	}

	@When("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_enters_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("email")).sendKeys(arg1);
		driver.findElement(By.name("pass")).sendKeys(arg1);
		driver.findElement(By.id("loginbutton")).click();

	}

	@Then("^the login should fail$")
	public void the_login_should_fail() throws Throwable {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("login_attempt"));
		driver.close();
	}
}
