package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.aventstack.extentreports.model.Log;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import factory.RequestManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {
	APIResponse response;
	RequestManager RequestManager = new RequestManager();


	@When("I send the request on the {string}")
	public void i_send_the_request_on_the(String string) {
		response=factory.RequestManager.getInstance().getRequest(string);

	}
	

	@Then("I get the response body of the request")
	public void i_get_the_response_body_of_the_request() throws IOException {
		System.out.println(factory.RequestManager.getInstance().getResponseBody());

	}

	@When("I send the Post call on the {string}")
	public void i_send_the_post_call_on_the(String string) {
		
		//final APIResponse response = factory.RequestManager.getInstance().postRequest(string, RequestOptions.create()
		//		.setData(employeeData));
		Assert.assertEquals(response.status(), 201);
		
	}

	@When("I send the Post call on the {string} with {string} and {string} as data")
	public void i_send_the_post_call_with_data(String endpoint, String name, String job) throws Exception {
			
		Map<String, Object> udata=factory.RequestManager.getInstance().userData(name, job);
		response = factory.RequestManager.getInstance().postRequest(endpoint, RequestOptions.create()
				.setData(udata));
				
	}

	@Then("I get the response status as success with response code {string}")
	public void i_get_the_response_status_as_success_with_response_code(String code) throws IOException {
		Assert.assertEquals(response.status(), Integer.parseInt(code));
		
		System.out.println(factory.RequestManager.getInstance().getResponseBody());

	}
	@Then("I get the response status as success")
	public void i_get_the_response_status_as_success() throws Exception {
		Assert.assertEquals(response.status(), 201);
		
		System.out.println(factory.RequestManager.getInstance().getResponseBody());

	}
	
	@When("I send the Put call on the {string} with {string} and {string} as data")
	public void i_send_the_put_call_on_the_with_and_as_data(String endpoint, String name, String job) {
		Map<String, Object> udata=factory.RequestManager.getInstance().userData(name, job);
		response = factory.RequestManager.getInstance().putRequest(endpoint, RequestOptions.create()
                .setData(udata));
	}
	
	@When("I send the patch call on the {string} with {string} and {string} as data")
	public void i_send_the_patch_call_on_the_with_and_as_data(String endpoint, String name, String job) {
		Map<String, Object> udata=factory.RequestManager.getInstance().userData(name, job);
		response = factory.RequestManager.getInstance().patchRequest(endpoint, RequestOptions.create()
                .setData(udata));
	}
	
	@When("I send the Delete call on the {string} with {string} and {string} as data")
	public void i_send_the_delete_call_on_the_with_and_as_data(String endpoint, String name, String job) {
		Map<String, Object> udata=factory.RequestManager.getInstance().userData(name, job);
		response = factory.RequestManager.getInstance().deleteRequest(endpoint, RequestOptions.create()
                .setData(udata));
	}
}
