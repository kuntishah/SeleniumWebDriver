package com.kunti.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	private WebDriver hpo_driver;
	private By customerServiceNumber = By.xpath("//*[@id='right_portion_hdr']/div/ul/li[3]/span/strong");

	// Book Flight
	private By bookFlightTab = By.xpath("//*[@id='header_tab_flights']");
	private By oneWayButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[1]/label");
	private By roundTripButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[2]/label");
	private By multiCityButton = By.xpath("/html/body/div[2]/div[3]/div[1]/section/div[1]/div/div[3]/label");
	private By fromInputBox = By.xpath("//*[@id='hp-widget__sfrom']");
	private By toInputBox = By.xpath("//*[@id='hp-widget__sTo']");
	private By toDropdown = By.xpath("//ul[@id='ui-id-2']/li");
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

	public HomePageObjects(WebDriver driver) {
		this.hpo_driver = driver;
	}

	public WebElement findCustomerServiceNumbert() {
		return hpo_driver.findElement(customerServiceNumber);

	}

	public WebElement findBookFlightTab() {
		return hpo_driver.findElement(bookFlightTab);
	}

	

	public WebElement findOneWayTripButton() {
		return hpo_driver.findElement(oneWayButton);

	}

	public WebElement findRoundTripButton() {
		return hpo_driver.findElement(roundTripButton);

	}

	public WebElement findMultiCityButton() {
		return hpo_driver.findElement(multiCityButton);

	}

	public WebElement findFromInputBox() {
		return hpo_driver.findElement(fromInputBox);
	}

	public WebElement findToInputBox() {
		return hpo_driver.findElement(toInputBox);
	}

	public List<WebElement> findToDropdown(){
		return hpo_driver.findElements(toDropdown);
	}
	
	public WebElement findDepartureDatePicker() {
		return hpo_driver.findElement(departureDatePicker);
	}

	public WebElement findReturnDatePicker() {
		return hpo_driver.findElement(returnDatePicker);
	}

	public WebElement findPassengerDropdownButton() {
		return hpo_driver.findElement(passengerDropdownButton);
	}

	public WebElement findNoOfAdults() {
		return hpo_driver.findElement(noOfAdults);
	}

	public WebElement findNoOfChildren() {
		return hpo_driver.findElement(noOfChildren);
	}

	public WebElement findNoOfInfants() {
		return hpo_driver.findElement(noOfInfants);
	}

	public WebElement findClassOfFlight() {
		return hpo_driver.findElement(classOfFlight);
	}

	
	
	public WebElement findEconomyClass(){
		return hpo_driver.findElement(economyClass);

	}
	
	public WebElement findPremiumEconomyClass(){
		return hpo_driver.findElement(premiumEconomyClass);

	}
	
	public WebElement findBusinessClass(){
		return hpo_driver.findElement(businessClass);

	}

	public WebElement findFirstClass(){
		return hpo_driver.findElement(firstClass);

	}
	public WebElement findsearchFlightButton() {
		return hpo_driver.findElement(searchFlightButton);
	}

	public WebElement findPassengerDone() {
		return hpo_driver.findElement(passengerDone);

	}

	/*
	 * public WebElement find(){ return driver.findElement(); }
	 */

}
