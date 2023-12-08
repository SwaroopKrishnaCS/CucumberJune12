package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import com.base.TestBase;
import com.swaroop.utils.TestContext;

public class GetStoreStepDefinitions extends TestBase{

	
	

	@Given("the api is available")
	public void the_api_is_available() {
		System.out.println("Executing Given");
		baseURI = "http://localhost:3030/";
	}

	@When("the endpoint {string} is invoked")
	public void the_endpoint_is_invoked(String endPoint) {
		response = when().get(endPoint);
		context.setResponse(response);
	}

	@Then("the response should come with a status code of {int}")
	public void the_response_should_come_with_a_status_code_of(Integer statusCode) {
		context.getResponse().then().statusCode(statusCode);
	}
	
	
	@When("the endpoint {string} is invoked with {int}")
	public void the_endpoint_is_invoked_with(String endPoint, Integer storeId) {
		response = when().get(endPoint+String.valueOf(storeId));
	}
	

}
