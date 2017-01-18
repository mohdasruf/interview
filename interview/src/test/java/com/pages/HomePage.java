package com.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.BasePage;
import com.automation.DriverContext;

public class HomePage extends BasePage {

	int noOfRowsBeforeDelete;
	int noOfRowsAfterDelete;

	public HomePage() {
	}

	@FindBy(how = How.ID, using = "firstname")
	public WebElement firstName;

	@FindBy(how = How.ID, using = "lastname")
	public WebElement lastName;

	@FindBy(how = How.ID, using = "totalprice")
	public WebElement price;

	@FindBy(how = How.XPATH, using = "//Select[@id='depositpaid']")
	public WebElement depositPaid;

	@FindBy(how = How.ID, using = "checkin")
	public WebElement checkInDate;

	@FindBy(how = How.XPATH, using = "//*[@id='ui-datepicker-div']/table/tbody")
	public WebElement calendarBody;

	@FindBy(how = How.ID, using = "checkout")
	public WebElement checkOutDate;

	@FindBy(how = How.XPATH, using = "//*[@id='form']/div/div[7]/input")
	public WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//*[@id='bookings']")
	public WebElement tableData;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'240')]/div/input")
	public List<WebElement> deleteButton;

	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}

	public void enterLastName(String surName) {
		lastName.sendKeys(surName);
	}

	public void enterPrice(String totalPrice) {
		price.sendKeys(totalPrice);
	}

	public void selectDepostPaid(String deposit) {
		Select select = new Select(depositPaid);
		select.selectByVisibleText(deposit);
	}

	private int getTodaysDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		return todayInt;
	}

	public void enterCheckInDate() {
		int today = getTodaysDay();
		String todayStr = Integer.toString(today);
		checkInDate.click();
		List<WebElement> columns = calendarBody.findElements(By.tagName("td"));
		for (WebElement cell : columns) {
			if (cell.getText().equals(todayStr)) {
				cell.click();
				break;
			}
		}
	}

	public void enterCheckOutDate() {
		int today = getTodaysDay();
		int dateToCheckOut = today + 3;
		String todayStr = Integer.toString(dateToCheckOut);
		checkOutDate.click();
		List<WebElement> columns = calendarBody.findElements(By.tagName("td"));
		for (WebElement cell : columns) {
			if (cell.getText().equals(todayStr)) {
				cell.click();
				break;
			}
		}
	}

	public void clickSave() {
		saveButton.click();
	}

	public void clickDelete() {
		try{
		WebDriverWait wait = new WebDriverWait(DriverContext.Driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(deleteButton.get(0)));
		noOfRowsBeforeDelete = deleteButton.size();
		element.click();}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public boolean verifyDelete() throws InterruptedException {
		clickDelete();
		noOfRowsAfterDelete = deleteButton.size();
		if (noOfRowsBeforeDelete == noOfRowsAfterDelete) {
			return false;
		}
		return true;
	}

	public boolean valueIsPresent(List<String> expectedResult)
			throws InterruptedException {
		Thread.sleep(6000);
		List<WebElement> rows = tableData.findElements(By
				.xpath(".//*[contains(@id,'240')]"));
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> columns = rows.get(i).findElements(
					By.xpath(".//div[contains(@class,'col-md-')]"));
			List<String> actualData = new ArrayList<String>();
			for (int j = 0; j < 4; j++) {
				actualData.add(columns.get(j).getText());
			}
			if (expectedResult.equals(actualData)) {
				return true;
			}
		}
		return false;
	}

}