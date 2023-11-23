package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.VerifyYourAccountPage;


public class VerifyYourAccountSteps {
	VerifyYourAccountPage VerifyYourAccountPage = new VerifyYourAccountPage(DriverFactory.getPage());

	@When("user gets the confirmation code on the screen")
	public void user_gets_the_confirmation_code_on_the_screen() {
	    VerifyYourAccountPage.getConfirmationCode();
	}
	@When("user enters the confirmation code")
	public void user_enters_the_confirmation_code() {
	    VerifyYourAccountPage.enterConfirmationCode();
	}
	@Then("user gets the success message")
	public void user_gets_the_success_message() {
	    Assert.assertEquals(VerifyYourAccountPage.getMessage(), "Success");
	}

	
}
