package Tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.automation.BrowserType;
import com.automation.DriverContext;
import com.automation.FrameworkInitialize;
import com.pages.HomePage;

public class Tests extends FrameworkInitialize {
	HomePage home = null;

	@Before
	public void Initialize() {
		InitializeBrowser(BrowserType.Chrome);
		DriverContext.Browser.GoToUrl("http://hotel-test.equalexperts.io/");
		home = new HomePage();
	}

	@Test
	public void createBooking() throws InterruptedException {
		List<String> expectedResult = Arrays.asList("Test1", "Test2", "100",
				"true");
		home.enterFirstName(expectedResult.get(0));
		home.enterLastName(expectedResult.get(1));
		home.enterPrice(expectedResult.get(2));
		home.selectDepostPaid(expectedResult.get(3));
		home.enterCheckInDate();
		home.enterCheckOutDate();
		home.clickSave();
		Assert.assertTrue(home.valueIsPresent(expectedResult));
	}

	@Test
	public void DeleteBooking() throws InterruptedException {
		home.clickDelete();
		Assert.assertTrue(home.verifyDelete());
	}
	
	@After
	public void finish(){
		DriverContext.Driver.close();

	}

}
