package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.When;
import pageobjects.DynamicTablePage;


public class DynamicTableSteps {
	
	DynamicTablePage DynamicTable = new DynamicTablePage(DriverFactory.getPage());
	
	
	
	@When("user gets the name of {string}")
	public void user_gets_the_name_of(String string) {
		System.out.println(DynamicTable.getName(string));
	}
}
