package com.uiautomation.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uiautomation.constants.Constants;
import com.uiautomation.page_objects.GoogleSample;
import com.uiautomation.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSampleStepDefinition {
	@Given("User opens the google website")
	public void user_opens_the_google_website() {
		DriverManager.openApp();
		//DriverManager.getDriver().get(Constants.appurl);
	}
	
	@When("User clicks on the search bar")
	public void user_clicks_on_the_search_bar() {
		GoogleSample.getInstance().clickSearchBar();
		
	}
	
	@Then("user gets the first trending search")
	public void user_gets_the_first_trending_search() {
	    //GoogleSample.getFirstTrendingSearch();
		
			
			GoogleSample.getInstance().getFirsttrendingsearch();
		
	}
	
	@Then("user closes the browser")
	public void user_closes_the_browser() {
	    DriverManager.closeBrowser();
	}
}
