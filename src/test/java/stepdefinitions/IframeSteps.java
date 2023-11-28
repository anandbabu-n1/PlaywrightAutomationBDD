package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MouseHoverPage;
import pageobjects.IframePage;

public class IframeSteps{
	IframePage IframePage = new IframePage(DriverFactory.getPage());

	@Then("User clicks the button inside the iframes")
	public void user_clicks_the_button_inside_the_iframes() {
	    IframePage.getInsideIframe();
	}



}
