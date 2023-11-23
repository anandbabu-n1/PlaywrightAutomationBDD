package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.NewTabPage;

public class NewTabSteps {
	NewTabPage NewTabPage = new NewTabPage(DriverFactory.getPage());

	@When("user clicks on the New Tab button")
	public void user_clicks_on_the_new_tab_button() {
	    NewTabPage.clickNewTabButton();
	}
	
	@When("user verify the text on the new web page")
	public void user_verify_the_text_on_the_new_web_page() {
	    Assert.assertEquals(NewTabPage.getTextNewPage(), "Welcome to the new page!");
	}
}
