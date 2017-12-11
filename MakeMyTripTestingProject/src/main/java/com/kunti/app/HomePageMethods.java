package com.kunti.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageMethods {

	WebDriver hpm_driver;
	HomePageObjects hpo;

	public HomePageMethods(WebDriver driver) {
		this.hpm_driver = driver;
		hpo = new HomePageObjects(hpm_driver);

	}

	public void clickBookFlight() {
		hpo.findBookFlightTab().click();
	}

	public void clickOneWayButton() {
		hpo.findOneWayTripButton().click();
	}

	public void clickRoundTripButton() {
		hpo.findRoundTripButton().click();

	}

	public void clickMultiCityButton() {

		hpo.findMultiCityButton().click();
	}

	public void clickFromInputBox() {
		hpo.findFromInputBox().click();
	}

	public void clearFromInputBox() {
		hpo.findFromInputBox().clear();

	}

	public void sendKeysFromInputBox(String msg) {

		hpo.findFromInputBox().sendKeys(msg);
	}

	public void sendKeysFromInputBox(Keys k) {

		hpo.findFromInputBox().sendKeys(k);
	}

	public void clickToInputBox() {
		hpo.findToInputBox().click();
	}

	public void clearToInputBox() {
		hpo.findToInputBox().clear();

	}

	public void sendKeysToInputBox(String msg) {

		hpo.findToInputBox().sendKeys(msg);
		List<WebElement> dd = hpo.findToDropdown();

		for (WebElement ele : dd) {

			if (ele.getText().contains(msg)) {
				ele.click();
			}

		} // for

	}

	public void clickDepartureDatePicker() {
		hpo.findDepartureDatePicker().click();
	}

	public void clickReturnDatePicker() {
		hpo.findReturnDatePicker().click();
	}

	public boolean returnDatePickerEnabled() {
		return hpo.findReturnDatePicker().isEnabled();
	}

	public void clickPassengerDropdown() {
		hpo.findPassengerDropdownButton().click();
	}

	public void clickDonePassengerDropdown() {
		hpo.findPassengerDone().click();
	}

	public void clickNoAdults(String adultPass) {
		List<WebElement> noAdults = hpo.findNoOfAdults().findElements(By.tagName("li"));
		noAdults.get(Integer.parseInt(adultPass) - 1).click();
	}

	public void clickNoChildren(String childrenPass) {
		if(Integer.parseInt(childrenPass)>0){
		List<WebElement> noChildren = hpo.findNoOfChildren().findElements(By.tagName("li"));
		noChildren.get(Integer.parseInt(childrenPass) - 1).click();
		}
	}

	public void clickNoInfants(String infantPass) {
		if (Integer.parseInt(infantPass) > 0) {
			List<WebElement> noInfants = hpo.findNoOfInfants().findElements(By.tagName("li"));
			noInfants.get(Integer.parseInt(infantPass) - 1).click();
		}
	}

	public void clickClassOfFlight() {
		hpo.findClassOfFlight().click();
	}

	public void clickClassBtn(String classToSelect) {

		if (classToSelect.equalsIgnoreCase("economy")) {
			hpo.findEconomyClass().click();

		} else if (classToSelect.contains("Premium")) {
			hpo.findPremiumEconomyClass().click();
			;
		} else if (classToSelect.contains("Business")) {
			hpo.findBusinessClass().click();

		} else if (classToSelect.contains("First")) {
			hpo.findFirstClass().click();

		}

	}

	public void clickSearchFlightButton() {
		hpo.findsearchFlightButton().click();
	}

	public void fromDatePicker(String date, String month, String year) {

		// click date picker
		clickDepartureDatePicker();

		// pick the year - current or later
		while (!hpm_driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[2]"))
				.getText().equalsIgnoreCase(year)) {
			if (hpm_driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/div/span[2]"))
					.getText().equalsIgnoreCase(year)) {
				break;
			}
			hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span"))
					.click();
		}

		int side = 0; // 0 is left, 1 is right

		// pick the month
		// if while condition is true (false before negation) then go inside
		// while loop
		// while going in checking the ui-corner-left
		while (!hpm_driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[1]"))
				.getText().equalsIgnoreCase(month)) {
			// check right
			if (hpm_driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/div/span[1]"))
					.getText().equalsIgnoreCase(month)) {
				side = 1;
				break;
			}

			hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span"))
					.click();
			side = 0;
		}

		// pick the date
		WebElement path = null;
		// take the path for the section - left/right
		if (side == 0) {

			path = hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/table"));
		} else if (side == 1) {
			path = hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/table"));

		}

		List<WebElement> noOfDays = path.findElements(By.className("ui-state-default"));

		// Select the date
		for (WebElement day : noOfDays) {

			if (day.getText().equalsIgnoreCase(date)) {
				day.click();
				break;
			}
		}
	}// fromDatePickerMethod

	public void toDatePicker(String date, String month, String year) {

		// click date picker
		clickReturnDatePicker();

		// pick the year - current or later
		while (!hpm_driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/div/div/span[2]"))
				.getText().equalsIgnoreCase(year)) {
			if (hpm_driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/div/span[2]"))
					.getText().equalsIgnoreCase(year)) {
				break;
			}
			hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/a/span"))
					.click();
		}

		int side = 0; // 0 is left, 1 is right

		// pick the month
		// if while condition is true (false before negation) then go inside
		// while loop
		// while going in checking the ui-corner-left
		while (!hpm_driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/div/div/span[1]"))
				.getText().equalsIgnoreCase(month)) {
			// check right
			if (hpm_driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/div/span[1]"))
					.getText().equalsIgnoreCase(month)) {
				side = 1;
				break;
			}

			hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/div/a/span"))
					.click();
			side = 0;
		}

		// pick the date
		WebElement path = null;
		// take the path for the section - left/right
		if (side == 0) {

			path = hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[1]/table"));
		} else if (side == 1) {
			path = hpm_driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[4]/div/div[2]/table"));

		}

		List<WebElement> noOfDays = path.findElements(By.className("ui-state-default"));

		// Select the date
		for (WebElement day : noOfDays) {

			if (day.getText().equalsIgnoreCase(date)) {
				day.click();
				break;
			}
		}
	}// toDatePickerMethod

}
