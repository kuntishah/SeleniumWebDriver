package com.kunti.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeMyTripHomePage {
	private WebDriver driver;
	private By customerServiceNumber = By.xpath("//*[@id='right_portion_hdr']/div/ul/li[3]/span/strong");

	// Book Flight
	private By bookFlightTab = By.xpath("//*[@id='header_tab_flights']");
	private By oneWayButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[1]/label");
	private By roundTripButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[2]/label");
	private By multiCityButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[3]/label");
	private By fromInputBox = By.xpath("//*[@id='hp-widget__sfrom']");
	private By toInputBox = By.xpath("//*[@id='hp-widget__sTo']");
	private By departureDatePicker = By.xpath("//*[@id='hp-widget__depart']");
	private By returnDatePicker = By.xpath("//*[@id='hp-widget__return']");
	private By passengerDropdownButton = By.xpath("//*[@id='hp-widget__paxCounter']");
	private By noOfAdults = By.xpath("//*[@id='js-adult_counter']");
	private By noOfChildren = By.xpath("//*[@id='js-child_counter']");
	private By noOfInfants = By.xpath("//*[@id='js-infant_counter']");
	private By passengerDone = By.xpath("//*[@id='js-filterOptins']/div/div[9]/div/p/a");
	private By classOfFlight = By.xpath("//*[@id='hp-widget__class']");
	private By economyClass = By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[10]/div[1]/label");
	private By premiumEconomyClass = By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[10]/div[2]/label");
	private By businessClass = By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[10]/div[3]/label");
	private By firstClass = By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[10]/div[4]/label");
	private By searchFlightButton = By.xpath("//*[@id='searchBtn']");

	public MakeMyTripHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findCustomerServiceNumbert() {
		return driver.findElement(customerServiceNumber);

	}

	public WebElement findBookFlightTab() {
		return driver.findElement(bookFlightTab);
	}

	public WebElement findWayButton(String way) {
		if (way.contains("One")) {
			return driver.findElement(oneWayButton);
		} else if (way.contains("Round")) {
			return driver.findElement(roundTripButton);

		} else if (way.contains("Multi")) {
			return driver.findElement(multiCityButton);

		}
		
	
		return null;
	}

	public WebElement findOneWayTripButton() {
		return driver.findElement(oneWayButton);

	}

	public WebElement findRoundTripButton() {
		return driver.findElement(roundTripButton);

	}

	public WebElement findMultiCityButton() {
		return driver.findElement(multiCityButton);

	}

	public WebElement findFromInputBox() {
		return driver.findElement(fromInputBox);
	}

	public WebElement findToInputBox() {
		return driver.findElement(toInputBox);
	}

	public WebElement findDepartureDatePicker() {
		return driver.findElement(departureDatePicker);
	}

	public WebElement findReturnDatePicker() {
		return driver.findElement(returnDatePicker);
	}

	public WebElement findPassengerDropdownButton() {
		return driver.findElement(passengerDropdownButton);
	}

	public WebElement findNoOfAdults() {
		return driver.findElement(noOfAdults);
	}

	public WebElement findNoOfChildren() {
		return driver.findElement(noOfChildren);
	}

	public WebElement findNoOfInfants() {
		return driver.findElement(noOfInfants);
	}

	public WebElement findClassOfFlight() {
		return driver.findElement(classOfFlight);
	}

	public WebElement findClassBtn(String classToSelect) {

		if (classToSelect.equalsIgnoreCase("economy")) {
			return driver.findElement(economyClass);
		} else if (classToSelect.contains("Premium")) {
			return driver.findElement(premiumEconomyClass);
		} else if (classToSelect.contains("Business")) {
			return driver.findElement(businessClass);

		} else if (classToSelect.contains("First")) {
			return driver.findElement(firstClass);

		} else {
			return null;
		}

	}

	public WebElement findsearchFlightButton() {
		return driver.findElement(searchFlightButton);
	}

	public WebElement findPassengerDone() {
		return driver.findElement(passengerDone);

	}

	/*
	 * public WebElement find(){ return driver.findElement(); }
	 */

}
