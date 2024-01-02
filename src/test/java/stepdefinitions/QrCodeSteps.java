package stepdefinitions;

import java.io.IOException;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.QrCodePage;

public class QrCodeSteps {

	QrCodePage QrCodePage = new QrCodePage(DriverFactory.getPage());

	@When("user enters the {string} on the text field")
	public void user_enters_the_on_the_text_field(String string) throws Exception {
	    QrCodePage.enterText(string);
	}
	
	
	
	@Then("user validates the QR code for the text {string}")
	public void user_validates_the_qr_code_for_the_text(String filename) throws Exception, Exception {
		 Assert.assertEquals(QrCodePage.validateQR(filename), filename);
	}
	
	@Then("user downloads the QR code {string}")
	public void user_downloads_the_qr_code(String filename) throws IOException, Exception {
		 QrCodePage.downloadQR(filename);
	}

}
