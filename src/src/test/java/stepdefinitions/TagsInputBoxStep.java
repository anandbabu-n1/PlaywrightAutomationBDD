package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.TagsInputBoxPage;

public class TagsInputBoxStep {
	TagsInputBoxPage TagsInputBoxPage = new TagsInputBoxPage(DriverFactory.getPage());

	@When("user gets the number of tags needed")
	public void user_gets_the_number_of_tags_needed() {
	    TagsInputBoxPage.getTotalNumber();
	}
	@When("user enters the number of tags needed")
	public void user_enters_the_number_of_tags_needed() {
	    TagsInputBoxPage.enterTags();
	}
	@Then("user verifies no tags are needed")
	public void user_verifies_no_tags_are_needed() {
		Assert.assertEquals(TagsInputBoxPage.getTotalNumberAfterTag() , "0" );
	}
	
}
