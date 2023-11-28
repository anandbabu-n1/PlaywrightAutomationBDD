package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.PopUpPage;

public class PopUpSteps{
	PopUpPage PopUpPage = new PopUpPage(DriverFactory.getPage());

	@When("user clicks on the open button")
	public void user_clicks_on_the_open_button() {
	    PopUpPage.clickOpenButton();
	}
	
	@When("user clicks button on the popup")
	public void user_clicks_button_on_the_popup() {
	    PopUpPage.clickSubmitButtonOnPopup();
	}
	@Then("user verifies the text on the main page")
	public void user_verifies_the_text_on_the_main_page() {
		Assert.assertEquals(PopUpPage.getTextMessage(), "Button Clicked");
	}

}
