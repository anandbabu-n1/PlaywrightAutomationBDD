package stepdefinitions;

import org.junit.Assert;

import com.microsoft.playwright.Page;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.FileUploadPage;

public class FileUploadSteps{
	
	FileUploadPage FileUploadPage = new FileUploadPage(DriverFactory.getPage());

	@Then("user uploads the {string} image and assert the image name successfully")
	public void user_uploads_the_image_and_assert_the_image_name_successfully(String string) {
	    FileUploadPage.performFileUpload(string);
	    FileUploadPage.verifyFileUpload(string);
	}

}
