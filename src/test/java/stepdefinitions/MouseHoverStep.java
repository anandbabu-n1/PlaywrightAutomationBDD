package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MouseHoverPage;
import pageobjects.PopUpPage;

public class MouseHoverStep{
	MouseHoverPage MouseHoverPage = new MouseHoverPage(DriverFactory.getPage());

	@When("hovers the mouse pointer above the poster")
	public void hovers_the_mouse_pointer_above_the_poster() {
	    MouseHoverPage.MouseHover();
	}
	@When("user gets the price of the poster")
	public void user_gets_the_price_of_the_poster() {
	    MouseHoverPage.GetPosterPrice();
	}


}
