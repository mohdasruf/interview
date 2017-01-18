package com.stepDefinition;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import com.automation.BrowserType;
import com.automation.DriverContext;
import com.automation.FrameworkInitialize;
import com.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class createBooking extends FrameworkInitialize {

	
	List<String> expectedResult;
	
	@Given("^the user is on booking page$")
	public void the_user_is_on_booking_page() throws Throwable {
		InitializeBrowser(BrowserType.Chrome);
		DriverContext.Browser.GoToUrl("http://hotel-test.equalexperts.io/");
		home = new HomePage();
	}

	@When("^the user enters \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\",\"([^\"]*)\" and the checkin dates$")
	public void the_user_enters_and_the_checkin_dates(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		expectedResult = Arrays.asList(arg1,arg2,arg3,arg4);
		home.enterFirstName(expectedResult.get(0));
		home.enterLastName(expectedResult.get(1));
		home.enterPrice(expectedResult.get(2));
		home.selectDepostPaid(expectedResult.get(3));
		home.enterCheckInDate();
		home.enterCheckOutDate();
		home.clickSave();
	}

	@Then("^the corresponding details should be created as a record visible in the page with a delete button$")
	public void the_corresponding_details_should_be_created_as_a_record_visible_in_the_page_with_a_delete_button() throws Throwable {
		Assert.assertTrue(home.valueIsPresent(expectedResult));
		DriverContext.Driver.close();
	}


}
