package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.junit.Assert;
import pageobjects.IndexPage;
import utilities.WebActions;

public class IndexSteps {
    IndexPage IndexPage = new IndexPage(DriverFactory.getPage());

    @Given("user navigates to {string}")
    public void navigateToUrl(String url) {
        IndexPage.navigateToUrl(url);
    }


    @When("user clicks on {string} icon in main page")
    public void clickOnIcon(String iconName) {
        switch(iconName.toLowerCase()) {
        case("dynamic table"):
        	IndexPage.clickDynamicTable();
        	break;
        case("verify your account"):
        	IndexPage.clickVerifyYourAccount();
        	break;
        case("tags input box"):
        	IndexPage.clickTagsInputBox();
        	break;
        case("new tab"):
        	IndexPage.clickNewTab();
        	break;
        case("pop-up window"):
        	IndexPage.clickPopUp();
            break;
        case("upload file"):
        	IndexPage.clickUploadFile();
        	break;
        case("download file"):
        	IndexPage.clickDownloadFile();
        	break;
        case("mouse hover"):
        	IndexPage.clickMouseHover();
        	break;
        case("iframe"):
        	IndexPage.clickIframe();
        	break;
        case("qr code generator"):
        	IndexPage.clickQrCode();
        	break;
        }
        
        
    }


    @Then("^user verifies data as \"([^\"]*)\" in \"([^\"]*)\" row and \"([^\"]*)\" column from \"([^\"]*)\" sheet in \"([^\"]*)\" file")
    public void clickOnIcon(String expectedValue, int rowNum, int colNum, String sheetName, String fileName) {
        String actualValue = WebActions.getRowColValue(fileName, sheetName, rowNum, colNum);
        Assert.assertEquals(expectedValue, actualValue);
    }
    

    
    	
    	@Given("user has {string} file")
    	public void user_has_file(String string) {
    		try {
    			IndexPage.navigateToPdfUrl(string);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	@When("user opens pdf")
    	public void user_opens_pdf() {
    	    try {
				IndexPage.getpdfTotalPages();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	@Then("user gets the text on the pdf")
    	public void user_verifies_the_text_on_the_pdf() {
    	    try {
				IndexPage.getPdfText();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
}
}
