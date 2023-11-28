package stepdefinitions;

import org.junit.Assert;

import com.microsoft.playwright.Page;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.FileDownloadPage;

public class DownloadFileSteps{
	
	FileDownloadPage FileDownloadPage = new FileDownloadPage(DriverFactory.getPage());

	@Then("user Downloads the file successfully")
	public void user_downloads_the_file_successfully() {
	    FileDownloadPage.verifyFileDownload();
	}

}
