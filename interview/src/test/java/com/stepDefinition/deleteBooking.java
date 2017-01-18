package com.stepDefinition;

import com.automation.DriverContext;
import com.automation.FrameworkInitialize;

import junit.framework.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class deleteBooking extends FrameworkInitialize {

	@When("^the user clicks on the delete button if a record exists$")
	public void the_user_clicks_on_the_delete_button_if_a_record_exists() throws Throwable {
	    home.clickDelete();
	}

	@Then("^the record should be deleted from the page$")
	public void the_record_should_be_deleted_from_the_page() throws Throwable {
		Assert.assertTrue(home.verifyDelete());
		DriverContext.Driver.close();
	}
}
